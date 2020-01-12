package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 游戏仓库
 * Created by fsweb on 17-5-8.
 */
@Getter
@Setter
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

}
