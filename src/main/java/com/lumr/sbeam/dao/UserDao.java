package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.User;
import org.springframework.stereotype.Repository;

/**
 * 用户dao接口
 * Created by fsweb on 17-5-8.
 */
@Repository
public interface UserDao {
    User getUser(User user);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);
}
