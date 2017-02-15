package Modules;

/**
 * Created by FREYA on 24-10-2016.
 */

public class UserNotifify {
    private String success,name,home;

    public String getSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public String getHome() {
        return home;
    }

    public UserNotifify(String success, String name, String home) {

        this.success = success;
        this.name = name;
        this.home = home;
    }
}
