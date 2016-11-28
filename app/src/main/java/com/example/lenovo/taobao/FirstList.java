package com.example.lenovo.taobao;

/**
 * Created by Lenovo on 2016/11/7.
 */

public class FirstList {

    private int id;
    private String Name;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FirstList(String name, String img, int id) {
        Name = name;
        this.img = img;
        this.id=id;

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

}
