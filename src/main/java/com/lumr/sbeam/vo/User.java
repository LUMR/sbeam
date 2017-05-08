package com.lumr.sbeam.vo;

import java.util.Date;
import java.util.List;

/**
 * 用户对象
 * Created by fsweb on 17-5-8.
 */
public class User {
    private int id;
    private String password;
    private Picture header;//头像
    private Double money;//拥有的金钱
    private Date registerDate;//注册日期
    private List<Game> games;//拥有的游戏
    private List<Review> reviews;//写的评论
    private List<Picture> pictures;//照片
}
