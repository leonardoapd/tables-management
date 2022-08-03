
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.DishController;
import controller.OrderController;
import entities.Dish;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Button loadButton;

    @FXML
    private TextField orderNumberTF;

    @FXML
    private Label tableNumberSelectedLabel;

    @FXML
    private Label totalLabel;

    /*
     * An arraylist for store the dishes names and show them in the listview
     * component
     */
    private ArrayList<String> foodDishes = new ArrayList<>();

    /* An instance of the Controller of the Dish */
    private DishController dishController = new DishController();

    /* An instance of the Controller of the Order */
    private OrderController orderController = new OrderController();

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    public void addButtonPressed(ActionEvent event) {

        /* Get the name of the dish selected and add it to the textarea */
        String selectedDish = dishList.getSelectionModel().getSelectedItem();

        /* Instance a Dish */
        Dish dish = null;

        /*
         * Check if the selected dish is in the model data base array list
         */
        if (dishController.searchDish(selectedDish) != null) {
            dish = dishController.searchDish(selectedDish);
            /* Increase the quantity of dish when the button is pressed */
            dish.setQuantity(dish.getQuantity() + 1);

            /*
             * If the dish is already in the list (text area), increase the quantity of it
             */
            for (String line : orderList.getText().split("\n")) {
                if (line.contains(selectedDish)) {
                    orderList.deleteText(orderList.getText().indexOf(line),
                            orderList.getText().indexOf(line) + line.length() + 1);
                }
            }

            /* Add the dish to the textarea */
            // Show the total with two decimals
            String total = String.format("%.2f", dish.getQuantity() * dish.getPrice());
            orderList.appendText(
                    selectedDish + " x" + dish.getQuantity() + ": \t$"
                            + total + "\n");
        }

        /* Show the total of the sum amount in the total label */
        totalLabel.setText(String.format("%.2f", getTotal()));

    }

    private double getTotal() {
        double total = 0;
        for (String line : orderList.getText().split("\n")) {
            /* If the line contains , change it for , */
            if (line.contains(",")) {
                line = line.replace(",", ".");
            }
            if (line.contains("$")) {
                total += Double.parseDouble(line.substring(line.indexOf("$") + 1));
            }
        }
        return total;
    }

    @FXML
    public void goBackButtonPressed(ActionEvent event) throws Exception {
        /* Close the actual stage */
        Stage primaryStage = (Stage) goBackButton.getScene().getWindow();
        primaryStage.close();

        /* Load the previous stage */
        Parent root = FXMLLoader.load(getClass().getResource("TablesView.fxml"));
        Scene scene = new Scene(root);
        primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle("My Tables App");
        primaryStage.getIcons().add(new Image("./icons/restaurant.png"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void deleteButtonPressed(ActionEvent event) {
        /* Get the name of the dish selected and add it to the textarea */
        String selectedDish = dishList.getSelectionModel().getSelectedItem();

        /* Instance a Dish */
        Dish dish = null;

        /*
         * Compare if the selected dish is in the model data base array list
         */
        if (dishController.searchDish(selectedDish) != null) {
            dish = dishController.searchDish(selectedDish);

            /*
             * If the dish is in the model data base array list, then delete it from the
             * text area
             */
            for (String line : orderList.getText().split("\n")) {
                if (line.contains(selectedDish)) {
                    orderList.deleteText(orderList.getText().indexOf(line),
                            orderList.getText().indexOf(line) + line.length() + 1);
                }
            }

            /*
             * If the quantity is greater than 1 then decrement the quantity of dishes shown
             * in the text area
             */
            if (dish.getQuantity() > 0) {
                // Show the total with two decimals
                dish.setQuantity(dish.getQuantity() - 1);
                if (dish.getQuantity() != 0) {
                    String total = String.format("%.2f", dish.getQuantity() * dish.getPrice());
                    orderList.appendText(
                            selectedDish + " x" + dish.getQuantity() + ": \t$"
                                    + total + "\n");
                }
            }

        }

        /* Show the total of the sum amount in the total label */
        totalLabel.setText(String.format("%.2f", getTotal()));

    }

    @FXML
    public void printButtonPressed(ActionEvent event) {
        // /* Create a printer job object */
        // PrinterJob printerJob = PrinterJob.createPrinterJob();
        // /* If the printer job object is not null, print the table */
        // if (printerJob != null) {
        // printerJob.showPrintDialog(null);
        // printerJob.printPage(orderList);
        // printerJob.endJob();
        // }

        /* Check if the ordertextfield is empty */
        if (orderNumberTF.getText().isEmpty()) {
            /* Show a error message */
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a table number");
            alert.showAndWait();
        } else {
            /* Build a path to create the file of the order with the order number */

            /* Create a file with order number on its name */
            String path = "Order" + orderNumberTF.getText() + ".txt";

            /* Get the content of the file */
            /* Get the table number */
            String tableNumber = tableNumberSelectedLabel.getText();

            /* Get the order text */
            String orderText = orderList.getText();
            /* Delete the \n from the orderText */
            orderText = orderText.replace("\n", ";");

            /* Get the total */
            String total = String.format("%.2f", getTotal());

            String order = tableNumber + "/" + orderText + "/" + total;
            orderController.createOrder(order, path);

            /* Show a message that the order was added */
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Saved");
            alert.setHeaderText("Order Saved");
            alert.setContentText("The order was saved to the database");
            alert.showAndWait();
        }
    }

    @FXML
    void loadButtonPressed(ActionEvent event) {
        /* Check if the ordertextfield is empty */
        if (orderNumberTF.getText().isEmpty()) {
            /* Show a error message */
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a table number");
            alert.showAndWait();
        } else {
            /*
             * Use a Scanner object to search the file in the folder with the name Order +
             * orderNumberTF
             */
            try {

                String path = "Order" + orderNumberTF.getText() + ".txt";

                String[] order = orderController.loadOrder(path);

                /* Get the table number */
                String tableNumber = order[0];
                /* Get the order text */
                String orderText = order[1];
                /* Get the total */
                String total = order[2];

                /* Set the table number label */
                tableNumberSelectedLabel.setText(tableNumber);
                /* Set the order text area */
                orderText = orderText.replace(";", "\n");
                orderList.setText(orderText);
                /* Set the total label */
                totalLabel.setText(total);
            } catch (Exception e) {
                /* Show a error message */
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("The order does not exist");
                alert.showAndWait();
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * Get the dishes from the model data base array list and add them to the
         * observable
         * list to show them in the listview component
         */
        foodDishes = dishController.getAllDishNames();
        ObservableList<String> dishesCollection = FXCollections.observableArrayList(foodDishes);
        dishList.setItems(dishesCollection);

        /*
         * Get the table number selected and show it in the label component
         */
        tableNumberSelectedLabel.setText("Table " + MainFloorStage.getTableNumber() + " Selected");
    }

}
