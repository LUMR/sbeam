package com.lumr.sbeam.service.impl;

import com.lumr.sbeam.dao.PlatformDao;
import com.lumr.sbeam.service.PlatformService;
import com.lumr.sbeam.vo.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lumr
 * @since 2019/9/16 下午10:32
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformDao platformDao;

    @Override
    public Platform getPlatform(Platform platform) {
        return platformDao.getPlatform(platform);
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return platformDao.getAllPlatforms();
    }

    @Override
    public int deletePlatform(Platform platform) {
        return platformDao.deletePlatform(platform);
    }

    @Override
    public int insert(Platform pojo) {
        return platformDao.insert(pojo);
    }

    @Override
    public int insertSelective(Platform pojo) {
        return platformDao.insert(pojo);
    }

    @Override
    public int insertList(List<Platform> pojo) {
        return platformDao.insertList(pojo);
    }

    @Override
    public int update(Platform pojo) {
        return platformDao.update(pojo);
    }
}
