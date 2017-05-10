package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.Game;
import com.lumr.sbeam.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Library;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LibraryDao {
    Library check(@Param("user") User user,@Param("game") Game game);

    int add(@Param("user") User user,@Param("game") Game game);

    int delete(@Param("user") User user,@Param("game") Game game);

    int insert(@Param("pojo") Library pojo);

    int insertSelective(@Param("pojo") Library pojo);

    int insertList(@Param("pojos") List<Library> pojo);

    int update(@Param("pojo") Library pojo);
}
