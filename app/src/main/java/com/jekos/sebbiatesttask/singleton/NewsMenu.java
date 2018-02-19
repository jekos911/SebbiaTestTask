package com.jekos.sebbiatesttask.singleton;

import com.jekos.sebbiatesttask.api.MyServiceGenerator;
import com.jekos.sebbiatesttask.api.SebbiaInterface;
import com.jekos.sebbiatesttask.models.Category;
import com.jekos.sebbiatesttask.models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsMenu {

    private static List<Category> categoriesList = new ArrayList<>();
    private static List<News> newsList = new ArrayList<>();

    private static final SebbiaInterface sebbiaInterface = MyServiceGenerator.createService(SebbiaInterface.class);

    public static List<Category> getCategoriesList() {
        return categoriesList;
    }

    public static void setCategoriesList(List<Category> categoriesList) {
        NewsMenu.categoriesList = categoriesList;
    }

    public static List<News> getNewsList() {
        return newsList;
    }

    public static void setNewsList(List<News> newsList) {
        NewsMenu.newsList = newsList;
    }

    public static void addNews(List<News> newNews) {
        newsList.addAll(newNews);
    }
    
    public static void updateNews(int id,String fullDescription) {
        for (News news:newsList) {
            if (news.getId()==id)
                news.setFullDescription(fullDescription);
        }
    }
    
    public static News getNews(int id) {
        for (News news:newsList) {
            if (news.getId()==id)
                return news;
        }
        return null;
    }

    public static SebbiaInterface getInterfaceApi() {
        return sebbiaInterface;
    }
}
