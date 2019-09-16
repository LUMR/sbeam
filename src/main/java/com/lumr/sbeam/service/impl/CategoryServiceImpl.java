package com.lumr.sbeam.service.impl;

import com.lumr.sbeam.dao.CategoryDao;
import com.lumr.sbeam.service.CategoryService;
import com.lumr.sbeam.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lumr
 * @since 2019/9/16 下午10:32
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category getCategory(Category category) {
        return categoryDao.getCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public int deleteCategory(Category category) {
        return categoryDao.deleteCategory(category);
    }

    @Override
    public int insert(Category pojo) {
        return categoryDao.insert(pojo);
    }

    @Override
    public int insertSelective(Category pojo) {
        return categoryDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Category> pojo) {
        return categoryDao.insertList(pojo);
    }

    @Override
    public int update(Category pojo) {
        return categoryDao.update(pojo);
    }
}
