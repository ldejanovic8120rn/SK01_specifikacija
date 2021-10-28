package com.storage;

import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

public abstract class Delete {

    public abstract void deleteDirectory(String path, String directoryName);
    public abstract void deleteFile(String path, String fileName);
    public abstract void deleteAll(String rootPath);

    public void removeDirectory(String path, String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")){  //ako korisnik ne zada path, brise se iz root dir
            deleteDirectory(StorageInfo.getStorageInfo().getConfig().getPath(), directoryName);
        }
        else {
            deleteDirectory(path, directoryName);
        }
    }

    public void removeDirectories(String path, List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, brise se iz root dir
            for (String directoryName: directoryNames) {
                deleteDirectory(StorageInfo.getStorageInfo().getConfig().getPath(), directoryName);
            }
        }
        else {
            for (String directoryName: directoryNames) {
                deleteDirectory(path, directoryName);
            }
        }
    }

    public void removeFile(String path, String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, brise se iz root dir
            deleteFile(StorageInfo.getStorageInfo().getConfig().getPath(), fileName);
        }
        else {
            deleteFile(path, fileName);
        }
    }

    public void removeFiles(String path, List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        if (path == null || path.equals("")) {  //ako korisnik ne zada path, brise se iz root dir
            for (String fileName: fileNames) {
                deleteFile(StorageInfo.getStorageInfo().getConfig().getPath(), fileName);
            }
        }
        else {
            for (String fileName: fileNames) {
                deleteFile(path, fileName);
            }
        }
    }

    public void removeAll() throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new Exception("Korisnik nije logovan ili nema privilegiju");
        }

        deleteAll(StorageInfo.getStorageInfo().getConfig().getPath());
    }
}
