package com.lumr.sbeam.config;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.lumr.sbeam.filter.UserAuthenticationFilter;
import com.lumr.sbeam.interceptor.MybatisInterceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
@Configuration
@MapperScan(basePackages = {"com.lumr.sbeam.dao", "com.lumr.sbeam.mapper"})
public class RootConfig {

    /**
     * 分页拦截器
     */
    @Bean
    public Interceptor pageInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 查询sql拦截器
     */
    @Bean
    public Interceptor logInterceptor(){
        return new MybatisInterceptor();
    }

    @Bean
    public ShiroFilterFactoryBean shirofilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
        shiro.setSecurityManager(securityManager);
        shiro.setLoginUrl("/user/login");
        shiro.setUnauthorizedUrl("/403");
        shiro.setSuccessUrl("/index");
        Map<String,String> chainMap = new LinkedHashMap<>();
        chainMap.put("/public/**","anon");
        chainMap.put("/game/**", "anon");
        chainMap.put("/health", "anon");
        chainMap.put("/user/logout", "logout");
        chainMap.put("/**", "authc");
        shiro.setFilterChainDefinitionMap(chainMap);
        shiro.getFilters().put("authc",new UserAuthenticationFilter());
        return shiro;
    }

    @Bean
    public SecurityManager getSecurityManager(Realm realm){
        return new DefaultWebSecurityManager(realm);
    }

    //    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    //    @Bean
    /*public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
        dataSource.setMaxActive(10);
        dataSource.setInitialSize(1);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.init();
        return dataSource;
    }*/

    //    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.lumr.sbeam.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }

    //    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.lumr.bbs.vo");
        bean.setConfiguration(configuration);
        return bean;
    }

    //    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.getTypeAliasRegistry().registerAliases("com.lumr.sbeam.vo");
        return configuration;
    }


    //    @Bean
    public CommonsMultipartResolver multipartResolver(ServletContext servletContext) {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(servletContext);
        resolver.setMaxUploadSize(5000000L);
        return resolver;
    }

}
