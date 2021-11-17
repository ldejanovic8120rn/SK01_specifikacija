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

    /**
     * Method that gets all files at given path.
     * @param path Path within storage
     * @return List of FileMetada at path
     * @see FileMetadata
     * @throws Exception if user isn't logged or path doesn't exist
     */
    public abstract List<FileMetadata> getAllFiles(String path) throws Exception;

    /**
     * Method that lists all directories at given path
     * @param path Path within storage
     * @return List of FileMetada at path
     * @see FileMetadata
     * @throws Exception if user isn't logged or path doesn't exist
     */
    public abstract List<FileMetadata> getAllDirectories(String path) throws Exception;

    /**
     * Method that gets all files at given path, including files within other directories.
     * @param path Path within storage
     * @return List of FileMetada at path
     * @see FileMetadata
     * @throws Exception if user isn't logged or path doesn't exist
     */
    public abstract List<FileMetadata> getAllFilesRecursive(String path) throws Exception;

    /**
     * Method that downloads a file.
     * @param path Path to file
     * @throws Exception if user isn't logged or doesn't have privilege or path doesn't exist
     */
    public abstract void download(String path) throws Exception;

    /**
     * Method that uploads given file to specified path.
     * @param fromPath Path to file that should be uploaded
     * @param toPath Path to which given file should be uploaded
     * @throws Exception if user isn't logged or doesn't have privilege or path doesn't exist
     */
    public abstract void uploadFile(String fromPath, String toPath) throws Exception;

    /**
     * Method that moves given file to specified path.
     * @param fromPath Path to file that should be moved
     * @param toPath Path to which given file should be moved to
     * @throws Exception if user isn't logged or doesn't have privilege or path doesn't exist
     */
    public abstract void moveFile(String fromPath, String toPath) throws Exception;

    /**
     * Method that filters files by given extension.
     * @param files List of FileMetadatas
     * @param extention File extension that should be searched for
     * @return FileMetadata list with given extension
     * @see FileMetadata
     */
    public List<FileMetadata> getAllFilesWithExtention(List<FileMetadata> files, String extention) {
        files.removeIf(file -> !file.getName().endsWith(extention));
        return files;
    }

    /**
     * Method that sorts files by various criteria.
     * @param files List of FileMetadatas
     * @param criteria Criteria for file sorting (sortByName, sortByDate, sortByModification and their combinations)
     * @return FileMetadata list sorted by given criteria
     * @see FileMetadata
     */
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

    /**
     * Method that filters file in between two dates
     * @param files List of FileMetadatas
     * @param startDate starting date for filtering
     * @param endDate ending date for filtering
     * @return FileMetada filtered list
     * @see FileMetadata
     */
    public List<FileMetadata> getInBetweenDates(List<FileMetadata> files, Date startDate, Date endDate) {
        files.removeIf(file -> !(file.getCreationDate().after(startDate) && file.getCreationDate().before(endDate)));
        return files;
    }

    private void sortByName(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName));
    }

    /**
     * Method that sorts given FileMetada list by date
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByDate(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getCreationDate));
    }

    /**
     * Method that sorts given FileMetada list by modification date
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getModificationDate));
    }

    /**
     * Method that sorts given FileMetada list by name and date
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByNameAndDate(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getCreationDate));
    }

    /**
     * Method that sorts given FileMetada list by name and modification date
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByNameAndModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getModificationDate));
    }

    /**
     * Method that sorts given FileMetada list by date and modification date
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByDateAndModification(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getCreationDate).thenComparing(FileMetadata::getModificationDate));
    }

    /**
     * Method that sorts given FileMetada list by all categories
     * @param files FileMetadata list that should be sorted
     * @see FileMetadata
     */
    private void sortByAll(List<FileMetadata> files) {
        files.sort(Comparator.comparing(FileMetadata::getName).thenComparing(FileMetadata::getCreationDate).thenComparing(FileMetadata::getModificationDate));
    }
}
