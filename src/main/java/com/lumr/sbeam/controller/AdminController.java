package com.lumr.sbeam.controller;

import com.lumr.sbeam.exception.LoginException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 基础类
 * Created by fsweb on 17-5-10.
 */
public class AdminController {
    //***********异常解决***********
    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "user/login";
    }
}
