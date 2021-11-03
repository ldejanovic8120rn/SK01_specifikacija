package com;

import com.storage.Create;
import com.storage.Delete;
import com.storage.Operations;
import com.storage.Storage;

public class StorageManager {

    private static Storage storage;
    private static Create create;
    private static Delete delete;
    private static Operations operations;

    public static void registerStorage(Storage s, Create c, Delete d, Operations o) {
        storage = s;
        create = c;
        delete = d;
        operations = o;
    }

    public static Storage getStorage() {
        return storage;
    }

    public static Create getCreate() {
        return create;
    }

    public static Delete getDelete() {
        return delete;
    }

    public static Operations getOperations() {
        return operations;
    }
}
