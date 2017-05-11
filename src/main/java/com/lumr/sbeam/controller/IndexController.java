package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.vo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lumr on 2017/5/12.
 */
@Controller
public class IndexController {
    @Autowired
    private GameDao gameDao;

    @RequestMapping(value = {"/index","/","","index.jsp"})
    public String index(Model model){
        List<Game> hotGames = gameDao.getHot();
        List<Game> newGames = gameDao.getNew();
        List<Game> buyGames = gameDao.getBuy();

        model.addAttribute("hotGames", hotGames);
        model.addAttribute("newGames", newGames);
        model.addAttribute("buyGames", buyGames);
        return "index";
    }
}
