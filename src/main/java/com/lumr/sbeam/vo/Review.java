package com.lumr.sbeam.vo;

import java.util.Date;

/**
 * Created by fsweb on 17-5-8.
 */
public class Review {
    private int id;
    private Game game;//对应的游戏
    private User user;//发布人
    private String title;//标题
    private String content;//内容
    private Date pubDate;//发表日期
    private Date upDate;//修改日期

    public Review() {
    }

    public Review(Game game, User user, String title, String content) {
        this.game = game;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
