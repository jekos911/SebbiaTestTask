package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jekos.sebbiatesttask.R;

/**
 * Created by жекос on 19.02.2018.
 */

public class ListNewsFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_layout,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.category_recycler);

        recyclerView.setAdapter(new NewsAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }


}
