package com.storage;

import com.exception.ConfigException;
import com.exception.LogException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.utils.Config;
import com.utils.Privilege;
import com.utils.StorageInfo;
import com.utils.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Class that is used for initialising Storage.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public abstract class Storage {

    /**
     * Method that gets Config file in storage
     * @param path Storage path
     * @return Config file
     * @throws Exception
     */
    public abstract File getConfig(String path) throws Exception;

    /**
     * Method that gets Users file in storage
     * @param path Storage path
     * @return Users file
     * @throws Exception
     */
    public abstract File getUsers(String path) throws Exception;

    /**
     * Method that creates a new storage
     * @param path Path to new storage
     * @param storageName New storage name
     * @param adminName Storage admin username
     * @param adminPsw Storage adnim password
     * @throws Exception if user isn't logged
     */
    public abstract void createStorage(String path, String storageName, String adminName, String adminPsw) throws Exception;

    /**
     * Method that changes Config file
     * @param path Storage path
     * @param maxSize Storage size limit
     * @param maxNumOfFiles Storage file number limit
     * @param unsupportedFiles Storage unsupported file exceptions
     * @throws Exception if Config file can't be read
     */
    public abstract void editConfig(String path, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) throws Exception;

    /**
     * Method that adds new user to Users file
     * @param path Storage path
     * @param name New user's username
     * @param password New user's password
     * @param privilege New user's privilege level
     * @throws Exception if Users file can't be read
     */
    public abstract void editUsers(String path, String name, String password, Privilege privilege) throws Exception;

    /**
     * Method that adds new user to storage.
     * @param name New user's name
     * @param password New user's password
     * @param privilege New user's privilege level
     * @throws Exception if user doesn't have ADMIN privilege
     */
    public void addUser(String name, String password, Privilege privilege) throws Exception {
        if(StorageInfo.getStorageInfo().getUser().getPrivilege() != Privilege.ADMIN) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        editUsers(StorageInfo.getStorageInfo().getConfig().getPath(), name, password, privilege);
    }

    /**
     * Method that configures storage settings.
     * @param maxSize New storage size limit
     * @param maxNumOfFiles New storage file number limit
     * @param unsupportedFiles New storage unsupported file extension(s)
     * @throws Exception if user doesn't have ADMIN privilege
     */
    public void configure(String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) throws Exception {
        if(StorageInfo.getStorageInfo().getUser().getPrivilege() != Privilege.ADMIN) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        boolean arg1 = StorageInfo.getStorageInfo().getConfig().checkArgs(maxSize);
        boolean arg2 = StorageInfo.getStorageInfo().getConfig().checkArgs(maxNumOfFiles);

        if (unsupportedFiles != null) {
            unsupportedFiles.addAll(StorageInfo.getStorageInfo().getConfig().getUnsupportedFiles());
        }

        if (arg1 && arg2) {
            editConfig(StorageInfo.getStorageInfo().getConfig().getPath(), maxSize, maxNumOfFiles, unsupportedFiles);
            readConfig(getConfig(StorageInfo.getStorageInfo().getConfig().getPath()));
        }

    }

    /**
     * Method that logs user to storage.
     * @param path Storage path
     * @param name User's username
     * @param password User's password
     * @throws Exception if storage doesn't exist
     */
    public void logToStorage(String path, String name, String password) throws Exception {
        File config = getConfig(path);
        File users = getUsers(path);

        if (config == null || users == null) {
            throw new ConfigException("Storage not defined");
        }

        readConfig(config);
        readUsers(users, name, password);
    }

    /**
     * Method that logs out current user.
     */
    public void logOut() {
        StorageInfo.getStorageInfo().init();
    }

    private void readConfig(File configFile) {
        Gson gson = new Gson();

        try {
            Reader reader = new FileReader(configFile);
            Config config = gson.fromJson(reader, Config.class);

            StorageInfo.getStorageInfo().setConfig(config);
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUsers(File usersFile, String name, String password) {
        Reader reader = null;

        try {
            Gson gson = new Gson();
            reader = new FileReader(usersFile);
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(true);
            List<User> users = gson.fromJson(jsonReader, new TypeToken<List<User>>() {}.getType());

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
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
