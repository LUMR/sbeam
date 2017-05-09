package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.vo.Category;
import com.lumr.sbeam.vo.Platform;
import com.lumr.sbeam.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 管理员管理
 * Created by lumr on 2017/5/9.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PlatformDao platformDao;

    @RequestMapping(value = {"/", ""})
    public String admin() {
        return "admin/admin";
    }

    //***********分类部分***********

    @RequestMapping(value = "/category")
    public String getCategory(Model model) {
        model.addAttribute("categories", categoryDao.getAllCategories());
        return "admin/categoryManager";
    }

    @RequestMapping(value = "/category/add",method = RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "admin/addCategory";
    }

    @RequestMapping(value = "/category/add",method = RequestMethod.POST)
    public String addCategory(Category category,HttpSession session,Model model){
        category.setId(null);
        if (categoryDao.getCategory(category) == null){
            int result = categoryDao.insert(category);
            User user = (User) session.getAttribute("user");
            if (result > 0) {
                user.getMessages().addFirst("时间：" + new Date() + ",添加分类信息成功。");
                return "redirect:/admin";
            } else {
                model.addAttribute("message", "添加失败");
            }
        } else {
            model.addAttribute("message", "添加失败，分类已存在");
        }
        return "admin/addCategory";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String updateCategory(@PathVariable int id, Model model) {
        Category category = categoryDao.getCategory(new Category(id));
        model.addAttribute("category", category);
        return "admin/updateCategory";
    }

    @RequestMapping(value = "/category/{id}/update", method = RequestMethod.POST)
    public String updateCategory(@PathVariable Integer id, Category category, HttpSession session, Model model) {
        if (id != null && id == category.getId()) {
            int result = categoryDao.update(category);
            User user = (User) session.getAttribute("user");
            if (result > 0) {
                user.getMessages().addFirst("时间：" + new Date() + ",修改分类信息成功。");
                return "redirect:/admin";
            } else {
                model.addAttribute("message", "修改失败");
            }
        } else {
            model.addAttribute("message", "修改失败，ID不匹配");
        }
        return "admin/updateCategory";
    }

    //***********平台部分***********

    @RequestMapping(value = "/platform")
    public String getPlatform(Model model) {
        model.addAttribute("platforms", platformDao.getAllPlatforms());
        return "admin/platformManager";
    }

    @RequestMapping(value = "/platform/add",method = RequestMethod.GET)
    public String addPlatform(Model model){
        model.addAttribute("platform",new Platform());
        return "admin/addPlatform";
    }

    @RequestMapping(value = "/platform/add",method = RequestMethod.POST)
    public String addPlatform(Platform platform,HttpSession session,Model model){
        platform.setId(null);
        if (platformDao.getPlatform(platform) == null){
            int result = platformDao.insert(platform);
            User user = (User) session.getAttribute("user");
            if (result > 0) {
                user.getMessages().addFirst("时间：" + new Date() + ",添加平台信息成功。");
                return "redirect:/admin";
            } else {
                model.addAttribute("message", "添加失败");
            }
        } else {
            model.addAttribute("message", "添加失败，平台已存在");
        }
        return "admin/addPlatform";
    }

    @RequestMapping(value = "/platform/{id}", method = RequestMethod.GET)
    public String updatePlatform(@PathVariable int id, Model model) {
        Platform platform = platformDao.getPlatform(new Platform(id));
        model.addAttribute("platform", platform);
        return "admin/updatePlatform";
    }
    @RequestMapping(value = "/platform/{id}/update", method = RequestMethod.POST)
    public String updatePlatform(@PathVariable Integer id, Platform platform, HttpSession session, Model model) {
        if (id != null && id == platform.getId()) {
            int result = platformDao.update(platform);
            User user = (User) session.getAttribute("user");
            if (result > 0) {
                user.getMessages().addFirst("时间：" + new Date() + ",修改平台信息成功。");
                return "redirect:/admin";
            } else {
                model.addAttribute("message", "修改失败");
            }
        } else {
            model.addAttribute("message", "修改失败，ID不匹配");
        }
        return "admin/updatePlatform";
    }

    //***********游戏部分***********




    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "user/login";
    }
}
