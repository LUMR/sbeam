package com.lumr.sbeam.service;

import com.lumr.sbeam.vo.Header;
import com.lumr.sbeam.vo.UserVO;

import java.util.List;

/**
 * @author lumr
 * @since 2019/9/16 下午10:51
 */
public interface UserService {

    UserVO checkUserName(UserVO user);

    UserVO getUser(UserVO user);

    int insertUser(UserVO user);

    int updateUser(UserVO user);

    int deleteUser(UserVO user);

    int recharge(UserVO user, double rmb);

    int pay(UserVO user, double rmb);

    int insert(Header pojo);

    int insertSelective(Header pojo);

    int insertList(List<Header> pojo);

    int update(Header pojo);
}
