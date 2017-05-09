package com.lumr.sbeam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Library;

@Mapper
public interface LibraryDao {
    int insert(@Param("pojo") Library pojo);

    int insertSelective(@Param("pojo") Library pojo);

    int insertList(@Param("pojos") List<Library> pojo);

    int update(@Param("pojo") Library pojo);
}
