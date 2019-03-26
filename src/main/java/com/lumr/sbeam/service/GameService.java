package com.lumr.sbeam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lumr.sbeam.dto.GameDto;
import com.lumr.sbeam.entity.Game;

import java.util.List;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
public interface GameService {

    List<Game> queryGames(GameDto dto);

    IPage<Game> pageQueryGames(GameDto dto);

    boolean addGame(GameDto dto);

    boolean updateGame(GameDto dto);

    boolean deleteGame(String id);
}
