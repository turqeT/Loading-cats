package com.example.lesson8.data.network;

import com.example.lesson8.data.model.CatPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatApi {
    @GET("v1/images/search?limit=10")
    Call<List<CatPojo>> getCatList();
}
