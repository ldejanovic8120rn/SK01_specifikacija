package com.utils;

public class User {

    private String name;
    private Privilege privilege;

    private User() {
        name = "";
        privilege = null;
    }

    private static final class UserHolder {
        static final User user = new User();
    }

    public static User getUser() {
        return UserHolder.user;
    }

    public void logIn(String name, Privilege privilege) {
        this.name = name;
        this.privilege = privilege;
    }

    public void resetUser() {
        name = "";
        privilege = null;
    }

    public boolean isLogged() {
        return !name.equals("") && privilege != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
