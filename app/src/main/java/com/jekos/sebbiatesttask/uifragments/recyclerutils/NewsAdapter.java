package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.models.News;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<News> news;
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private boolean isLoadingAdded = false;


    public NewsAdapter() {news = NewsMenu.getNewsList();}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM) {
            NewsViewHolder holderNews = (NewsViewHolder) holder;
            News ne = news.get(position);
            holderNews.id = ne.getId();
            holderNews.title.setText(ne.getTitle());
            SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM yyyy HH:mm");
            holderNews.date.setText(fmt.format(ne.getDate()));
            holderNews.shordDescription.setText(ne.getShortDescription());
        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM)
            return getViewHolder(parent, inflater);
        return new LoadingVH(inflater.inflate(R.layout.item_progress, parent, false));
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.news_item, parent, false);
        viewHolder = new NewsViewHolder(v1);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == news.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public void add(News mc) {
        news.add(mc);
        notifyItemInserted(news.size() - 1);
    }

    public void addAll(List<News> mcList) {
        for (News mc : mcList) {
            add(mc);
        }
    }


}
