package com.lumr.sbeam.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-03-21
 * @deprecated 改用了别的方法
 * @see com.lumr.sbeam.config.SbeamMvcConfigurerAdapter
 **/
@Deprecated
public class CROSInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
