package com.storage;

import com.exception.LogException;
import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

public abstract class Delete {

    public abstract void deleteDirectory(String directoryName) throws Exception;
    public abstract void deleteFile(String fileName) throws Exception;
    public abstract void deleteAll(String rootPath) throws Exception;

    public void removeDirectory(String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteDirectory(directoryName);
    }

    public void removeDirectories(List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String directoryName: directoryNames) {
            deleteDirectory(directoryName);
        }

    }

    public void removeFile(String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteFile(fileName);
    }

    public void removeFiles(List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String fileName: fileNames) {
            deleteFile(fileName);
        }
    }

    public void removeAll() throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteAll(StorageInfo.getStorageInfo().getConfig().getPath());
    }
}
