package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.dao.LibraryDao;
import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.vo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fsweb on 17-5-10.
 */
@Controller
@RequestMapping(value = "/library")
public class LibraryController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private GameDao gameDao;
    @Autowired
    private LibraryDao libraryDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String libraryView(String cid, String pid, Model model) {
        System.out.println(cid);
        System.out.println(pid);
        List<Game> games = gameDao.getGames(new Game(parseInt(cid), parseInt(pid)));
        model.addAttribute("games", games);
        return "/library/games";
    }

    @RequestMapping(value = "/game/{id}")
    public String gameDetails(@PathVariable String id, Model model) {
        Integer gid = parseInt(id);
        Game game = gameDao.getGame(new Game(gid));
        if (game == null) {
            model.addAttribute("message", "没有该游戏.");
        } else {
            model.addAttribute("game", game);
            model.addAttribute("sales", libraryDao.getSales(game));
        }
        return "/library/game";
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
