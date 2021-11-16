package com.storage;

/**
 * Class that is used for numerous checks and inspections.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public abstract class FileChecker {

    /**
     * Method that checks if given path exists. The path is path outside of current storage.
     * @param path Path outside of storage
     * @return true if path exists, false if it doesn't
     */
    public abstract boolean ckeckPath(String path);

    /**
     * Method that checks if given path exists within the storage.
     * @param path Path within storage
     * @return true if path exists, false if it doesn't
     */
    public abstract boolean ckeckStoragePath(String path);

    /**
     * Method that checks if file number limit is exceeded.
     * @return true if it isn't, false if it is
     */
    public abstract boolean checkNumOfFiles();

    /**
     * Method that checks if storage size limit is exceeded.
     * @return true if it isn't, false if it is
     */
    public abstract boolean checkMaxSize(long size);

    /**
     * Method that checks if file extension is allowed.
     * @return true if it is, false if it isn't
     */
    public abstract boolean ckeckExtention(String extension);

}
