import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TablesView extends Application {

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

    @FXML
    private Tab mainFloorTab;

    @FXML
    private Tab patioTab;

    @FXML
    private ImageView patioTable1;

    @FXML
    private ImageView patioTable2;

    @FXML
    private ImageView patioTable3;

    @FXML
    private ImageView patioTable4;

    @FXML
    private ImageView patioTable5;

    @FXML
    private ImageView patioTable6;

    @FXML
    private ImageView patioTable7;

    @FXML
    private ImageView patioTable8;

    @FXML
    private ImageView patioTable9;

    @FXML
    private ImageView tablesButton;

    @FXML
    private TabPane tabPane;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("My Tables App");
        Parent root = FXMLLoader.load(getClass().getResource("TablesView.fxml"));
        root.getStylesheets().add(
                "https://fonts.googleapis.com/css2?family=Sacramento&family=Montserrat&display=swap");
        root.getStylesheets().add(getClass().getResource("./styles/styles.css").toString());

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("./icons/restaurant.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void onTableClick(MouseEvent event) throws Exception {
        try {
            mainFloorTab.setContent((Node) FXMLLoader.load(getClass().getResource("AddDishView.fxml")));
            
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

}
