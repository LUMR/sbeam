package com.lumr.sbeam.vo;

import com.lumr.sbeam.utils.Utils;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 游戏对象
 * Created by fsweb on 17-5-8.
 */
@Getter
@Setter
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

}
