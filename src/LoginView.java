
import java.io.IOException;

import controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginView {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private ImageView restaurantIcon;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;

    /* Get the event when the button is pressed */
    @FXML
    void loginButtonPressed(ActionEvent event) {
        /* Check Login */
        checkLogin();
    }

    /* Get the event when enter is pressed */
    @FXML
    void loginButtonEnterPressed(KeyEvent event) {
        /* Validate if the enter key was pressed */
        if (event.getCode().equals(javafx.scene.input.KeyCode.ENTER)) {
            /* Check Login */
            checkLogin();
        }

    }

    /* Static method to check login */
    public void checkLogin() {
        /* Create an object of LoginController */
        LoginController loginController = new LoginController();
        /* Get the inputs from the text fields */
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        /* Call the login method */
        boolean isLogin = loginController.login(username, password);
        if (isLogin) {
            /* Log in successful */
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            TablesView tablesView = new TablesView();
            try {
                tablesView.start(new Stage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            /* Login failed */
            passwordField.setText("");
            usernameTextField.setText("");
            passwordField.setStyle("-fx-border-color: red");
            usernameTextField.setStyle("-fx-border-color: red");
        }
    }

}
