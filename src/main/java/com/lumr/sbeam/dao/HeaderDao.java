package com.lumr.sbeam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lumr.sbeam.vo.Header;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HeaderDao {
    int insert(@Param("pojo") Header pojo);

    int insertSelective(@Param("pojo") Header pojo);

    int insertList(@Param("pojos") List<Header> pojo);

    int update(@Param("pojo") Header pojo);
}
