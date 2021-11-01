package com.storage;

import com.utils.FileMetadata;
import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public abstract class Operations {

    public abstract List<FileMetadata> getAllFiles(String path) throws Exception;
    public abstract List<FileMetadata> getAllDirectories(String path) throws Exception;
    public abstract List<FileMetadata> getAllFilesRecursive(String path) throws Exception;
    public abstract void download(String path) throws Exception;
    public abstract void uploadFile(String fromPath, String toPath) throws Exception;
    public abstract void moveFile(String fromPath, String toPath) throws Exception;

//    public void moveFiles(String fromPath, String toPath, List<String> fileNames) throws Exception {
//        if (!StorageInfo.getStorageInfo().checkUser(Privilege.ADMIN, Privilege.RDCD)) {
//            throw new Exception("Korisnik nije logovan ili nema privilegiju");
//        }
//
//        for(String fileName: fileNames) {
//            moveFile(fromPath, toPath, fileName);
//        }
//    }

    public List<FileMetadata> getAllFilesWithExtention(List<FileMetadata> files, String extention) {
        // TODO - ako ne radi izbacivanje zadate ekstenzije
        files.removeIf(file -> !file.getName().endsWith(extention));
        return files;
    }

    // criteria - naziv, datum kreiranja i modifikacija
    public List<FileMetadata> getSortedBy(List<FileMetadata> files, String criteria) {
        if (criteria.equals("sortByName")) {
            sortByName(files);
        }

        if (criteria.equals("sortByDate")) {
            sortByDate(files);
        }

        if (criteria.equals("sortByModification")) {
            sortByModification(files);
        }

        return files;
    }

    public List<FileMetadata> getInBetweenDates(List<FileMetadata> files, Date startDate, Date endDate) {
        files.removeIf(file -> !(file.getCreationDate().after(startDate) && file.getCreationDate().before(endDate)));
        return files;
    }

    private void sortByName(List<FileMetadata> files) {
        // TODO - ako ne radi sortiranje
        files.sort(Comparator.comparing(FileMetadata::getName));
//        files.sort(new Comparator<FileMetadata>() {
//            @Override
//            public int compare(FileMetadata o1, FileMetadata o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
    }

    private void sortByDate(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getCreationDate));
    }

    private void sortByModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getModificationDate));
    }
}
