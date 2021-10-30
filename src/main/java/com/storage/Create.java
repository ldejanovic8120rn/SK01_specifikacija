package com.storage;

import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

public abstract class Create {

    // root -> A -> A1 -> file.txt
    /**
     * @param path putanja do fajla
     * @param directoryName ime direktorijuma
     **/
    public abstract void saveDirectory(String path, String directoryName);
    public abstract void saveFile(String path, String fileName);

    public void createDirectory(String path, String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")){  //ako korisnik ne zada path, smesta se u root dir
            saveDirectory(StorageInfo.getStorageInfo().getConfig().getPath(), directoryName);
        }
        else {
            saveDirectory(path, directoryName);
        }
    }

    public void createDirectories(String path, List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, smesta se u root dir
            for (String directoryName: directoryNames) {
                saveDirectory(StorageInfo.getStorageInfo().getConfig().getPath(), directoryName);
            }
        }
        else {
            for (String directoryName: directoryNames) {
                saveDirectory(path, directoryName);
            }
        }
    }

    public void createFile(String path, String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, smesta se u root dir
            saveFile(StorageInfo.getStorageInfo().getConfig().getPath(), fileName);
        }
        else {
            saveFile(path, fileName);
        }
    }

    public void createFiles(String path, List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, smesta se u root dir
            for (String fileName: fileNames) {
                saveFile(StorageInfo.getStorageInfo().getConfig().getPath(), fileName);
            }
        }
        else {
            for (String fileName: fileNames) {
                saveFile(path, fileName);
            }
        }
    }

}
