package com.utils;

public class StorageInfo {

    private Config config;
    private User user;

    private StorageInfo() {}

    private static final class StorageInfoHolder {
        static final StorageInfo storageInfo = new StorageInfo();
    }

    public static StorageInfo getStorageInfo() {
        return StorageInfoHolder.storageInfo;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
