package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.models.News;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<News> news;

    public NewsAdapter() {news = NewsMenu.getNewsList();}

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News ne = news.get(position);
        holder.id = ne.getId();
        holder.title.setText(ne.getTitle());
        holder.date.setText(ne.getDate().toString());
        holder.shordDescription.setText(ne.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        NewsViewHolder vh = new NewsViewHolder(view);
        return vh;
    }

}
