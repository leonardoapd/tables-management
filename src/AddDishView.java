import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AddDishView extends Application implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> dishList;

    @FXML
    private Button goBackButton;

    @FXML
    private TextArea orderList;

    @FXML
    private Button printButton;

    @FXML
    private Label tableNumberSelectedLabel;

    private int counter;

    /* Declare a String of 20 different food dishes */
    private String[] foodDishes = { "Pizza", "Pasta", "Salad", "Steak", "Chicken", "Soup", "Sandwich", "Burger",
            "Fries", "Cake", "Coffee", "Tea", "Coke", "Water", "Juice", "Milk", "Soda", "Chips", "Candy", "Hot Dog",
            "Pancakes", "Fried Shrimp", "Grill Steak", "Salmon", "Onion Rings", "Bacon", "Sausage", "Eggs",
            "Biscuit", "Tunna Salad", "Nuggets" };

    /*
     * Declare an Array of 20 different food dishes of the object dish.java with
     * their names and prices
     */
    private Dish[] dishes = { new Dish("Pizza", 15.99), new Dish("Pasta", 23.99), new Dish("Salad", 7.99),
            new Dish("Steak", 37.99),
            new Dish("Chicken", 16.99), new Dish("Soup", 4.99), new Dish("Sandwich", 8.99), new Dish("Burger", 15.99),
            new Dish("Fries", 3.99), new Dish("Cake", 4.99), new Dish("Coffee", 2.99), new Dish("Tea", 2.99),
            new Dish("Coke", 3.99), new Dish("Water", 1.99), new Dish("Juice", 1.99), new Dish("Milk", 2.99),
            new Dish("Soda", 3.99), new Dish("Chips", 1.99), new Dish("Candy", 0.99), new Dish("Hot Dog", 7.99),
            new Dish("Pancakes", 5.99), new Dish("Fried Shrimp", 23.99), new Dish("Grill Steak", 43.99),
            new Dish("Salmon", 43.99),
            new Dish("Onion Rings", 5.99), new Dish("Bacon", 3.99), new Dish("Sausage", 3.99), new Dish("Eggs", 6.99),
            new Dish("Biscuit", 4.99), new Dish("Tunna Salad", 6.99), new Dish("Nuggets", 8.99) };

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    public void addButtonPressed(ActionEvent event) {
        // ObservableList<String> selectedDishes = FXCollections.observableArrayList();
        // selectedDishes.add(dishesCBox.getSelectionModel().getSelectedItem());
        // System.out.println(dishesCBox.getSelectionModel().getSelectedItem());
        // dishTable.setItems(selectedDishes);
        /* Get the name of the dish selected and add it to the textarea */
        String selectedDish = dishList.getSelectionModel().getSelectedItem();
        /*
         * Look for the selectedDish in the dishes array to add the name and price to
         * the textarea
         */
        for (int i = 0; i < dishes.length; i++) {
            if (selectedDish.equals(dishes[i].getName())) {
                // Validate if the dish is already in the order list or not and count the number
                // of times it is added

                for (String line : orderList.getText().split("\n")) {
                    if (line.contains(selectedDish)) {
                        counter++;
                        orderList.deleteText(orderList.getText().indexOf(line),
                                orderList.getText().indexOf(line) + line.length() + 1);
                        orderList.appendText(
                                selectedDish + " x" + counter + ": \t$" + counter * dishes[i].getPrice() + "\n");

                    } else {
                        counter = 1;
                        orderList.appendText(selectedDish + " x" + counter + ": \t$" + dishes[i].getPrice() + "\n");
                    }
                }

                // if (orderList.getText().contains(selectedDish)) {
                // counter = 0;
                // for (int j = 0; j < orderList.getText().length(); j++) {
                // if (orderList.getText().charAt(j) == '\n') {
                // counter++;
                // }
                // }
                // orderList.appendText(selectedDish + " x " + (counter + 1) + "\n");
                // } else {
                // orderList.appendText(selectedDish + " x 1\n");
                // }

                // orderList.appendText(selectedDish + "\t $" + dishes[i].getPrice() + "\n");

            }
        }

    }

    @FXML
    public void goBackButtonPressed(ActionEvent event) {
        // /* Create a printer job object */
        // PrinterJob printerJob = PrinterJob.createPrinterJob();
        // /* If the printer job object is not null, print the table */
        // if (printerJob != null) {
        // printerJob.showPrintDialog(null);
        // printerJob.printPage(dishTable);
        // printerJob.endJob();
        // }
    }

    @FXML
    public void deleteButtonPressed(ActionEvent event) {
        /* Get the name of the dish selected and add it to the textarea */
        String selectedDish = dishList.getSelectionModel().getSelectedItem();
        for (String line : orderList.getText().split("\n")) {
            if (line.contains(selectedDish)) {
                // Set backspace to delete the selected line from the textarea counting the
                // length of the line
                orderList.deleteText(orderList.getText().indexOf(line),
                        orderList.getText().indexOf(line) + line.length() + 1);
                // orderList.setText(orderList.getText().replace(line, ""));

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counter = 1;
        ObservableList<String> dishesCollection = FXCollections.observableArrayList(foodDishes);
        dishList.setItems(dishesCollection);
    }

}
