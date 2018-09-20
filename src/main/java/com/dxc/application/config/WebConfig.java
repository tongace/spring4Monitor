package com.dxc.application.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
        registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/resources/font/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/resources/scripts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
        registry.addResourceHandler("/templates/**").addResourceLocations("/WEB-INF/resources/templates/");
        registry.addResourceHandler("/pages/**").addResourceLocations("/WEB-INF/resources/pages/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localResolver = new CookieLocaleResolver();
        localResolver.setDefaultLocale(new Locale("en_US"));
        return localResolver;
    }
}
