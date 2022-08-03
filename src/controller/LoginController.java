package controller;

import entities.User;
import model.UserModel;

public class LoginController {

    private final UserModel userModel;
    private User user;

    /* Login Controller */
    public LoginController() {
        this.userModel = new UserModel();
    }

    /* Validate user login */
    public boolean login(String username, String password) {
        try {
            user = new User(username, password);
            return userModel.validateUser(user);
        } catch (Exception e) {
            return false;
        }
    }

}
