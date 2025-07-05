package com.jap.task;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {

    // Declare attributes: users - a list of users, authenticatedUser - the currently authenticated user
    // Generate getter and setter methods for both attributes
    List<User> users;
    User authenticatedUser;

    public Authenticator() {
        // Initialize the users list and add a few users
        users = new ArrayList<User>();
        users.add(new User("John", "pass1"));
        users.add(new User("Jane", "pass2"));
        users.add(new User("Admin", "admin123"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public User getAuthenticatedUser() {
        // Return the currently authenticated user
        return authenticatedUser;
    }

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username The username to authenticate.
     * @param password The password associated with the username.
     * @return True if authentication is successful, false otherwise.
     */
    public boolean authenticateUser(String username, String password) {
        // Iterate through the users list
        // Check if the given username and password match any user's credentials
        // If a match is found, assign the user to the authenticatedUser and return true
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * Authenticates a new user with the given username and password.
     *
     * @param username The username of the new user.
     * @param password The password associated with the new user.
     * @return The authenticated user if authentication is successful, null otherwise.
     */
    public User authenticateNewUser(String username, String password) {
        User authenticatedUser;
        // Call the authenticateUser method to check if the new user's credentials are valid
        // If the authenticateUser method returns true, set authenticatedUser to the authenticated user
        // Display an appropriate message
        if (authenticateUser(username, password)) {
            System.out.println("Username already exists.");
            return null;
        }

        User newUser = new User(username, password);
        users.add(newUser);
        authenticatedUser = newUser;
        System.out.println("Authentication Successful: Welcome " + newUser.getUserName());
        return authenticatedUser;
    }
}
