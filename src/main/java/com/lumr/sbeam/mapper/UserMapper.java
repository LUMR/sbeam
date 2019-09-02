package com.lumr.sbeam.mapper;

import com.lumr.sbeam.entity.User;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-02
 **/
public interface UserMapper extends EntityMapper<User> {

    User getUserAuthorizationInfo(String name);
}
