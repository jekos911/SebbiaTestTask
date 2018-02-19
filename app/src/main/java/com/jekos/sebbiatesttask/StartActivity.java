package com.jekos.sebbiatesttask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jekos.sebbiatesttask.api.MyServiceGenerator;
import com.jekos.sebbiatesttask.api.SebbiaInterface;
import com.jekos.sebbiatesttask.models.responceok.CategoriesList;
import com.jekos.sebbiatesttask.singleton.NewsMenu;
import com.jekos.sebbiatesttask.uifragments.CategoriesFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager = null;

    public static FragmentManager getFragmentManagerFromActivity() {
        return fragmentManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fragmentManager = getSupportFragmentManager();

        SebbiaInterface interfac = MyServiceGenerator.createService(SebbiaInterface.class);
        interfac.getCategories().enqueue(new Callback<CategoriesList>() {
            @Override
            public void onResponse(Call<CategoriesList> call, Response<CategoriesList> response) {
                NewsMenu.setCategoriesList(response.body().getGenres());
                fragmentManager.beginTransaction()
                        .add(R.id.container, new CategoriesFragment())
                        .commit();
            }

            @Override
            public void onFailure(Call<CategoriesList> call, Throwable t) {
                Toast.makeText(StartActivity.this,"no conntect",Toast.LENGTH_LONG).show();
            }
        });
    }
}
