package com.example.lesson8.ui.cats.presenter;


import com.example.lesson8.ui.cats.model.Cat;

import java.util.List;

public interface CatListView {
    void showCats(List<Cat> cats);

    void showNoDataMessage();

    void showToast(String text);
}
