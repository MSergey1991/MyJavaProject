package com.sheduler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver getViewResolver () {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setOrder(1);
        bean.setSuffix(".jsp");
        bean.setPrefix("/WEB-INF/views/");
        return bean;
    }
}
