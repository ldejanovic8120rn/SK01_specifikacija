package com.storage;

import com.exception.LogException;
import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

/**
 * Class that is used for creating files and directories.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public abstract class Create {

    public abstract void saveDirectory(String directoryName) throws Exception;
    public abstract void saveFile(String fileName) throws Exception;

    public void createDirectory(String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        saveDirectory(directoryName);
    }

    public void createDirectories(List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String directoryName: directoryNames) {
            saveDirectory(directoryName);
        }
    }

    public void createFile(String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        saveFile(fileName);
    }

    public void createFiles(List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String fileName: fileNames) {
            saveFile(fileName);
        }

    }

}
