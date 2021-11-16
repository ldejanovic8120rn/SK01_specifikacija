package com.storage;

import com.exception.LogException;
import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.List;

/**
 * Class that is used for deleting files and directories.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public abstract class Delete {

    /**
     * Method that deletes directory at given path.
     * @param directoryName path to directory
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public abstract void deleteDirectory(String directoryName) throws Exception;

    /**
     * Method that deletes file at given path
     * @param fileName path to file
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public abstract void deleteFile(String fileName) throws Exception;

    /**
     * Method that deletes everything in storage
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public abstract void deleteAll(String rootPath) throws Exception;

    /**
     * Method that deletes directory at given path.
     * @param directoryName path to directory
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public void removeDirectory(String directoryName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteDirectory(directoryName);
    }

    /**
     * Method that deletes multiple directories at given paths.
     * @param directoryNames List of paths to directories
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public void removeDirectories(List<String> directoryNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String directoryName: directoryNames) {
            deleteDirectory(directoryName);
        }

    }

    /**
     * Method that deletes file at given path
     * @param fileName path to file
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public void removeFile(String fileName) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteFile(fileName);
    }

    /**
     * Method that deletes multiple files at given path for each file
     * @param fileNames List of file paths
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public void removeFiles(List<String> fileNames) throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        for (String fileName: fileNames) {
            deleteFile(fileName);
        }
    }

    /**
     * Method that deletes everything in storage
     * @throws Exception if user isn't logged or doesn't have privilege
     */
    public void removeAll() throws Exception {
        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
            throw new LogException("User isn't logged or doen't have permission");
        }

        deleteAll(StorageInfo.getStorageInfo().getConfig().getPath());
    }
}
