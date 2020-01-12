package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by lumr on 2017/5/8.
 */
@Getter
@Setter
public class Platform {
    private Integer id;
    private String name;
    private List<Game> games;

    public Platform(Integer id) {
        this.id = id;
    }

    public Platform() {
    }

}
