package com.lumr.sbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VueTestController
 */
@Controller
@RequestMapping(value = "/vue")
public class VueTestController {

    @GetMapping("test")
    public String toVue() {
        return "vue/test";
    }
}