package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 **/

public class Config {

    private String path;
    private String admin;
    private String maxSize;
    private String maxNumOfFiles;
    private List<String> unsupportedFiles;

    public Config() {
        path = "";
        admin = "";
        maxSize = "";
        maxNumOfFiles = "";
        unsupportedFiles = new ArrayList<>();
    }

    public Config(String path, String admin, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) {
        this.path = path;
        this.admin = admin;
        this.maxSize = maxSize;
        this.maxNumOfFiles = maxNumOfFiles;
        this.unsupportedFiles = new ArrayList<>(unsupportedFiles);
    }

    public boolean checkArgs(String strNum) {
        if (strNum == null || strNum.equals("UN")) {
            return true;
        }

        try {
            Long.parseLong(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMaxNumOfFiles() {
        return maxNumOfFiles;
    }

    public void setMaxNumOfFiles(String maxNumOfFiles) {
        this.maxNumOfFiles = maxNumOfFiles;
    }

    public List<String> getUnsupportedFiles() {
        return unsupportedFiles;
    }

    public void setUnsupportedFiles(List<String> unsupportedFiles) {
        this.unsupportedFiles = unsupportedFiles;
    }
}
