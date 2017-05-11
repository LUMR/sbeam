package com.lumr.sbeam.controller;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.dao.PictureDao;
import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.vo.Game;
import com.lumr.sbeam.vo.Picture;
import com.lumr.sbeam.vo.User;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by fsweb on 17-5-10.
 */
@Controller
@RequestMapping(value = "/admin/game")
public class AdminGameController extends AdminController {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private PictureDao pictureDao;
    //***********游戏部分***********

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String gameManager(Integer cid, Integer pid, Model model) {
        Game game = new Game(cid, pid);
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("platforms", platformDao.getAllPlatforms());
        model.addAttribute("games", gameDao.getGames(game));
        return "/admin/gameManager";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("platforms", platformDao.getAllPlatforms());
        return "/admin/addGame";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGame(Game game, BindingResult bindingResult, MultipartFile[] files, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (bindingResult.hasErrors()){
            String message = (new Date()+"添加失败，游戏数据错误。错误区域：");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error:errors){
                message += error.getField();
            }
            user.getMessages().addFirst(message);
            return "/user/details";
        }

        if (gameDao.getGame(game) != null) {
            user.getMessages().addFirst("添加失败，游戏名已存在。");
            return "/admin/addGame";
        }
        int result = gameDao.insert(game);
        if (result > 0) {
            user.getMessages().addFirst("时间：" + new Date() + "游戏添加成功。");
            Game theGame = gameDao.getGame(game);
            //处理上传文件
            String filePath = session.getServletContext().getRealPath("/pictures/");
            for (MultipartFile multipartFile : files) {
                if (!multipartFile.isEmpty()) {
                    File file = new File(filePath, multipartFile.getOriginalFilename());
                    try {
                        multipartFile.transferTo(file);
                        pictureDao.insert(new Picture(theGame.getId(), file.getName(), "/pictures/" + file.getName()));
                    } catch (IOException e) {
                        user.getMessages().addFirst("时间：" + new Date() + "上传文件" + multipartFile.getOriginalFilename() + "失败");
                    }
                }
            }
            user.getMessages().addFirst("时间：" + new Date() + "文件处理完毕。");
        } else
            user.getMessages().addFirst("时间：" + new Date() + "游戏添加失败。");
        return "/admin/gameManager";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String addTest(@RequestParam("test") String[] test) {
        for (String str :
                test) {
            System.out.println(str);
        }
        return "/admin/addGame";
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

    private String getFileType(String str, Game game) {
        String fileType = str.substring(str.lastIndexOf("."));
        return fileType;
    }
}
