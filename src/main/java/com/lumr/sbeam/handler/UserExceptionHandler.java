package com.lumr.sbeam.handler;

import com.lumr.sbeam.exception.LoginException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常解决类
 * Created by lumr on 2017/5/9.
 */
public class UserExceptionHandler {
    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e, Model model) {
        model.addAttribute("message", e);
        return "user/login";
    }
}
