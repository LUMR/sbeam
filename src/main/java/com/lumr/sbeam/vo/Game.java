package com.lumr.sbeam.vo;

import com.lumr.sbeam.utils.Utils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 游戏对象
 * Created by fsweb on 17-5-8.
 */
public class Game {
    private Integer id;
    private String name;//游戏名
    private Integer categoryId;//游戏分类
    private Integer platformId;//游戏平台
    private Double price;//游戏价格
    private Date pubdate;
    private String description;//游戏描述
    private Category category;
    private Platform platform;
    private List<Picture> pictures;//游戏介绍截图
    private List<Review> reviews;//游戏评论

    public Game() {
    }

    public Game(Integer id) {
        this.id = id;
    }

    public Game(Integer categoryId, Integer platformId) {
        this.categoryId = categoryId;
        this.platformId = platformId;
    }

    public Game(String name, Integer categoryId, Integer platformId) {
        this.name = name;
        this.categoryId = categoryId;
        this.platformId = platformId;
    }

    public Game(String name, Integer categoryId, Integer platformId, Double price, Date pubdate, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.platformId = platformId;
        this.price = price;
        this.pubdate = pubdate;
        this.description = description;
    }

    public Game(Integer id, String name, Integer categoryId, Integer platformId, Double price, Date pubdate, String description) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.platformId = platformId;
        this.price = price;
        this.pubdate = pubdate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) throws ParseException{
        this.pubdate = Utils.parseDate(pubdate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
