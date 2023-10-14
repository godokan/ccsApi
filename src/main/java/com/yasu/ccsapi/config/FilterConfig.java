package com.yasu.ccsapi.config;

import com.yasu.ccsapi.security.APIKeyAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<APIKeyAuthFilter> apiFilter() {
        FilterRegistrationBean<APIKeyAuthFilter> bean = new FilterRegistrationBean<>(new APIKeyAuthFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(0);
        return bean;
    }
}
