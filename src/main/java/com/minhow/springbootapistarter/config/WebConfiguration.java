package com.minhow.springbootapistarter.config;

import com.minhow.springbootapistarter.common.interceptor.CORSInterceptor;
import com.minhow.springbootapistarter.common.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web相关配置类
 * @author MinHow
 * @date 2019/10/6 10:42 上午
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
    /**
     * 重写添加拦截器方法并添加配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域
        registry.addInterceptor(new CORSInterceptor()).addPathPatterns("/**");
        //token拦截配置
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/users/login")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/webjars/**");
    }
}
