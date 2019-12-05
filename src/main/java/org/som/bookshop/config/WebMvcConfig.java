package org.som.bookshop.config;

import org.som.bookshop.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @outhor soulmate
 * @create 2019/11/6-23:04
 * @Description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //配置虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("file:/D:/images/book/");
    }

    //配置自定义拦截器的拦截路径

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/order/**","/cart/**","/address/**");
    }
}
