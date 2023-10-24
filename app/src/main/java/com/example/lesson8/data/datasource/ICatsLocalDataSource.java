package com.example.lesson8.data.datasource;

import com.example.lesson8.data.model.CatPojo;

import java.util.List;

public interface ICatsLocalDataSource {
    List<CatPojo> getCatsToCache();

    void setCatsToCache(List<CatPojo> catPojoList);
}
