package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.StartActivity;
import com.jekos.sebbiatesttask.api.MyServiceGenerator;
import com.jekos.sebbiatesttask.api.SebbiaInterface;
import com.jekos.sebbiatesttask.models.responceok.NewsList;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 19.02.2018.
 */

public class CategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    protected TextView categoryName;
    protected int idCategory;

    public CategoriesViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        categoryName = (TextView) itemView.findViewById(R.id.category_title);
    }

    @Override
    public void onClick(View v) {
        NewsMenu.getInterfaceApi().getNewsFromCategory(idCategory, 0).enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                NewsMenu.setNewsList(response.body().getListNews());
                ListNewsFragment lnf = ListNewsFragment.newInstance(idCategory);
                StartActivity.getFragmentManagerFromActivity()
                        .beginTransaction()
                        .replace(R.id.container,lnf)
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

            }
        });
    }
}
