package com.lumr.sbeam.controller;

import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.vo.User;

import javax.servlet.http.HttpSession;

/**
 * Created by lumr on 2017/5/9.
 */
public class BaseController {
    protected User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user ==null)
            throw new LoginException("你还没登陆，没有权限。");
        return user;
    }
}
