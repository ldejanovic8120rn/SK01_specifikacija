package com.utils;

/**
 * Class that is used for storing user data for current user.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public class User {

    private String name;
    private String password;
    private Privilege privilege;

    /**
     * Creates User without any fields set.
     */
    public User() {
        name = "";
        privilege = null;
    }

    /**
     * Ceates user with all specified fields.
     * @param name User's username.
     * @param password User's password.
     * @param privilege User's privilege level.
     */
    public User(String name, String password, Privilege privilege) {
        this.name = name;
        this.password = password;
        this.privilege = privilege;
    }

    /**
     * Checks if there is a logged use.
     * @return true if user is logged, or false if isn't.
     */
    public boolean isLogged() {
        return !name.equals("") && !password.equals("") && privilege != null;
    }

    /**
     * Getter method for username.
     * @return User's username.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for username.
     * @param name User's username.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for password.
     * @return User's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     * @param password User's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for privilege.
     * @return User's privilege level.
     */
    public Privilege getPrivilege() {
        return privilege;
    }

    /**
     * Setter method for privilege.
     * @param privilege User's privilege level.
     */
    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
