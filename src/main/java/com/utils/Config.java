package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that is used for storing config data for current storage.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public class Config {

    private String path;
    private String admin;
    private String maxSize;
    private String maxNumOfFiles;
    private List<String> unsupportedFiles;

    /**
     * Creates empty Config (sets all fields to empty).
     */
    public Config() {
        path = "";
        admin = "";
        maxSize = "";
        maxNumOfFiles = "";
        unsupportedFiles = new ArrayList<>();
    }

    /**
     * Creates config with specified fields.
     * @param path Storage path
     * @param admin Storage adnim
     * @param maxSize Storage size limitation
     * @param maxNumOfFiles Storage file number limitation
     * @param unsupportedFiles Storage unallowed file extensions
     */
    public Config(String path, String admin, String maxSize, String maxNumOfFiles, List<String> unsupportedFiles) {
        this.path = path;
        this.admin = admin;
        this.maxSize = maxSize;
        this.maxNumOfFiles = maxNumOfFiles;
        this.unsupportedFiles = new ArrayList<>(unsupportedFiles);
    }

    /**
     * Method that checks forwarded number arguments. Method is used as a checker for setting storage limits.
     * @param strNum number as a string
     * @return true if number is correct format, false if strNum can't be parsed
     */
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

    /**
     * Storage path getter method.
     * @return Storage path
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Storage admin getter method.
     * @return Storage admin
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * Storage admin setter method.
     * @param admin Admin username
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     * Storage maximal size allowed getter method.
     * @return Storage size limit
     */
    public String getMaxSize() {
        return maxSize;
    }

    /**
     * Storage size limit setter method.
     * @param maxSize Storage size limit
     */
    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Storage maximal number of files allowed getter method.
     * @return Storage file count limit
     */
    public String getMaxNumOfFiles() {
        return maxNumOfFiles;
    }

    /**
     * Storage file number setter method.
     * @param maxNumOfFiles Storage file count limit
     */
    public void setMaxNumOfFiles(String maxNumOfFiles) {
        this.maxNumOfFiles = maxNumOfFiles;
    }

    /**
     * Storage unsupported file extensions getter method.
     * @return List of unsupported extensions
     */
    public List<String> getUnsupportedFiles() {
        return unsupportedFiles;
    }

    /**
     * Storage unsupported file extensions setter method.
     * @param unsupportedFiles List of unsupported files
     */
    public void setUnsupportedFiles(List<String> unsupportedFiles) {
        this.unsupportedFiles = unsupportedFiles;
    }
}
