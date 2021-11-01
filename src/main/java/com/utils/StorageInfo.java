package com.utils;

public class StorageInfo {

    private Config config;
    private User user;

    private StorageInfo() {
        init();
    }

    public void init() {
        config = new Config();
        user = new User();
    }

    private static final class StorageInfoHolder {
        static final StorageInfo storageInfo = new StorageInfo();
    }

    public static StorageInfo getStorageInfo() {
        return StorageInfoHolder.storageInfo;
    }

    public boolean checkUser(Privilege... privileges) {
        if (!getUser().isLogged()) {
            return false;
        }

        for (Privilege privilege: privileges) {
            if (user.getPrivilege() == privilege) {
                return true;
            }
        }

        return false;
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
