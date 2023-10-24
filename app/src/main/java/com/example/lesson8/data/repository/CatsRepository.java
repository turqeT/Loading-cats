package com.example.lesson8.data.repository;

import android.content.Context;

import com.example.lesson8.data.datasource.CatsLocalDataSource;
import com.example.lesson8.data.datasource.CatsRemoteDataSource;
import com.example.lesson8.data.datasource.ICatsLocalDataSource;
import com.example.lesson8.data.datasource.ICatsRemoteDataSource;
import com.example.lesson8.data.model.CatPojo;

import java.util.List;

import retrofit2.Call;

public class CatsRepository implements ICatsRepository {

    private final ICatsRemoteDataSource remoteDataSource = new CatsRemoteDataSource();
    private final ICatsLocalDataSource localDataSource;

    public CatsRepository(Context context) {
        localDataSource = new CatsLocalDataSource(context);
    }

    @Override
    public Call<List<CatPojo>> loadCats() {
        return remoteDataSource.getCallCats();
    }

    @Override
    public void saveToCache(List<CatPojo> catPojoList) {
        localDataSource.setCatsToCache(catPojoList);
    }

    @Override
    public List<CatPojo> getFromCache() {
        return localDataSource.getCatsToCache();
    }
}

