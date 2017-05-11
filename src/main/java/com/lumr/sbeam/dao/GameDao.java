package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lumr on 2017/5/9.
 */
@Mapper
@Repository
public interface GameDao {
    List<Game> getBuy();

    List<Game> getHot();

    List<Game> getNew();

    Game getGame(Game game);

    List<Game> getGames(Game game);

    int deleteGame(Game game);

    int insert(@Param("pojo") Game pojo);

    int insertSelective(@Param("pojo") Game pojo);

    int insertList(@Param("pojos") List<Game> pojo);

    int update(@Param("pojo") Game pojo);

}

