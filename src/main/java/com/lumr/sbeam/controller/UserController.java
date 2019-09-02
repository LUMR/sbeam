package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.dao.HeaderDao;
import com.lumr.sbeam.dao.LibraryDao;
import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.exception.LoginException;
import com.lumr.sbeam.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 * Created by fsweb on 17-5-8.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private HeaderDao headerDao;
    @Autowired
    private LibraryDao libraryDao;
    @Autowired
    private GameDao gameDao;
    @Value("${web.upload-path}")
    private String uploadPath;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpSession session) {
        updateUser(session);
        return "user/details";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String recharge() {
        return "user/recharge";
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String recharge(double money, HttpSession session) {
        User user = getUser(session);
        userDao.recharge(user, money);
        user.getMessages().addFirst("时间：" + new Date() + "充值成功！");
        return "redirect:/user/details";
    }

    /**
     * 买游戏结算
     * @param gameId
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/game/{gameId}/buy")
    public String buyGame(@PathVariable String gameId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int id;
        Game game;
        Library library;
        try {
            id = Integer.parseInt(gameId);
            game = gameDao.getGame(new Game(id));
            library = libraryDao.check(user, game);
        } catch (Exception e) {
            user.getMessages().addFirst("购买失败，不存在该游戏");
            return "redirect:/user/details";
        }
        if (library == null) {
            if (user.getMoney()<game.getPrice()){
                user.getMessages().addFirst("你的余额不足，请去充值。");
                return "redirect:/user/details";
            }
            //结算
            libraryDao.add(user, game);
            userDao.pay(user, game.getPrice());
            user.getGames().add(game);
            user.getMessages().addFirst("时间：" + new Date() + "购买游戏:" + game.getName());
        } else {
            user.getMessages().addFirst("你已拥有该游戏 ");
        }
        return "redirect:/user/library";
    }

    @RequestMapping(value = "/game/{gameId}/add", method = RequestMethod.GET)
    @ResponseBody
    public int addGame(@PathVariable("gameId") String gameId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        BuyCar buyCar = (BuyCar) session.getAttribute("buyCar");
        int id;
        Game game;
        Library library;
        try {
            id = Integer.parseInt(gameId);
            game = gameDao.getGame(new Game(id));
            library = libraryDao.check(user, game);
            if (library == null) {
                return buyCar.addGame(game);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/buyCar")
    public String seeBuyCar(Model model, HttpSession session) {
        BuyCar buyCar = (BuyCar) session.getAttribute("buyCar");
        model.addAttribute(buyCar);
        return "user/buyCar";
    }

    /**
     * 购物车结算
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/buyCar/sum")
    public String sumBuyCar(Model model, HttpSession session) {
        BuyCar buyCar = (BuyCar) session.getAttribute("buyCar");
        User user = (User) session.getAttribute("user");
        if (user.getMoney() < buyCar.getTotal()) {
            user.getMessages().addFirst("RMB不足，结算失败，请先充值。");
            return "redirect:/user/buyCar";
        }
        List<Library> libraryList = new ArrayList<>();
        for (Game game : buyCar.getGames()) {
            libraryList.add(new Library(user.getId(), game.getId()));
        }
        //结算
        libraryDao.insertList(libraryList);
        userDao.pay(user, buyCar.getTotal());
        user.getMessages().addFirst(new Date() + "结算完成，你购买了" + buyCar.getGames().size() + "个游戏，谢谢惠顾！");
        buyCar.getGames().clear();
        updateUser(session);
        return "redirect:/user/library";
    }

    @RequestMapping(value = "/game/{gameId}/delete", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("gameId") String gameId, Model model, HttpSession session) {
        BuyCar buyCar = (BuyCar) session.getAttribute("buyCar");
        User user = (User) session.getAttribute("user");
        try {
            buyCar.deleteGame(Integer.parseInt(gameId));
        } catch (Exception e) {
            user.getMessages().addFirst("购物车没有该游戏，删除失败。");
            return "redirect:/user/buyCar";
        }
        user.getMessages().addFirst("删除游戏成功.");
        return "redirect:/user/buyCar";
    }

    @RequestMapping(value = "/details/update", method = RequestMethod.GET)
    public String update(Model model, HttpSession session) {
        model.addAttribute("user", getUser(session));
        return "user/update";
    }

    @RequestMapping(value = "/details/update", method = RequestMethod.POST)
    public String update(User user, MultipartFile headerFile, HttpSession session, Model model) {
        User realUser = (User) session.getAttribute("user");
        int result = userDao.updateUser(user);
        if (result > 0)
            realUser.getMessages().addFirst("信息更新成功");
        else
            realUser.getMessages().addFirst("信息更新失败");
        //设定上传路径
        if (!headerFile.isEmpty()) {
            String fileName = headerFile.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));

            File file = new File(uploadPath.concat("/header"), realUser.getName() + fileType);
            try {
                headerFile.transferTo(file);
                realUser.getHeader().setSrc("/public/header/" + file.getName());
                headerDao.update(realUser.getHeader());
            } catch (IOException e) {
                model.addAttribute("message", "文件上传失败");
                e.printStackTrace();
                return "redirect:/user/details";
            }
            realUser.getMessages().addFirst("上传成功:" + file.getName());
        }
        return "redirect:/user/details";
    }

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String library(Model model, HttpSession session) {
        User user = getUser(session);
        model.addAttribute("gameLibrary", user.getGames());
        return "user/library";
    }

    @RequestMapping(value = "/library/{id}/delete", method = RequestMethod.GET)
    public String deleteGame(@PathVariable String id, HttpSession session, Model model) {
        User user = getUser(session);
        Integer gameId;
        try {
            gameId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            user.getMessages().addFirst("游戏ID错误，无法删除" + new Date());
            return "redirect:/user/library";
        }
        int result = libraryDao.delete(user, new Game(gameId));
        if (result > 0) {
            user.getMessages().addFirst("删除游戏成功。" + new Date());
            user.getMessages().size();
            updateUser(session);
        } else {
            user.getMessages().addFirst("删除失败，没有该游戏" + new Date());
        }
        return "redirect:/user/library";
    }

    @RequestMapping(value = "/messages")
    public String getMessages() {
        return "user/messages";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Picture getFiles(MultipartFile file, HttpSession session) {
        if (file.isEmpty()) {
            return null;
        }
        String filePath = session.getServletContext().getRealPath("/pictures/");
        File newFile = new File(filePath, file.getOriginalFilename());
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            return null;
        }
        return new Picture(1, 1, newFile.getName(), "/pictures/" + newFile.getName());
    }

    @ExceptionHandler(LoginException.class)
    public String handlerException(LoginException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "redirect:/user/login";
    }

    private User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            throw new LoginException("你还没登陆，没有权限。");
        return user;
    }

    private void updateUser(HttpSession session) {
        User user = getUser(session);
        User newUser = userDao.getUser(user);
        newUser.setMessages(user.getMessages());
        session.setAttribute("user", newUser);
    }
}
