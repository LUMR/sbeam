package com.lumr.sbeam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色权限
 *
 * @author lumr freedomyes@sina.com
 * @since 2019-04-03
 **/
@TableName("sys_permission")
@Getter
@Setter
public class Permission {

    private Integer id;
    private String name;
    private String permission;
    private String resourceType;
    private Integer available;

}
