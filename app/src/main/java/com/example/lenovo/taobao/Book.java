package com.example.lenovo.taobao;

/**
 * Created by 软件-侯会召-15633047075 on 2016/9/20.
 */

public class Book {
    private int id;
    private String Name;
    private int img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(String name, int img, int id) {
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
