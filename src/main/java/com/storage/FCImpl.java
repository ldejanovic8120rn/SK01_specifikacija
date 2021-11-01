package com.storage;

public class FCImpl extends FileChecker {

    public static FCImpl instance;


    @Override
    public boolean ckeckPath(String path) {
        return false;
    }

    @Override
    public boolean checkNumOfFiles() {
        return false;
    }

    @Override
    public boolean cleckMaxSize(double size) {
        return false;
    }

    @Override
    public boolean ckeckExtention(String extention) {
        return false;
    }
}
