package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/

public class Config {

    private String admin;
    private String maxSize;
    private int maxNumOfFiles;
    private List<String> unsupportedFiles;

    private Config() {}

    private static final class ConfigHolder {
        static final Config config = new Config();
    }

    public static Config getConfig() {
        return ConfigHolder.config;
    }

    public void initConfig(String admin, String maxSize, int maxNumOfFiles, List<String> unsupportedFiles) {
        this.admin = admin;
        this.maxSize = maxSize;
        this.maxNumOfFiles = maxNumOfFiles;
        this.unsupportedFiles = new ArrayList<>(unsupportedFiles);
    }

    public void resetConfig() {
        admin = "";
        maxSize = "";
        maxNumOfFiles = 0;
        unsupportedFiles = new ArrayList<>();
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

    public int getMaxNumOfFiles() {
        return maxNumOfFiles;
    }

    public void setMaxNumOfFiles(int maxNumOfFiles) {
        this.maxNumOfFiles = maxNumOfFiles;
    }
}
