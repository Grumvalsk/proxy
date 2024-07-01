package com.example.demo.config;

import com.example.demo.security.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<SecurityFilter> loggingFilter() {
//        FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new SecurityFilter());
////        registrationBean.addUrlPatterns("/api/v1/user/login"); // Specifica i pattern degli URL per cui applicare il filtro
//
//        return registrationBean;
//    }
}
