package com.automation.web.data;

/**
 * User class to provide basic data for creating an account
 * @author js.lozano
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * Constructor
     * @param firstName String
     * @param lastName String
     * @param email String
     * @param password String
     */
    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * Get firstname
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set firstname
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get lastname
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set lastname
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
