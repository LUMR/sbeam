package com.lumr.sbeam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Category;

@Mapper
public interface CategoryDao {
    int insert(@Param("pojo") Category pojo);

    int insertSelective(@Param("pojo") Category pojo);

    int insertList(@Param("pojos") List<Category> pojo);

    int update(@Param("pojo") Category pojo);
}
