package com.example.lesson8.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lesson8.data.model.CatPojo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static final String FILE_NAME = "cats_cache";
    private static final String CAT_LIST_KEY = "cat_list";
    private final Gson gson = new Gson();
    private final SharedPreferences sharedPreferences;

    public Cache(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveCatList(List<CatPojo> catList) {
        String json = gson.toJson(catList);
        sharedPreferences.edit().putString(CAT_LIST_KEY, json).apply();
    }

    public List<CatPojo> getCatListFromCache() {
        String json = sharedPreferences.getString(CAT_LIST_KEY, "");
        if (!json.isEmpty()) {
            Type type = new TypeToken<List<CatPojo>>() {
            }.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }

}



