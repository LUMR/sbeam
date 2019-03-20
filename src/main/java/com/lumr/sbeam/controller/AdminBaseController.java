package com.lumr.sbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
