package com.example.lesson8.data.datasource;

import com.example.lesson8.data.model.CatPojo;
import com.example.lesson8.data.network.RetrofitService;

import java.util.List;

import retrofit2.Call;

public class CatsRemoteDataSource implements ICatsRemoteDataSource {

    @Override
    public Call<List<CatPojo>> getCallCats() {
        return RetrofitService.catApi.getCatList();
    }
}
