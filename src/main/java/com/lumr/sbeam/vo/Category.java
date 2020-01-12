package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 游戏分类
 * Created by fsweb on 17-5-8.
 */
@Alias("Category")
@Getter
@Setter
public class Category {
    private Integer id;
    private String name;//分类名
    private List<Game> games;//游戏集合

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
