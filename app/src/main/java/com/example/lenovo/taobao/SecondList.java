package com.example.lenovo.taobao;

/**
 * Created by Lenovo on 2016/11/7.
 */

public class SecondList {
    private int id;
    private String Name;
    private String img;
    private String logo;

    public SecondList(int id, String name, String img, String logo) {
        this.id = id;
        Name = name;
        this.img = img;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
