package com.example.lesson8.data.datasource;

import android.content.Context;

import com.example.lesson8.data.local.Cache;
import com.example.lesson8.data.model.CatPojo;

import java.util.List;

public class CatsLocalDataSource implements ICatsLocalDataSource {
    private final Cache cache;

    public CatsLocalDataSource(Context context) {
        cache = new Cache(context);
    }

    @Override
    public List<CatPojo> getCatsToCache() {
        return cache.getCatListFromCache();
    }

    @Override
    public void setCatsToCache(List<CatPojo> catPojoList) {
        cache.saveCatList(catPojoList);
    }
}
