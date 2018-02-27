package com.lumr.sbeam.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SbeamMvcConfigurerAdapter.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
