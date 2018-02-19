package com.jekos.sebbiatesttask.uifragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.models.News;
import com.jekos.sebbiatesttask.models.responceok.NewsDetail;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import java.text.SimpleDateFormat;

/**
 * Created by жекос on 19.02.2018.
 */

public class NewsDetailFragment extends Fragment {

    private static final String NEWS_ID = "NEWS_ID";

    TextView title;
    TextView date;
    TextView fullDescription;

    public static NewsDetailFragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(NEWS_ID,id);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_detail_layout,container,false);
        News news = NewsMenu.getNews(getArguments().getInt(NEWS_ID));

        title = (TextView)v.findViewById(R.id.detail_title);
        date = (TextView)v.findViewById(R.id.detail_date);
        fullDescription = (TextView)v.findViewById(R.id.detail_description);
        fullDescription.setMovementMethod(LinkMovementMethod.getInstance());


        title.setText(news.getTitle());
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        date.setText(fmt.format(news.getDate()));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            fullDescription.setText(Html.fromHtml(news.getFullDescription(),Html.FROM_HTML_MODE_LEGACY));
        } else {
            fullDescription.setText(Html.fromHtml(news.getFullDescription()));
        }


        return v;
    }
}
