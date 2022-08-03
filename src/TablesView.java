import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TablesView extends Application {

    @FXML
    private AnchorPane mainFloorAPane;

    @FXML
    private AnchorPane patioAPane;

    @FXML
    private Tab mainFloorTab;

    @FXML
    private Tab patioTab;

    @FXML
    private TabPane tabPane;

    @FXML
    private ImageView tablesButton;

    @FXML
    private MainFloorStage mainFloorStage;

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

    public AnchorPane getMainFloorAPane() {
        return mainFloorAPane;
    }

    public AnchorPane getPatioAPane() {
        return patioAPane;
    }

    

    

}
