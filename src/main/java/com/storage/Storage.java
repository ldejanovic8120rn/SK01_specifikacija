package com.storage;

import com.utils.Config;
import com.utils.User;

import java.io.File;

public abstract class Storage {

    public abstract File getConfig(String path);
    public abstract File getUsers(String path);
    public abstract void createStorage(String path, String storageName);
    public abstract void saveConfig(String path, File config);
    public abstract void saveUsers(String path, File users);

    public void createStorage(String path, String storageName, String name, String password) {
        createStorage(path, storageName);

        // TODO - kreitati users.json i config.json
        File config = null;
        File users = null;

        saveConfig(path + "/" + storageName, config);
        saveUsers(path + "/" + storageName, users);

    }

    public void logToStorage(String path, String name, String password) {
        File config = getConfig(path);
        File users = getUsers(path);

        if (config == null || users == null){
            // TODO exception - nije skladiste
            return;
        }

        readConfig(config);
        readUsers(users);
    }

    public void logOut() {
        Config.getConfig().resetConfig();
        User.getUser().resetUser();
    }

    public void readConfig(File config) {
        // TODO initConfig()
    }

    public void readUsers(File users) {
        // TODO logIn()
    }

}
