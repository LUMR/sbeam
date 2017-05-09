package com.lumr.sbeam.vo;

import java.util.List;

/**
 * 游戏分类
 * Created by fsweb on 17-5-8.
 */
public class Category {
    private Integer id;
    private String name;//分类名
    private List<Game> games;//游戏集合

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
