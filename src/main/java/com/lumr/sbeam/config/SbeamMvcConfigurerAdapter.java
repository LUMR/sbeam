package com.lumr.sbeam.config;

import com.lumr.sbeam.interceptor.AuthInterceptor;
import com.lumr.sbeam.interceptor.CROSInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
                .addPathPatterns("/admin/**", "/user/**").excludePathPatterns("/user/login", "/user/register", "/user/checkName");
        registry.addInterceptor(new CROSInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/game/**").allowedOrigins("*").allowedMethods("*");
        registry.addMapping("/**").allowedOrigins("*");
    }


}
