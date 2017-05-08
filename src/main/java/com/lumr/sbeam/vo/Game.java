package com.lumr.sbeam.vo;

import java.util.List;

/**
 * 游戏对象
 * Created by fsweb on 17-5-8.
 */
public class Game {
    private int id;
    private String name;//游戏名
    private Category category;//游戏分类
    private Platform platform;//游戏平台
    private double price;//游戏价格
    private String description;//游戏描述
    private List<Picture> pictures;//游戏介绍截图
    private List<Review> reviews;//游戏评论

    public Game() {
    }

    public Game(String name, Category category, Platform platform, double price, String description) {
        this.name = name;
        this.category = category;
        this.platform = platform;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
