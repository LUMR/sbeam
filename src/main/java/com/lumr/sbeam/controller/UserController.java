package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.utils.Utils;
import com.lumr.sbeam.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 用户管理
 * Created by fsweb on 17-5-8.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserDao dao;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpSession session) {
        User user = getUser(session);
        User newUser = dao.getUser(user);
        newUser.setMessages(user.getMessages());
        session.setAttribute("user", newUser);
        return "user/details";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String recharge() {
        return "user/recharge";
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String recharge(double money, HttpSession session) {
        User user = getUser(session);
        dao.recharge(user, money);
        user.getMessages().addFirst("时间：" + new Date() + "充值成功！");
        return "redirect:/user/details";
    }

    @RequestMapping(value = "/details/update",method = RequestMethod.GET)
    public String update(Model model,HttpSession session){
        model.addAttribute("user", getUser(session));
        return "user/update";
    }

    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "user/login";
    }

    private User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            throw new LoginException("你还没登陆，没有权限。");
        return user;
    }
}
