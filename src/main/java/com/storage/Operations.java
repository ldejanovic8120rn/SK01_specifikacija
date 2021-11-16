package com.storage;

import com.utils.FileMetadata;
import com.utils.Privilege;
import com.utils.StorageInfo;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Class that is used for various file actions such as moving, uploading, downloading, sorting.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public abstract class Operations {

    public abstract List<FileMetadata> getAllFiles(String path) throws Exception;
    public abstract List<FileMetadata> getAllDirectories(String path) throws Exception;
    public abstract List<FileMetadata> getAllFilesRecursive(String path) throws Exception;
    public abstract void download(String path) throws Exception;
    public abstract void uploadFile(String fromPath, String toPath) throws Exception;
    public abstract void moveFile(String fromPath, String toPath) throws Exception;

    public List<FileMetadata> getAllFilesWithExtention(List<FileMetadata> files, String extention) {
        // TODO - ako ne radi izbacivanje zadate ekstenzije
        files.removeIf(file -> !file.getName().endsWith(extention));
        return files;
    }

    public List<FileMetadata> getSortedBy(List<FileMetadata> files, String criteria) {
        if (criteria.equals("sortByName")) {
            sortByName(files);
            return files;
        }

        if (criteria.equals("sortByDate")) {
            sortByDate(files);
            return files;
        }

        if (criteria.equals("sortByModification")) {
            sortByModification(files);
            return files;
        }

        if (criteria.contains("sortByName") && criteria.contains("sortByDate") && criteria.contains("sortByModification")) {
            sortByAll(files);
            return files;
        }

        if (criteria.contains("sortByName") && criteria.contains("sortByDate")) {
            sortByNameAndDate(files);
            return files;
        }

        if (criteria.contains("sortByName") && criteria.contains("sortByModification")) {
            sortByNameAndModification(files);
            return files;
        }

        if (criteria.contains("sortByDate") && criteria.contains("sortByModification")) {
            sortByDateAndModification(files);
            return files;
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

    private void sortByNameAndDate(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getCreationDate));
    }

    private void sortByNameAndModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getModificationDate));
    }

    private void sortByDateAndModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getCreationDate).thenComparing(FileMetadata::getModificationDate));
    }

    private void sortByAll(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getCreationDate).thenComparing(FileMetadata::getModificationDate));
    }
}
