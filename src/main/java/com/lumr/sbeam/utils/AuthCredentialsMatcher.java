package com.lumr.sbeam.utils;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-03
 **/
public class AuthCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String password = info.getCredentials().toString();
        char[] pw = (char[]) token.getCredentials();

        return password.equals(Utils.sha1(String.valueOf(pw)));
    }
}
