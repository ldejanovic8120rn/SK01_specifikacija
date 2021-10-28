package com.utils;

import java.util.ArrayList;
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

    public Config(String path, String admin, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) {
        this.path = path;
        this.admin = admin;
        this.maxSize = maxSize;
        this.maxNumOfFiles = maxNumOfFiles;
        this.unsupportedFiles = unsupportedFiles;
    }

    public void changeConfig(String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) throws NumberFormatException {
        if (maxSize != null) {
            Double.parseDouble(maxSize);
            this.maxSize = maxSize;
        }
        if(maxNumOfFiles != null){
            Double.parseDouble(maxNumOfFiles);
            this.maxNumOfFiles = maxNumOfFiles;
        }
        if(unsupportedFiles != null){
            this.unsupportedFiles.addAll(unsupportedFiles);
        }
    }

    public void resetConfig() {
        path = "";
        admin = "";
        maxSize = "";
        maxNumOfFiles = "";
        unsupportedFiles = new ArrayList<>();
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
}
