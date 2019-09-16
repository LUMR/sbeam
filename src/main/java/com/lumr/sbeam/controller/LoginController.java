package com.lumr.sbeam.controller;

import com.lumr.sbeam.service.UserService;
import com.lumr.sbeam.utils.Utils;
import com.lumr.sbeam.vo.BuyCar;
import com.lumr.sbeam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 登入，注册管理
 * Created by lumr on 2017/5/9.
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkName", method = RequestMethod.POST)
    @ResponseBody
    public String checkName(String name, HttpSession session, HttpServletResponse response) {
        UserVO user = new UserVO(name, "no");
        response.setCharacterEncoding("UTF-8");
        if (userService.checkUserName(user)!=null){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") UserVO user) {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated UserVO user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors())
            return "user/register";
        String password = Utils.sha1(user.getPassword());
        user.setPassword(password);
        user.setRegisterDate(new Date());
        int userId = userService.insertUser(user);
        if (userId > 0) {
            user = userService.getUser(user);
            session.setAttribute("user", user);
            session.setAttribute("buyCar",new BuyCar(user));
            return "redirect:details";
        } else
            return "user/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") UserVO user) {
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserVO user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors())
            return "user/login";
        return "redirect:/user/details";
    }
}
