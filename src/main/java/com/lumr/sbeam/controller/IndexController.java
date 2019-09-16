package com.lumr.sbeam.controller;

import com.lumr.sbeam.service.GameService;
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
    private GameService gameService;

    @RequestMapping(value = {"/index","/","","index.jsp"})
    public String index(Model model){
        List<Game> hotGames = gameService.getHot();
        List<Game> newGames = gameService.getNew();
        List<Game> buyGames = gameService.getBuy();

        model.addAttribute("hotGames", hotGames);
        model.addAttribute("newGames", newGames);
        model.addAttribute("buyGames", buyGames);
        return "index";
    }
}
