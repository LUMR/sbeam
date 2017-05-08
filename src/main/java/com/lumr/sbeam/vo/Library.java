package com.lumr.sbeam.vo;

/**
 * 游戏仓库
 * Created by fsweb on 17-5-8.
 */
public class Library {
    private int id;
    private int userId;
    private int gameId;

    public Library() {
    }

    public Library(int userId, int gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
