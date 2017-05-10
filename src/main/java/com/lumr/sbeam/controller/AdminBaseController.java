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
public class AdminBaseController extends AdminController{
    @RequestMapping(value = "")
    public String admin() {
        return "admin/admin";
    }
}
