import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("My Tables App");
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        root.getStylesheets().add(
                "https://fonts.googleapis.com/css2?family=Sacramento&family=Montserrat&display=swap");
        root.getStylesheets().add(getClass().getResource("./styles/styles.css").toString());

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("./icons/restaurant.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}