package com.utils;

import java.util.Date;

public class FileMetadata {

    private String name;
    private Date creationDate;
    private Date modificationDate;

    public FileMetadata(String name, Date creationDate, Date modificationDate) {
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    public String toString() {
        return name;
    }
}
