package com.lumr.sbeam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Picture;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PictureDao {
    int insert(@Param("pojo") Picture pojo);

    int insertSelective(@Param("pojo") Picture pojo);

    int insertList(@Param("pojos") List<Picture> pojo);

    int update(@Param("pojo") Picture pojo);
}
