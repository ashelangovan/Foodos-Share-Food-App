package Modules;

/**
 * Created by FREYA on 21-10-2016.
 */
public class Notify {
    private  String success,name,message,home,quantity,uinfo;

    public Notify(String success, String name, String message, String home,String quantity,String uinfo) {
        this.success = success;
        this.name = name;
        this.message = message;
        this.home = home;
        this.quantity=quantity;
        this.uinfo=uinfo;
    }

    public String getSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getHome() {
        return home;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getUinfo() {
        return uinfo;
    }


}
