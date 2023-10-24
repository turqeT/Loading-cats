package com.example.lesson8.ui.cats.presenter;

import android.content.Context;

import androidx.annotation.NonNull;


import com.example.lesson8.R;
import com.example.lesson8.data.model.CatPojo;
import com.example.lesson8.data.repository.CatsRepository;
import com.example.lesson8.ui.cats.model.CatMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatListPresenter implements ICatsPresenter {
    private CatListView view;
    private final CatsRepository catsRepository;


    public CatListPresenter(CatListView view, Context context) {
        this.view = view;
        catsRepository = new CatsRepository(context);

    }

    @Override
    public void getCats() {
        catsRepository.loadCats().enqueue(new Callback<List<CatPojo>>() {
            @Override
            public void onResponse(@NonNull Call<List<CatPojo>> call, @NonNull Response<List<CatPojo>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<CatPojo> catList = response.body();
                        catsRepository.saveToCache(catList);
                        view.showCats(CatMapper.mapList(catList));
                    } else {
                        view.showNoDataMessage();
                    }

                } else {
                    view.showNoDataMessage();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CatPojo>> call, @NonNull Throwable t) {
                view.showToast();
                List<CatPojo> catsFromCache = catsRepository.getFromCache();
                if (!catsFromCache.isEmpty()) {
                    view.showCats(CatMapper.mapList(catsFromCache));

                } else {
                    view.showNoDataMessage();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
