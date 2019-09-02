package com.lumr.sbeam.config;

import com.lumr.sbeam.entity.Role;
import com.lumr.sbeam.entity.User;
import com.lumr.sbeam.mapper.UserMapper;
import com.lumr.sbeam.utils.AuthCredentialsMatcher;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-02
 **/
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    public AccountRealm() {
        super(null,new AuthCredentialsMatcher());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userf = userMapper.getUserAuthorizationInfo(user.getName());
        if (userf == null) {
            return null;
        }

        authorizationInfo.setRoles(userf.getRoles().stream().map(Role::getRole).collect(Collectors.toSet()));

        return authorizationInfo;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String userName = passwordToken.getUsername();
        User user = userMapper.selectOne("name", userName);
        if (user == null)
            return null;
        return new SimpleAccount(user, user.getPassword(), "accountRealm");
    }


}
