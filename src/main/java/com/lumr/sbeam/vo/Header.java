package com.lumr.sbeam.vo;

/**
 * 用户头像
 * Created by fsweb on 17-5-8.
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
