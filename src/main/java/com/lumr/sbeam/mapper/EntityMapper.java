package com.lumr.sbeam.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-03
 **/
public interface EntityMapper<T> extends BaseMapper<T> {

    default T selectOne(String column,Object value){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(column,value);
        return this.selectOne(wrapper);
    }
}
