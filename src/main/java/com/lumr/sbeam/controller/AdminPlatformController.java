package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.vo.Platform;
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
 * Created by fsweb on 17-5-10.
 */
@Controller
@RequestMapping(value = "/admin/platform")
public class AdminPlatformController extends AdminController{
    @Autowired
    private PlatformDao platformDao;

    //***********平台部分***********

    @RequestMapping(value = "")
    public String getPlatform(Model model) {
        model.addAttribute("platforms", platformDao.getAllPlatforms());
        return "admin/platformManager";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPlatform(Model model){
        model.addAttribute("platform",new Platform());
        return "admin/addPlatform";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addPlatform(Platform platform, HttpSession session, Model model){
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String updatePlatform(@PathVariable int id, Model model) {
        Platform platform = platformDao.getPlatform(new Platform(id));
        model.addAttribute("platform", platform);
        return "admin/updatePlatform";
    }
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
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
}
