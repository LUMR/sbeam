package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by fsweb on 17-5-8.
 */
@Getter
@Setter
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

}
