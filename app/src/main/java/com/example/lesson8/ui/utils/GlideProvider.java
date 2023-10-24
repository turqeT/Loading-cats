package com.example.lesson8.ui.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideProvider {

    public static void loadImage(String imageUrl, ImageView imageView) {
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }
}

