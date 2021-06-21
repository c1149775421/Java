package com.atguigu.ApplicationMain.Controller.book.FilterFiles;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public FilterRegistrationBean registrationBean () {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterTest());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("testFilter");
        return registrationBean;
    }
}
