package com.jekos.sebbiatesttask.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by жекос on 19.02.2018.
 */

public class News {
    @SerializedName("date")
    Date date;
    @SerializedName("fullDescription")
    String fullDescription;
    @SerializedName("id")
    int id;
    @SerializedName("shortDescription")
    String shortDescription;
    @SerializedName("title")
    String title;

    public Date getDate() {
        return date;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public int getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
