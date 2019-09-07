package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.UserVO;
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
    UserVO checkUserName(UserVO user);

    UserVO getUser(UserVO user);

    int insertUser(UserVO user);

    int updateUser(UserVO user);

    int deleteUser(UserVO user);

    int recharge(@Param("user") UserVO user, @Param("money") double rmb);

    int pay(@Param("user") UserVO user, @Param("money") double rmb);

}
