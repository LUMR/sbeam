package com.lumr.sbeam.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色权限
 *
 * @author lumr freedomyes@sina.com
 * @since 2019-04-03
 **/
@TableName("sys_permission")
public class Permission {

    private Integer id;
    private String name;
    private String permission;
    private String resourceType;
    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
