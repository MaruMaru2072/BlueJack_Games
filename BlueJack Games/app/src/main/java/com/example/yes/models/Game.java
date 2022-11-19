package com.example.yes.models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;

public class Game{
    private String title;
    private String price;
    private String year;
    private Drawable images;

    public Game(String title, String price, String year, Drawable images) {
        this.title = title;
        this.price = price;
        this.year = year;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    public Drawable getImages() {
        return images;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setImages(Drawable images) {
        this.images = images;
    }
}
