package com;

import com.storage.Create;
import com.storage.Delete;
import com.storage.Operations;
import com.storage.Storage;

/**
 * Class that groups together whole functionality.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public class StorageManager {

    private static Storage storage;
    private static Create create;
    private static Delete delete;
    private static Operations operations;

    /**
     * Creates StorageManager with specified fields.
     * @param s Storage
     * @param c Create
     * @param d Delete
     * @param o Operations
     * @see Storage
     * @see Create
     * @see Delete
     * @see Operations
     */
    public static void registerStorage(Storage s, Create c, Delete d, Operations o) {
        storage = s;
        create = c;
        delete = d;
        operations = o;
    }

    /**
     * Storage getter method.
     */
    public static Storage getStorage() {
        return storage;
    }

    /**
     * Create getter method.
     */
    public static Create getCreate() {
        return create;
    }

    /**
     * Delete getter method.
     */
    public static Delete getDelete() {
        return delete;
    }

    /**
     * Operations getter method.
     */
    public static Operations getOperations() {
        return operations;
    }
}
