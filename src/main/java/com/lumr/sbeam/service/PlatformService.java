package com.lumr.sbeam.service;

import com.lumr.sbeam.vo.Platform;

import java.util.List;

/**
 * 游戏平台种类
 * @author lumr
 * @since 2019/9/16 下午10:31
 */
public interface PlatformService {

    Platform getPlatform(Platform platform);

    List<Platform> getAllPlatforms();

    int deletePlatform(Platform platform);

    int insert(Platform pojo);

    int insertSelective(Platform pojo);

    int insertList(List<Platform> pojo);

    int update(Platform pojo);
}
