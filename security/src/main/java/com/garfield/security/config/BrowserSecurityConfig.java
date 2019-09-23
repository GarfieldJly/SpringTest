package com.garfield.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author: Jingly
 * @create: 2019-06-25 15:46
 **/
@Component
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //http.httpBasic()// http Basic 方式
    http.formLogin() // 表单登录
        // http.httpBasic() // HTTP Basic
        .loginPage("/login.html")
        .loginProcessingUrl("/login")
        .and()
        .authorizeRequests() // 授权配置
        .antMatchers("/login.html").permitAll()
        .antMatchers("/login.html","/css/**").permitAll()
        .anyRequest()  // 所有请求
        .authenticated()  // 都需要认证
        .and().csrf().disable();// CSRF攻击防御关了


  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
