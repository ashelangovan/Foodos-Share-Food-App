package com.example.freya.loginfoodos;

/**
 * Created by FREYA on 23-08-2016.
 */
public class contact {
    private int id;
    private String description;
    private double price;
    public contact(int image_id,String name,String loc)
    {
        this.setImage_id(image_id);
        this.setLoc(loc);
        this.setName(name);
    }
    private int image_id;
    String name,loc;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
