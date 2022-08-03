
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainFloorStage {

    @FXML
    private ImageView mFloorTable1;

    @FXML
    private ImageView mFloorTable2;

    @FXML
    private ImageView mFloorTable3;

    @FXML
    private ImageView mFloorTable4;

    @FXML
    private ImageView mFloorTable5;

    @FXML
    private ImageView mFloorTable6;

    @FXML
    private ImageView mFloorTable7;

    @FXML
    private ImageView mFloorTable8;

    @FXML
    private ImageView mFloorTable9;

    private static int tableNumber;

    @FXML
    void onTableClick(MouseEvent event) throws Exception {
        /* Get the id from the table clicked */
        String id = ((ImageView) event.getSource()).getId();
        /* Get the number of the table clicked */
        tableNumber = Integer.parseInt(id.substring(id.length() - 1));
        /* Close the previous stage */
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        /* Open Add Dish View */
        Parent root = FXMLLoader.load(getClass().getResource("AddDishView.fxml"));
        Scene scene = new Scene(root);
        primaryStage = new Stage();
        primaryStage.setTitle("Edit Order");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("./icons/restaurant.png"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static int getTableNumber() {
        return tableNumber;
    }
}
