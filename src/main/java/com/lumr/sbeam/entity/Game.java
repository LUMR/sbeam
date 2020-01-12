package com.lumr.sbeam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
@Getter
@Setter
public class Game {
    @TableId(type = IdType.ID_WORKER)
    private Integer id;
    private String name;//游戏名
    private Integer categoryId;//游戏分类
    private Integer platformId;//游戏平台
    private Double price;//游戏价格
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;
    private String description;//游戏描述

}
