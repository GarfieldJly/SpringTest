package com.garfield.wechatorder.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jingly on 2018/8/20.
 */
@Configuration
public class MyBatisConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dataSourceUrl);
        // mysql 由 5.1.39 改为 6.0.6
        config.setDriverClassName(driverClassName);
        config.setUsername(userName);
        config.setPassword(password);
        //连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
        config.setMaximumPoolSize(10);
        //等待连接池分配连接的最大时长（毫秒）
        config.setConnectionTimeout(600000);
        //一个连接idle状态的最大时长（毫秒）
        config.setIdleTimeout(600000);
        //一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，
        // 参考MySQL wait_timeout参数（show variables like '%timeout%';）
        config.setMaxLifetime(28770000);

        //server_hikari.setPoolName("uriel_server_hikari");

        return new HikariDataSource(config);
    }

}