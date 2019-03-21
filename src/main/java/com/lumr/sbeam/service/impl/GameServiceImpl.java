package com.lumr.sbeam.service.impl;

import com.lumr.sbeam.dto.GameDto;
import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.mapper.GameMapper;
import com.lumr.sbeam.service.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Override
    public List<Game> queryGames(GameDto dto) {
        return gameMapper.selectList(null);
    }

    @Override
    public boolean addGame(GameDto dto) {
        Game game = new Game();
        BeanUtils.copyProperties(dto,game);
        return gameMapper.insert(game) > 0;
    }

    @Override
    public boolean updateGame(GameDto dto) {
        return gameMapper.updateById(dto) > 0;
    }

    @Override
    public boolean deleteGame(String id) {
        return gameMapper.deleteById(id) > 0;
    }
}
