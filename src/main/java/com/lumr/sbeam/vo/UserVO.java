package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户对象
 * Created by fsweb on 17-5-8.
 */
@Getter
@Setter
public class UserVO {
    private Integer id;
    private String name;
    private String password;
    private Header header;//头像
    private Double money;//拥有的金钱
    private Date registerDate;//注册日期
    private Integer isAdmin;
    private List<Game> games;//拥有的游戏
    private List<Review> reviews;//写的评论
    private LinkedList<String> messages = new LinkedList<>();//用户消息，不保存在数据库中

    public UserVO() {
    }

    public UserVO(int id) {
        this.id = id;
    }

    public UserVO(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
