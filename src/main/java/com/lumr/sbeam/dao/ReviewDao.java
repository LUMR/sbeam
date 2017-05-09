package com.lumr.sbeam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Review;

@Mapper
public interface ReviewDao {
    int insert(@Param("pojo") Review pojo);

    int insertSelective(@Param("pojo") Review pojo);

    int insertList(@Param("pojos") List<Review> pojo);

    int update(@Param("pojo") Review pojo);
}
