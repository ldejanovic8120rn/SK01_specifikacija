package com.utils;

import java.util.Date;

/**
 * Class that is used for storing file metadata when sorting files.
 * The purpose of this class is to work with file metadata instead of actual files.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public class FileMetadata {

    private String name;
    private Date creationDate;
    private Date modificationDate;

    /**
     * Creates FileMetadata with all metadata fields.
     * @param name File name
     * @param creationDate File creation date
     * @param modificationDate File last modification date
     * @see Date
     */
    public FileMetadata(String name, Date creationDate, Date modificationDate) {
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    /**
     * File name getter method.
     * @return file name
     */
    public String getName() {
        return name;
    }

    /**
     * File creation date getter method.
     * @return file creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * File last modification date getter method.
     * @return last modification date
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * FileMetadata toString method.
     * @return metadata string which contains file name, creation date and last modification date.
     */
    @Override
    public String toString() {
        return name + " " + creationDate + " " + modificationDate;
    }
}
