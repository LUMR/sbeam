package com.lumr.sbeam.test;

import com.lumr.sbeam.dao.GameDao;
import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.vo.Game;
import com.lumr.sbeam.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试用的类
 * Created by lumr on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        test.SQLThreadTest();
        randomInsertGame();
    }

    /**
     * 获取dao
     * @return Dao
     */
    public static Object getDao(String dao) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        return  ctx.getBean(dao);
    }

    public void SQLThreadTest(){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new UserChange());
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.execute(new UserChange());
        exec.shutdown();
    }

    public static void userChange(){
        UserDao dao = (UserDao)getDao("userDao");
        User user = dao.getUser(new User(2));
        if (user.getMoney()>9000)
            dao.recharge(user, 1000);
        System.out.println("当前用户余额："+user.getMoney());
        }

    /**
     * 报错
     */
    private class UserChange implements Runnable{
        @Override
        public void run() {
            UserDao dao = (UserDao)getDao("userDao");
            User user = dao.getUser(new User(2));
            if (user.getMoney()>9000)
                dao.pay(user, 500);
            System.out.println("当前用户余额："+user.getMoney());
            System.out.println("更新后余额："+dao.getUser(user).getMoney());
        }
    }

    /**
     * 随机插入新游戏
     */
    public static void randomInsertGame(){
        Game game = new Game();
        Random random = new Random();
        int name;
        GameDao gameDao = getGameDao();
        for (int j = 0; j < 100; j++) {
            StringBuffer gameName = new StringBuffer();
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

    /**
     * 获取GAMEDAO
     * @return
     */
    public static GameDao getGameDao() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        return (GameDao) ctx.getBean("gameDao");
    }
}
