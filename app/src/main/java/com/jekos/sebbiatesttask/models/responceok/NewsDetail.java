package com.jekos.sebbiatesttask.models.responceok;

import com.google.gson.annotations.SerializedName;
import com.jekos.sebbiatesttask.models.News;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsDetail {
    @SerializedName("news")
    private News news;

    public News getNews() {
        return news;
    }
}
