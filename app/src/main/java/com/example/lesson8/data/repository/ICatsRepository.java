package com.example.lesson8.data.repository;

import com.example.lesson8.data.model.CatPojo;

import java.util.List;

import retrofit2.Call;

public interface ICatsRepository {
    Call<List<CatPojo>> loadCats();

    void saveToCache(List<CatPojo> catPojoList);

    List<CatPojo> getFromCache();

}
