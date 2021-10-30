package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 **/

// TODO NAPOMENA - paziti na null vrednosti polja

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

//    public void changeConfig(String maxSize, String maxNumOfFiles, String... extentions) throws NumberFormatException {
//        if (maxSize != null) {
//            if (maxSize.equalsIgnoreCase("un")) {
//                this.maxSize = "";
//            }
//            else {
//                Double.parseDouble(maxSize);
//                this.maxSize = maxSize;
//            }
//        }
//
//        if(maxNumOfFiles != null){
//            if (maxNumOfFiles.equalsIgnoreCase("un")) {
//                this.maxNumOfFiles = "";
//            }
//            else {
//                Double.parseDouble(maxNumOfFiles);
//                this.maxNumOfFiles = maxNumOfFiles;
//            }
//        }
//
//        if(extentions != null) {
//            if (extentions.length == 1 && extentions[0].equalsIgnoreCase("un")) {
//                this.unsupportedFiles.clear();
//            }
//            else {
//                this.unsupportedFiles.addAll(Arrays.asList(extentions));
//            }
//        }
//    }

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
