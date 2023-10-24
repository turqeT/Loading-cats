package com.example.lesson8.data.datasource;


import com.example.lesson8.data.model.CatPojo;

import java.util.List;

import retrofit2.Call;

public interface ICatsRemoteDataSource {
    Call<List<CatPojo>> getCallCats();
}
