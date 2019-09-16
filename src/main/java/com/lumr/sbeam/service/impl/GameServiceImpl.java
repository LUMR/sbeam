package com.lumr.sbeam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lumr.sbeam.dao.GameDao;
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

    @Autowired
    private GameDao gameDao;

    @Override
    public List<Game> queryGames(GameDto dto) {
        QueryWrapper<Game> wrapper = new QueryWrapper<>(dto);
        return gameMapper.selectList(wrapper);
    }

    @Override
    public IPage<Game> pageQueryGames(GameDto dto) {
        QueryWrapper<Game> wrapper = new QueryWrapper<>(dto);
        IPage<Game> result = new Page<Game>(dto.getCurrent(), dto.getSize()).setAsc("id");
        gameMapper.selectPage(result, wrapper);
        return result;
    }

    @Override
    public boolean addGame(GameDto dto) {
        Game game = new Game();
        BeanUtils.copyProperties(dto, game);
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

    @Override
    public List<com.lumr.sbeam.vo.Game> getBuy() {
        return gameDao.getBuy();
    }

    @Override
    public List<com.lumr.sbeam.vo.Game> getHot() {
        return gameDao.getHot();
    }

    @Override
    public List<com.lumr.sbeam.vo.Game> getNew() {
        return gameDao.getNew();
    }

    @Override
    public com.lumr.sbeam.vo.Game getGame(com.lumr.sbeam.vo.Game game) {
        return gameDao.getGame(game);
    }

    @Override
    public List<com.lumr.sbeam.vo.Game> getGames(com.lumr.sbeam.vo.Game game) {
        return gameDao.getGames(game);
    }

    @Override
    public int deleteGame(com.lumr.sbeam.vo.Game game) {
        return gameDao.deleteGame(game);
    }

    @Override
    public int insert(com.lumr.sbeam.vo.Game pojo) {
        return gameDao.insert(pojo);
    }

    @Override
    public int insertSelective(com.lumr.sbeam.vo.Game pojo) {
        return gameDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<com.lumr.sbeam.vo.Game> pojo) {
        return gameDao.insertList(pojo);
    }

    @Override
    public int update(com.lumr.sbeam.vo.Game pojo) {
        return gameDao.update(pojo);
    }
}
