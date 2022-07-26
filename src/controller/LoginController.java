package controller;

public class LoginController {
    /* Login Controller */
    public LoginController() {
    }

    public boolean login(String username, String password) {
        /* Login method */
        boolean isLogin = false;
        if (username.equals("admin") && password.equals("admin")) {
            /* Login successful */
            System.out.println("Login successful");
            isLogin = true;
        } else {
            /* Login failed */
            System.out.println("Login failed");
            isLogin = false;
        }
        return isLogin;
    }

}
