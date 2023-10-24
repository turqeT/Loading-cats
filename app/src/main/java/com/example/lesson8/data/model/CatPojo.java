package com.example.lesson8.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CatPojo implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    public CatPojo(String id, String url) {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
