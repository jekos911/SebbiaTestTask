package com.jekos.sebbiatesttask.uifragments.recyclerutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jekos.sebbiatesttask.BuildConfig;
import com.jekos.sebbiatesttask.R;
import com.jekos.sebbiatesttask.models.News;
import com.jekos.sebbiatesttask.models.responceok.NewsList;
import com.jekos.sebbiatesttask.singleton.NewsMenu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by жекос on 19.02.2018.
 */

public class ListNewsFragment extends Fragment {
    RecyclerView recyclerView;

    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String IS_LAST_PAGE = "IS_LAST_PAGE";
    private static final String CAT_ID = "CAT_ID";
    private int categoryId;


    private static final int PAGE_START = 0;
    private int total_pages = Integer.MAX_VALUE;
    private int currentPage = 0;

    private static final boolean wasFirstLoad = true;
    private NewsAdapter newsAdatper;
    private LinearLayoutManager linearLayoutManager;


    private boolean isLoading = false;
    private boolean isLastPage = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryId = getArguments().getInt(CAT_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_layout,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.category_recycler);

        newsAdatper = new NewsAdapter();
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        if ((NewsMenu.getNewsList().size() % 10)!=0)
            total_pages = currentPage;
       else
        recyclerView.setAdapter(newsAdatper);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new PaginationScrollListner(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                if (!isLoading && !isLastPage) {
                    isLoading = true;
                    currentPage += 1;
                    loadNextPage();
                }
            }

            @Override
            public int getTotalPageCount() {
                return total_pages;
            }

            @Override
            public boolean isLastPage() {
                return currentPage >= total_pages;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        return view;
    }

    private void loadNextPage() {
            NewsMenu.getInterfaceApi().getNewsFromCategory(categoryId, currentPage).enqueue(new Callback<NewsList>() {
                @Override
                public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                    if (response.body() != null) {
                        List<News> newsss = response.body().getListNews();
                        if ((newsss != null) && (newsss.size() != 0)) {
                            newsAdatper.addAll(newsss);
                        } else {
                            Toast.makeText(getActivity(), "Reached last page", Toast.LENGTH_SHORT).show();
                            isLastPage = true;
                        }
                        //newsAdatper.removeLoadingFooter();
                        isLoading = false;
                       // if ((newsss.size() != 0) &&(newsss.size() % 10 != 0)) //newsAdatper.addLoadingFooter();
                        //else isLastPage = true;
                    }
                }

                @Override
                public void onFailure(Call<NewsList> call, Throwable t) {
                    error();
                }
            });

    }

    private void error() {
        Toast.makeText(getActivity(), "Internet connection error", Toast.LENGTH_SHORT).show();
    }


    public static ListNewsFragment newInstance(int catId) {

        Bundle args = new Bundle();
        args.putInt(CAT_ID,catId);
        ListNewsFragment fragment = new ListNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(newsAdatper);
    }
}
