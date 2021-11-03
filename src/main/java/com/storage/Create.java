package com.storage;

import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

public abstract class Create {

    public abstract void saveDirectory(String directoryName) throws Exception;
    public abstract void saveFile(String fileName) throws Exception;

    // createDir pathToStorage.../A/A1/nesto
    public void createDirectory(String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        saveDirectory(directoryName);
    }

    public void createDirectories(List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        for (String directoryName: directoryNames) {
            saveDirectory(directoryName);
        }
    }

    public void createFile(String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        saveFile(fileName);
    }

    public void createFiles(List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        for (String fileName: fileNames) {
            saveFile(fileName);
        }

    }

}
