package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.StartActivity;
import com.jekos.sebbiatesttask.api.MyServiceGenerator;
import com.jekos.sebbiatesttask.api.SebbiaInterface;
import com.jekos.sebbiatesttask.models.News;
import com.jekos.sebbiatesttask.models.responceok.NewsDetail;
import com.jekos.sebbiatesttask.singleton.NewsMenu;
import com.jekos.sebbiatesttask.uifragments.NewsDetailFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected int id;
    protected TextView title;
    protected TextView date;
    protected TextView shordDescription;

    public NewsViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
        title = (TextView) v.findViewById(R.id.title);
        date = (TextView) v.findViewById(R.id.date);
        shordDescription = (TextView) v.findViewById(R.id.short_description);
    }

    @Override
    public void onClick(View v) {
        //тут ничего не было
        News news = NewsMenu.getNews(id);
        if (news.getFullDescription()==null)
        NewsMenu.getInterfaceApi().getNewsDetails(id).enqueue(new Callback<NewsDetail>() {
            @Override
            public void onResponse(Call<NewsDetail> call, Response<NewsDetail> response) {
                NewsMenu.updateNews(id,response.body().getNews().getFullDescription());
                NewsDetailFragment newsDetailFragment = NewsDetailFragment.newInstance(id);
                StartActivity.getFragmentManagerFromActivity()
                        .beginTransaction()
                        .replace(R.id.container,newsDetailFragment)
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onFailure(Call<NewsDetail> call, Throwable t) {

            }
        });
        else
        {
            NewsDetailFragment newsDetailFragment = NewsDetailFragment.newInstance(id);
            StartActivity.getFragmentManagerFromActivity()
                    .beginTransaction()
                    .replace(R.id.container,newsDetailFragment)
                    .addToBackStack(null)
                    .commit();
        }

}}
