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
    private double price;//游戏价格
    private String description;//游戏描述
    private List<Picture> pictures;//游戏介绍截图
    private List<Review> reviews;//游戏评论
}
