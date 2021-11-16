package com.utils;

/**
 * Class that is used for storing User and Config info.
 * @author Lazar Dejanovic
 * @author Vuk Vukovic
 */
public class StorageInfo {

    private Config config;
    private User user;

    private StorageInfo() {
        init();
    }

    /**
     * Method that initialises Config and User fields.
     * @see Config
     * @see User
     */
    public void init() {
        config = new Config();
        user = new User();
    }

    private static final class StorageInfoHolder {
        static final StorageInfo storageInfo = new StorageInfo();
    }

    /**
     * Method that gets this class' instance.
     * @return StorageInfo instance.
     */
    public static StorageInfo getStorageInfo() {
        return StorageInfoHolder.storageInfo;
    }

    /**
     * Checks if user is logged and has the right privilege level.
     * @param privileges Array of privileges that need to be checked.
     * @return true if user is logged and has right privilege level, or false if isn't logged or doesn't have the right privilege.
     */
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

    /**
     * Config getter method.
     * @return Config
     * @see Config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Config setter method.
     * @param config Config
     * @see Config
     */
    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * User getter method.
     * @return User
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**
     * User setter method.
     * @param user Config
     * @see Config
     */
    public void setUser(User user) {
        this.user = user;
    }
}
