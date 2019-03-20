package com.lumr.sbeam.dao;

import com.lumr.sbeam.vo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    Category getCategory(Category category);

    List<Category> getAllCategories();

    int deleteCategory(Category category);

    int insert(@Param("pojo") Category pojo);

    int insertSelective(@Param("pojo") Category pojo);

    int insertList(@Param("pojos") List<Category> pojo);

    int update(@Param("pojo") Category pojo);
}
