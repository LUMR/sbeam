package com.lumr.test;

import com.lumr.sbeam.Application;
import com.lumr.sbeam.config.RootConfig;
import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.vo.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class, RootConfig.class})
@TestPropertySource({"/application.yml", "/application-dev.yml"})
public class GameGenUtil {
    @Autowired
    private GameDao gameDao;

    @Test
    public void genGame() {
        Game game = new Game();
        Random random = new Random();
        int name;
        for (int j = 0; j < 100; j++) {
            StringBuilder gameName = new StringBuilder();
            for (int i = 0; i < random.nextInt(5) + 1; i++) {
                name = random.nextInt(0x51A5) + 0x4E00;
                gameName.append((char) name);
            }
            game.setName(gameName.toString());
            game.setCategoryId(random.nextInt(5) + 1);
            game.setPlatformId(random.nextInt(4) + 1);
            game.setDescription("暂无描述");
            game.setPrice((double) random.nextInt(300));
            gameDao.insertSelective(game);
            System.out.println("导入游戏ID：" + game.getId());
        }


    }
}
