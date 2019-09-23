package com.garfield.teststream.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Jingly
 * @create: 2019-07-26 15:35
 **/
@Component
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private StringHandler stringHandler;

  @Bean
  public FilterRegistrationBean registrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new StringFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration interceptorRegistration = registry.addInterceptor(stringHandler);
    interceptorRegistration.addPathPatterns("/*");
  }
}
