package com.carrent.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sa-Token配置类
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    /**
     * 注册Sa-Token拦截器，校验规则为StpUtil.checkLogin()登录校验
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册管理员登录拦截器
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/admin/**")    // 拦截所有B端接口
                .excludePathPatterns(
                        "/admin/auth/**"         // 排除管理员登录接口
                );
    }
}
