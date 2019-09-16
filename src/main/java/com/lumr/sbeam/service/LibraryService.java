package com.lumr.sbeam.service;

import com.lumr.sbeam.vo.Game;
import com.lumr.sbeam.vo.Library;
import com.lumr.sbeam.vo.UserVO;

import java.util.List;

/**
 * 用户库存
 * @author lumr
 * @since 2019/9/16 下午10:46
 */
public interface LibraryService {

    int getSales(Game game);

    Library check(UserVO user, Game game);

    int add(UserVO user, Game game);

    int delete(UserVO user, Game game);

    int insert(Library pojo);

    int insertSelective(Library pojo);

    int insertList(List<Library> pojo);

    int update(Library pojo);
}
