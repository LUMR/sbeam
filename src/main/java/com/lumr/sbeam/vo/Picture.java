package com.lumr.sbeam.vo;

/**
 * 游戏图片
 * Created by lumr on 2017/5/8.
 */
public class Picture {
    private Integer id;
    private Integer gameId;
    private String fileName;
    private String src;

    public Picture() {
    }

    public Picture(int gameId, String fileName, String src) {
        this.gameId = gameId;
        this.fileName = fileName;
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGame() {
        return gameId;
    }

    public void setGame(int gameId) {
        this.gameId = gameId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
