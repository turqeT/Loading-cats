package com.example.lesson8.data.network;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String baseUrl = "https://api.thecatapi.com";
    private static retrofit2.Retrofit retrofit;


    public static retrofit2.Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static CatApi catApi = RetrofitService.getRetrofitInstance().create(CatApi.class);
}
