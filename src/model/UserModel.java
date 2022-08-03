package model;

import java.util.ArrayList;

import entities.User;

public class UserModel {

    private ArrayList<User> userList;

    /* Constructor */
    public UserModel() {
        userList = new ArrayList<User>() {
            {
                add(new User("admin", "admin"));
                add(new User("user", "user"));
            }
        };
    }

    /**
     * Method to validate user login
     * 
     * @param User
     * 
     */
    public boolean validateUser(User user) {
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to search user in the userList
     * 
     * @return User
     */
    public User searchUser(String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }




}
