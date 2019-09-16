package com.lumr.sbeam.service.impl;

import com.lumr.sbeam.dao.HeaderDao;
import com.lumr.sbeam.dao.UserDao;
import com.lumr.sbeam.service.UserService;
import com.lumr.sbeam.vo.Header;
import com.lumr.sbeam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务类
 *
 * @author lumr
 * @since 2019/9/16 下午10:52
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HeaderDao headerDao;


    @Override
    public UserVO checkUserName(UserVO user) {
        return userDao.checkUserName(user);
    }

    @Override
    public UserVO getUser(UserVO user) {
        return userDao.getUser(user);
    }

    @Override
    public int insertUser(UserVO user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(UserVO user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(UserVO user) {
        return userDao.deleteUser(user);
    }

    @Override
    public int recharge(UserVO user, double rmb) {
        return userDao.recharge(user, rmb);
    }

    @Override
    public int pay(UserVO user, double rmb) {
        return userDao.pay(user, rmb);
    }

    @Override
    public int insert(Header pojo) {
        return headerDao.insert(pojo);
    }

    @Override
    public int insertSelective(Header pojo) {
        return headerDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Header> pojo) {
        return headerDao.insertList(pojo);
    }

    @Override
    public int update(Header pojo) {
        return headerDao.update(pojo);
    }
}
