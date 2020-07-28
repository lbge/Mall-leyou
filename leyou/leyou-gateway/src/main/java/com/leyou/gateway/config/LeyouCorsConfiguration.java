package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域访问设置
 *
 * @author Linbo Ge
 * @date 2020/7/21 22:11
 */
@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {

        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写*。*：代表所有域名都可以跨域访问
        configuration.addAllowedOrigin("http://manage.leyou.com");
        configuration.addAllowedOrigin("http://www.leyou.com");
        //是否允许携带cookie
        configuration.setAllowCredentials(true);
        //代表所有请求方法都支持
        configuration.addAllowedMethod("*");
        //允许携带任何头信息
        configuration.addAllowedHeader("*");

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        //返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(configurationSource);
    }
}
