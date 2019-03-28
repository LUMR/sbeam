package com.lumr.sbeam.controller;

import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lumr
 * @since 2019-03-25 21:40
 */
@RestController
@RequestMapping("/health/")
public class HealthController {

    @Autowired
    private GameMapper gameMapper;

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
}
