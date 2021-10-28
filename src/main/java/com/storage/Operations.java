package com.storage;

import java.util.List;

public abstract class Operations {

    public abstract List<String> getAllFiles(String path);
    public abstract List<String> getAllDirectories(String path);
    public abstract List<String> getAllFilesRecursive(String path);
    public abstract List<String> getAllFilesWithExtention(String path, String extention);
    public abstract List<String> getSortedBy(String path, String criteria);
    public abstract List<String> getInBetweenDates(String path, String startDate, String endDate);
    public abstract void copyFile(String fromPath, String toPath, String fileName);

    public void copyFiles(String fromPath, String toPath, List<String> fileNames) {
        for(String fileName: fileNames) {
            copyFile(fromPath, toPath, fileName);
        }
    }

}
