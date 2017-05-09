package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.HeaderDao;
import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 用户管理
 * Created by fsweb on 17-5-8.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private HeaderDao headerDao;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpSession session) {
        User user = getUser(session);
        User newUser = userDao.getUser(user);
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
        userDao.recharge(user, money);
        user.getMessages().addFirst("时间：" + new Date() + "充值成功！");
        return "redirect:/user/details";
    }

    @RequestMapping(value = "/details/update", method = RequestMethod.GET)
    public String update(Model model, HttpSession session) {
        model.addAttribute("user", getUser(session));
        return "user/update";
    }

    @RequestMapping(value = "/details/update", method = RequestMethod.POST)
    public String update(User user, MultipartFile headerFile, HttpSession session, Model model) {
        User realUser = (User) session.getAttribute("user");
        int result = userDao.updateUser(user);
        if (result > 0)
            realUser.getMessages().addFirst("信息更新成功");
        else
            realUser.getMessages().addFirst("信息更新失败");
        //设定上传路径
        if (!headerFile.isEmpty()) {
            String uploadFilePath = session.getServletContext().getRealPath("/header/");
            String fileName = headerFile.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            System.out.println(fileType);

            File file = new File(uploadFilePath, realUser.getName() + fileType);
            try {
                headerFile.transferTo(file);
                realUser.getHeader().setSrc("/header/" + file.getName());
                headerDao.update(realUser.getHeader());
            } catch (IOException e) {
                model.addAttribute("message", "文件上传失败");
                return "redirect:/user/details";
            }
            realUser.getMessages().addFirst("上传成功:" + file.getName());
        }
        return "/user/details";
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
