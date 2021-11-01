package com.storage;

public abstract class FileChecker {

    public abstract boolean ckeckPath(String path);
    public abstract boolean checkNumOfFiles();
    public abstract boolean cleckMaxSize(double size);
    public abstract boolean ckeckExtention(String extention);

}
