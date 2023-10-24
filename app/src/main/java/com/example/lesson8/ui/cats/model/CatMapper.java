package com.example.lesson8.ui.cats.model;

import com.example.lesson8.data.model.CatPojo;

import java.util.ArrayList;
import java.util.List;

public class CatMapper {
    public static Cat map(CatPojo catPojo) {

        return new Cat(catPojo.getId(), catPojo.getUrl());
    }

    public static List<Cat> mapList(List<CatPojo> list) {
        List<Cat> cats = new ArrayList<>();
        for (CatPojo cat: list) {
            cats.add(map(cat));
        }
        return cats;
    }
}
