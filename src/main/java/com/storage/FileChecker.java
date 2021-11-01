package com.storage;

public abstract class FileChecker {

    public abstract boolean ckeckPath(String path);  //  postojanje fajla van skladista
    public abstract boolean ckeckStoragePath(String path);  // u skladistu putanje
    public abstract boolean checkNumOfFiles();
    public abstract boolean checkMaxSize(long size);
    public abstract boolean ckeckExtention(String extension);

}
