package com.lumr.sbeam.controller.api.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lumr.sbeam.dto.GameDto;
import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019/9/6
 **/
@RestController(value = "/api/game")
public class GameManagerController {
    @Autowired
    private GameService gameService;

    @PostMapping("add")
    public boolean add(GameDto dto){
        return gameService.addGame(dto);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable(name = "id") String id, GameDto dto){
        dto.setId(Integer.valueOf(id));
        return gameService.updateGame(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(name = "id") String id){
        return gameService.deleteGame(id);
    }

    @GetMapping("/query")
    public IPage<Game> query(GameDto dto){
        return gameService.pageQueryGames(dto);
    }
}
