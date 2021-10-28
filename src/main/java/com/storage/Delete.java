package com.storage;

import com.utils.Config;

import java.util.List;

public abstract class Delete {

    public abstract void deleteDirectory(String path, String directoryName);
    public abstract void deleteFile(String path, String fileName);
    public abstract void deleteAll(String rootPath);

    public void removeDirectory(String path, String directoryName) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")){  //ako korisnik ne zada path, brise se iz root dir
            deleteDirectory(Config.getConfig().getPath(), directoryName);
        }
        else {
            deleteDirectory(path, directoryName);
        }
    }

    public void removeDirectories(String path, List<String> directoryNames) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, brise se iz root dir
            for (String directoryName: directoryNames) {
                deleteDirectory(Config.getConfig().getPath(), directoryName);
            }
        }
        else {
            for (String directoryName: directoryNames) {
                deleteDirectory(path, directoryName);
            }
        }
    }

    public void removeFile(String path, String fileName) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, brise se iz root dir
            deleteFile(Config.getConfig().getPath(), fileName);
        }
        else {
            deleteFile(path, fileName);
        }
    }

    public void removeFiles(String path, List<String> fileNames) {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije

        if (path == null || path.equals("")){  //ako korisnik ne zada path, brise se iz root dir
            for (String fileName: fileNames) {
                deleteFile(Config.getConfig().getPath(), fileName);
            }
        }
        else {
            for (String fileName: fileNames) {
                deleteFile(path, fileName);
            }
        }
    }

    public void removeAll() {
        // TODO - proveriti da li je korisnig ulogovan i da li ima privilegije
        deleteAll(Config.getConfig().getPath());
    }
}
