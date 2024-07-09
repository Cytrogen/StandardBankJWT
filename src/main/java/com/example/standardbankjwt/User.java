package com.example.standardbankjwt;

/**
 * Represents a user in the system.
 * This class encapsulates user authentication information.
 *
 * @author Cytrogen
 * @version 1.0
 * @since 2024-07-09
 */
public class User {

    /** The username of the user. */
    private String username;

    /** The password of the user. */
    private String password;

    /**
     * Gets the username of the user.
     *
     * @return The username as a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}