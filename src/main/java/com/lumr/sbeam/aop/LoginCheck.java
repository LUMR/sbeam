package com.lumr.sbeam.aop;

import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.vo.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * 登陆检查
 * Created by lumr on 2017/5/9.
 */
@Aspect
public class LoginCheck {

    @Before("execution(public String com.lumr.sbeam.controller.UserController.*(..))")
    public void checkUser() {
        System.out.println("aop开始");
    }
}
