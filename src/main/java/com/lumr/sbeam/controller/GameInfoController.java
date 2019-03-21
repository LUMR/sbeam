package com.lumr.sbeam.controller;

import com.lumr.sbeam.dto.GameDto;
import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
@RestController
@RequestMapping(value = "/game")
public class GameInfoController {

    @Autowired
    private GameService gameService;

    @GetMapping("list")
    public List<Game> queryGames(GameDto dto) {
        return gameService.queryGames(dto);
    }

    @PostMapping("add")
    public Boolean addGame(@RequestBody GameDto dto){
        dto.setId(null);
        return gameService.addGame(dto);
    }

    @PutMapping("{id}/update")
    public Boolean updateGame(@PathVariable String id,@RequestBody GameDto dto){
        dto.setId(Integer.valueOf(id));
        return gameService.updateGame(dto);
    }

    @DeleteMapping("{id}/delete")
    public Boolean deleteGame(@PathVariable String id){
        return gameService.deleteGame(id);
    }
}
