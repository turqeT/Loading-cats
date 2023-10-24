package com.example.lesson8.ui.cats.model;


import java.io.Serializable;

public class Cat implements Serializable {
    private String id;
    private String image;

    public Cat(String id, String image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
