package com.lumr.sbeam.controller;

import com.lumr.sbeam.service.CategoryService;
import com.lumr.sbeam.vo.Category;
import com.lumr.sbeam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by fsweb on 17-5-10.
 */
@Controller
@RequestMapping(value = "/admin/category")
public class AdminCategoryController extends AdminController {

    @Autowired
    private CategoryService categoryService;

    //***********分类部分***********

    @RequestMapping(value = "")
    public String getCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/categoryManager";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "admin/addCategory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(Category category, HttpSession session, Model model) {
        category.setId(null);
        if (categoryService.getCategory(category) == null) {
            int result = categoryService.insert(category);
            UserVO user = (UserVO) session.getAttribute("user");
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String updateCategory(@PathVariable int id, Model model) {
        Category category = categoryService.getCategory(new Category(id));
        model.addAttribute("category", category);
        return "admin/updateCategory";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateCategory(@PathVariable Integer id, Category category, HttpSession session, Model model) {
        if (id != null && id.equals(category.getId())) {
            int result = categoryService.update(category);
            UserVO user = (UserVO) session.getAttribute("user");
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

}
