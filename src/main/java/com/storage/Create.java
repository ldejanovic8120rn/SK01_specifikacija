package com.storage;

import com.utils.StorageInfo;

import java.util.List;

public abstract class Create {

    // root -> A -> A1 -> file.txt
    public abstract void saveDirectory(String path, String directoryName);
    public abstract void saveFile(String path, String fileName);

    public void createDirectory(String path, String directoryName) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")){  //ako korisnik ne zada path, smesta se u root dir
            saveDirectory(StorageInfo.getStorageInfo().getConfig().getPath(), directoryName);
        }
        else {
            saveDirectory(path, directoryName);
        }
    }

    public void createDirectories(String path, List<String> directoryNames) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

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

    public void createFile(String path, String fileName) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, smesta se u root dir
            saveFile(StorageInfo.getStorageInfo().getConfig().getPath(), fileName);
        }
        else {
            saveFile(path, fileName);
        }
    }

    public void createFiles(String path, List<String> fileNames) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

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
