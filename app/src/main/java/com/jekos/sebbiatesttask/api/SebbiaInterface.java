package com.jekos.sebbiatesttask.api;

import com.jekos.sebbiatesttask.models.responceok.CategoriesList;
import com.jekos.sebbiatesttask.models.responceok.NewsDetail;
import com.jekos.sebbiatesttask.models.responceok.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by жекос on 16.02.2018.
 */

public interface SebbiaInterface {
    @GET("/v1/news/categories")
    Call<CategoriesList> getCategories();

    @GET("/v1/news/categories/{id}/news")
    Call<NewsList> getNewsFromCategory(@Path("id") int categoryId);

    @GET("/v1/news/details")
    Call<NewsDetail> getNewsDetails(@Query("id") int newsId);
}
