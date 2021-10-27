package com.utils;

public class User {

    private String name;
    private Privilege privilege;

    private User() {}

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
}
