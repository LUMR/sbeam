package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.vo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fsweb on 17-5-10.
 */
@Controller
@RequestMapping(value = "/admin/game")
public class AdminGameController extends AdminController{
    @Autowired
    private GameDao gameDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PlatformDao platformDao;
    //***********游戏部分***********

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String gameManager(Integer cid, Integer pid, Model model){
        Game game = new Game(cid, pid);
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("platforms", platformDao.getAllPlatforms());
        model.addAttribute("games", gameDao.getGames(game));
        return "/admin/gameManager";
    }

    private Integer parseInt(String str) {
        Integer i;
        if (str == null)
            return 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
        return i;
    }
}
