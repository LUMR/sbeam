package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.vo.Category;
import com.lumr.sbeam.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lumr on 2017/5/9.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = {"/", ""})
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping(value = "/category")
    public String getCategory(Model model) {
        model.addAttribute("categories", categoryDao.getAllCategories());
        return "admin/categoryManager";
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
                user.getMessages().addFirst("时间：" + new Date() + ",修改分类成功。");
                return "redirect:/admin";
            } else {
                model.addAttribute("message", "修改失败");
            }
        } else {
            model.addAttribute("message", "修改失败，ID不匹配");
        }
        return "admin/updateCategory";
    }
}
