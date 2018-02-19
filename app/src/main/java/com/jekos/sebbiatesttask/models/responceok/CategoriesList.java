package com.jekos.sebbiatesttask.models.responceok;

import com.google.gson.annotations.SerializedName;
import com.jekos.sebbiatesttask.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class CategoriesList {
    @SerializedName("list")
    private List<Category> genres = new ArrayList<Category>();

    public List<Category> getGenres() {
        return genres;
    }
}
