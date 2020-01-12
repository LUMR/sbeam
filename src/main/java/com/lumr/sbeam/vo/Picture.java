package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 游戏图片
 * Created by lumr on 2017/5/8.
 */
@Getter
@Setter
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

    public Picture(Integer id, Integer gameId, String fileName, String src) {
        this.id = id;
        this.gameId = gameId;
        this.fileName = fileName;
        this.src = src;
    }


}
