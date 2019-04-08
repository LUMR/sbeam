package com.lumr.sbeam.filter;

import com.lumr.sbeam.entity.User;
import com.lumr.sbeam.vo.BuyCar;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-03
 **/
public class UserAuthenticationFilter extends FormAuthenticationFilter {

    private static final String DEFAULT_USERNAME_PARAM = "name";

    @Override
    public String getUsernameParam() {
        return DEFAULT_USERNAME_PARAM;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        User user = (User) subject.getPrincipal();

        com.lumr.sbeam.vo.User user1 = new com.lumr.sbeam.vo.User();
        BeanUtils.copyProperties(user1,user);
        Session session = subject.getSession();
        subject.getSession().setAttribute("user",user1);
        session.setAttribute("buyCar",new BuyCar(user1));

        return super.onLoginSuccess(token, subject, request, response);
    }
}
