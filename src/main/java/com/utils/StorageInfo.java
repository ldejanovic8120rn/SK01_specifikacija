package com.utils;

import com.storage.FileChecker;

public class StorageInfo {

    private Config config;
    private User user;
    private FileChecker fileChecker;

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

    public boolean checkPath(String path) {
        // TODO - proveriti da li se za zadatu putanju nalazi fajl u skladistu

        //TODO - napraviti FileChecker klasu koja ce da ima sve potrebne provere na apstraktnom nivou
            //npr provera max broja fajlova, provera dozvoljenih ekstenzija, itd
        //TODO - tamo prebaciti i ovu metodu (checkPath)

        return true;
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
