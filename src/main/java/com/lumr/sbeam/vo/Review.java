package com.lumr.sbeam.vo;

import java.util.Date;

/**
 * Created by fsweb on 17-5-8.
 */
public class Review {
    private Integer id;
    private Integer gameId;//对应的游戏
    private Integer userId;//发布人
    private String title;//标题
    private String content;//内容
    private Date pubDate;//发表日期
    private Date upDate;//修改日期

    public Review() {
    }

    public Review(Integer gameId, Integer userId, String title, String content, Date pubDate) {
        this.gameId = gameId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
