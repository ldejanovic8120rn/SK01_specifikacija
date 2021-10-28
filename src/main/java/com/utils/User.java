package com.utils;

public class User {

    private String name;
    private String password;
    private Privilege privilege;

    public User() {
        name = "";
        privilege = null;
    }

    public User(String name, String password, Privilege privilege) {
        this.name = name;
        this.password = password;
        this.privilege = privilege;
    }

    public boolean isLogged() {
        return !name.equals("") && !password.equals("") && privilege != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
