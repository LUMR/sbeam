package com.lumr.sbeam.config;

import com.lumr.sbeam.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
@Configuration
public class SbeamMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/admin/**","/user/**").excludePathPatterns("/user/login");
    }

}
