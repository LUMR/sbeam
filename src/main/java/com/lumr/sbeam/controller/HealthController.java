package com.lumr.sbeam.controller;

import com.lumr.sbeam.dto.JavaFileDto;
import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.mapper.GameMapper;
import com.lumr.sbeam.utils.ClassModifier;
import com.lumr.sbeam.utils.Executor;
import com.lumr.sbeam.utils.HotSwapClassLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE;

/**
 * @author lumr
 * @since 2019-03-25 21:40
 */
@RestController
@RequestMapping("/health/")
public class HealthController implements ApplicationContextAware {

    @Autowired
    private GameMapper gameMapper;

    private ApplicationContext context;

    private HotSwapClassLoader classLoader = new HotSwapClassLoader();

    @GetMapping("threads")
    public String getTrace() {
        StringBuilder builder = new StringBuilder();
        Thread.getAllStackTraces().forEach((k, v) -> {
            builder.append(String.format("%n 线程：%s %n", k.getName()));

            for (StackTraceElement stackTraceElement : v) {
                builder.append(String.format("\t %s %n", stackTraceElement));
            }
        });
        return builder.toString();
    }

    @GetMapping("gctest")
    public String gcTest() {
        List<Game> games = gameMapper.selectList(null);

        int size = games.size();
        List<Game> newGames = new ArrayList<>(games.size());
        for (int i = size-1; i >= 0; i--) {
            Game game = games.remove(i);
            game.setId(null);
            game.setName(game.getName());
            gameMapper.insert(game);
        }

        return size*2 + "个";

    }

    @SuppressWarnings("unchecked")
    @PostMapping("/java/execute")
    public String execute(@RequestBody JavaFileDto dto){
        Class<? extends Executor> clazz = new HotSwapClassLoader().loadByte(dto.getName(),dto.getJavaStr());

        try {
            Executor executor = clazz.newInstance();
            context.getAutowireCapableBeanFactory().autowireBeanProperties(executor,AUTOWIRE_BY_TYPE,true);
            return executor.executor();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
