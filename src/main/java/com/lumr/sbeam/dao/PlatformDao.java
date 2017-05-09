package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.Platform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlatformDao {
    Platform getPlatform(Platform platform);

    List<Platform> getAllPlatforms();

    int deletePlatform(Platform platform);

    int insert(@Param("pojo") Platform pojo);

    int insertSelective(@Param("pojo") Platform pojo);

    int insertList(@Param("pojos") List<Platform> pojo);

    int update(@Param("pojo") Platform pojo);
}
