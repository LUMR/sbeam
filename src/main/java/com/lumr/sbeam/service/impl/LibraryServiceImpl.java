package com.lumr.sbeam.service.impl;

import com.lumr.sbeam.dao.LibraryDao;
import com.lumr.sbeam.service.LibraryService;
import com.lumr.sbeam.vo.Game;
import com.lumr.sbeam.vo.Library;
import com.lumr.sbeam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lumr
 * @since 2019/9/16 下午10:48
 */
@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Override
    public int getSales(Game game) {
        return libraryDao.getSales(game);
    }

    @Override
    public Library check(UserVO user, Game game) {
        return libraryDao.check(user,game);
    }

    @Override
    public int add(UserVO user, Game game) {
        return libraryDao.add(user, game);
    }

    @Override
    public int delete(UserVO user, Game game) {
        return libraryDao.delete(user, game);
    }

    @Override
    public int insert(Library pojo) {
        return libraryDao.insert(pojo);
    }

    @Override
    public int insertSelective(Library pojo) {
        return libraryDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Library> pojo) {
        return libraryDao.insertList(pojo);
    }

    @Override
    public int update(Library pojo) {
        return libraryDao.update(pojo);
    }
}
