package com.lumr.sbeam.service;

import com.lumr.sbeam.vo.Category;

import java.util.List;

/**
 * 游戏种类
 * @author lumr
 * @since 2019/9/16 下午10:31
 */
public interface CategoryService {

    Category getCategory(Category category);

    List<Category> getAllCategories();

    int deleteCategory(Category category);

    int insert(Category pojo);

    int insertSelective(Category pojo);

    int insertList(List<Category> pojo);

    int update(Category pojo);
}
