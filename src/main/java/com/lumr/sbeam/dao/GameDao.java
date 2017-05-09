package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.Game;

import java.util.List;

/**
 * Created by lumr on 2017/5/9.
 */
public interface GameDao {
    Game getGame(Game game);

    List<Game> getGames(Game game);

    int addGame(Game game);

    int updateGame(Game game);

    int deleteGame(Game game);

}
