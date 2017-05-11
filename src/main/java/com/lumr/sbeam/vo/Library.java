package com.lumr.sbeam.vo;

/**
 * 游戏仓库
 * Created by fsweb on 17-5-8.
 */
public class Library {
    private Integer id;
    private Integer userId;
    private Integer gameId;

    public Library() {
    }

    public Library(int userId, int gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
