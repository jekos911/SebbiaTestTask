package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.models.Category;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import java.util.List;

/**
 * Created by жекос on 19.02.2018.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    private List<Category> categories;

    public CategoriesAdapter() {categories = NewsMenu.getCategoriesList();}

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        Category cat = categories.get(position);
        holder.categoryName.setText(cat.getName());
        holder.idCategory = cat.getId();
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        CategoriesViewHolder vh = new CategoriesViewHolder(view);
        return vh;
    }
}
