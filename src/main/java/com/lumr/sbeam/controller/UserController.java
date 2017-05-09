package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.utils.Utils;
import com.lumr.sbeam.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
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
        session.setAttribute("user",newUser);
        return "user/details";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") User user) {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors())
            return "user/register";
        String password = Utils.sha1(user.getPassword());
        user.setPassword(password);
        user.setRegisterDate(new Date());
        int userId = dao.insertUser(user);
        if (userId > 0) {
            session.setAttribute("user", dao.getUser(user));
            return "redirect:details";
        } else
            return "user/register";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") User user) {
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors())
            return "user/login";
        String password = Utils.sha1(user.getPassword());
        user.setPassword(password);
        User realUser = dao.getUser(user);
        if (realUser == null) {
            model.addAttribute("message", "没有该用户名。");
            return "user/login";
        }
        if (realUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", realUser);
            return "redirect:details";
        } else {
            model.addAttribute("message", "密码错误");
            return "user/login";
        }
    }

    @RequestMapping(value = "/recharge",method = RequestMethod.GET)
    public String recharge(){
        return "user/recharge";
    }

    @RequestMapping(value = "/recharge",method = RequestMethod.POST)
    public String recharge(double money, HttpSession session){
        User user = getUser(session);
        dao.recharge(user, money);
        user.getMessages().addFirst("时间："+new Date()+"充值成功！");
        return "redirect:/user/details";
    }
    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e,Model model){
        model.addAttribute("message", e);
        return "user/login";
    }

    private User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user ==null)
            throw new LoginException("你还没登陆，没有权限。");
        return user;
    }
}
