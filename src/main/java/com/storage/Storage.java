package com.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.utils.Config;
import com.utils.Privilege;
import com.utils.StorageInfo;
import com.utils.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public abstract class Storage {

    public abstract File getConfig(String path);
    public abstract File getUsers(String path);
    public abstract void createStorage(String path, String storageName, String adminName, String adminPsw);
    public abstract void editConfig(String path, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles);
    public abstract void editUsers(String path, String name, String password, Privilege privilege);

    public void addUser(String name, String password, Privilege privilege) throws Exception {
        if(StorageInfo.getStorageInfo().getUser().getPrivilege() != Privilege.ADMIN){
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        // A/A1/MyStorage
        editUsers(StorageInfo.getStorageInfo().getConfig().getPath(), name, password, privilege);
    }

    public void configure(String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) throws Exception {
        if(StorageInfo.getStorageInfo().getUser().getPrivilege() != Privilege.ADMIN){
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        editConfig(StorageInfo.getStorageInfo().getConfig().getPath(), maxSize, maxNumOfFiles, unsupportedFiles);
        StorageInfo.getStorageInfo().getConfig().changeConfig(maxSize, maxNumOfFiles, unsupportedFiles);
    }

    public void logToStorage(String path, String name, String password) throws Exception {
        File config = getConfig(path);
        File users = getUsers(path);

        if (config == null || users == null){
            throw new Exception("Nije definisano skladiste");
        }

        readConfig(config);
        readUsers(users, name, password);
    }

    public void logOut() {
        StorageInfo.getStorageInfo().init();
    }

    public void readConfig(File configFile) {
        Gson gson = new Gson();

        try {
            Reader reader = new FileReader(configFile);
            Config config = gson.fromJson(reader, Config.class);

            StorageInfo.getStorageInfo().setConfig(config);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUsers(File usersFile, String name, String password) {
        Reader reader = null;

        try {
            Gson gson = new Gson();
            reader = new FileReader(usersFile);
            List<User> users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());

            for (User user: users) {
                if (user.getName().equals(name) && user.getPassword().equals(password)) {
                    StorageInfo.getStorageInfo().setUser(user);
                    return;
                }
            }

            logOut();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
