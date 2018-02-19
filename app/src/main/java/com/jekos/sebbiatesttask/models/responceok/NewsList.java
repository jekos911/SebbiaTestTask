package com.jekos.sebbiatesttask.models.responceok;

import com.google.gson.annotations.SerializedName;
import com.jekos.sebbiatesttask.models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsList {
    @SerializedName("list")
    List<News> listNews = new ArrayList<>();

    public List<News> getListNews() {
        return listNews;
    }
}
