package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户dao接口
 * Created by fsweb on 17-5-8.
 */
@Repository
@Mapper
public interface UserDao {
    User checkUserName(User user);

    User getUser(User user);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

    int recharge(@Param("user") User user,@Param("money") double rmb);

    int pay(@Param("user") User user, @Param("money") double rmb);

}
