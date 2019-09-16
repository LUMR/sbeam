package com.lumr.sbeam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lumr.sbeam.dto.GameDto;
import com.lumr.sbeam.entity.Game;

import java.util.List;

/**
 * 游戏信息服务类
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
public interface GameService {

    List<Game> queryGames(GameDto dto);

    IPage<Game> pageQueryGames(GameDto dto);

    boolean addGame(GameDto dto);

    boolean updateGame(GameDto dto);

    boolean deleteGame(String id);

    List<com.lumr.sbeam.vo.Game> getBuy();

    List<com.lumr.sbeam.vo.Game> getHot();

    List<com.lumr.sbeam.vo.Game> getNew();

    com.lumr.sbeam.vo.Game getGame(com.lumr.sbeam.vo.Game game);

    List<com.lumr.sbeam.vo.Game> getGames(com.lumr.sbeam.vo.Game game);

    int deleteGame(com.lumr.sbeam.vo.Game game);

    int insert(com.lumr.sbeam.vo.Game pojo);

    int insertSelective( com.lumr.sbeam.vo.Game pojo);

    int insertList(List<com.lumr.sbeam.vo.Game> pojo);

    int update(com.lumr.sbeam.vo.Game pojo);
}
