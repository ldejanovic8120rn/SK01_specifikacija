package com.storage;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.utils.Config;
import com.utils.Privilege;
import com.utils.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public abstract class Storage {

    public abstract File getConfig(String path);
    public abstract File getUsers(String path);
    public abstract void createStorage(String path, String storageName, String adminName, String adminPsw);
    public abstract void editConfig(String path, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles);
    public abstract void editUsers(String path, String name, String password, Privilege privilege);

    public void addUser(String name, String password, Privilege privilege) {
        if(User.getUser().getPrivilege() != Privilege.ADMIN){
            // TODO - exception - nema privilegiju
            return;
        }

        // A/A1/MyStorage
        editUsers(Config.getConfig().getPath(), name, password, privilege);
    }

    public void configure(String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) {
        if(User.getUser().getPrivilege() != Privilege.ADMIN){
            // TODO - exception - nema privilegiju
            return;
        }

        editConfig(Config.getConfig().getPath(), maxSize, maxNumOfFiles, unsupportedFiles);
        Config.getConfig().changeConfig(maxSize, maxNumOfFiles, unsupportedFiles);
    }

    public void logToStorage(String path, String name, String password) {
        File config = getConfig(path);
        File users = getUsers(path);

        if (config == null || users == null){
            // TODO exception - nije skladiste
            return;
        }

        readConfig(config);
        readUsers(users, name, password);
    }

    public void logOut() {
        Config.getConfig().resetConfig();
        User.getUser().resetUser();
    }

    public void readConfig(File config) {

        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(config));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Review data = gson.fromJson(reader, Review.class);
        data.toScreen(); // prints to screen some values

        // TODO initConfig() - iscitati config.json i inisijalizovati Config klasu
    }

    public void readUsers(File users, String name, String password) {
        // TODO logIn() - iscitati users.json i proveriti da li se nalazi user sa zadatim kredencijalima i inicijalizovati User klasu
    }

}
