package com.lumr.sbeam.vo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户对象
 * Created by fsweb on 17-5-8.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private Header header;//头像
    private Double money;//拥有的金钱
    private Date registerDate;//注册日期
    private List<Game> games;//拥有的游戏
    private List<Review> reviews;//写的评论
    private List<Picture> pictures;//照片
    private LinkedList<String> messages = new LinkedList<>();//用户消息，不保存在数据库中

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public LinkedList<String> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<String> messages) {
        this.messages = messages;
    }
}
