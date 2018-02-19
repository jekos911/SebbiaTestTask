package com.jekos.sebbiatesttask.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by жекос on 19.02.2018.
 */

public class Category {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
