package com.lumr.sbeam.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户头像
 * Created by fsweb on 17-5-8.
 */
@Getter
@Setter
public class Header {
    private Integer id;
    private String fileName;//文件名
    private String src;//文件地址

    public Header() {
    }

    public Header(String fileName, String src) {
        this.fileName = fileName;
        this.src = src;
    }

}
