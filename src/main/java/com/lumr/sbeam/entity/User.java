package com.lumr.sbeam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author lumr freedomyes@sina.com
 * @since 2019-04-02
 **/
@Getter
@Setter
public class User{

    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String password;
    private String headerId;
    private String money;
    private Date registerDate;
    private Integer isAdmin;
    @TableField(exist = false)
    private List<Role> roles;
    @TableField(exist = false)
    private List<Permission> permissions;

}
