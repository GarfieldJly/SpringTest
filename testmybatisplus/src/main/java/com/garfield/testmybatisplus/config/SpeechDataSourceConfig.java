//package com.garfield.testmybatisplus.config;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import javax.sql.DataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.JdbcType;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
////@Configuration
////@MapperScan(basePackages = SpeechDataSourceConfig.SPEECH_BASEPACKAGE, sqlSessionFactoryRef = "speechSqlSessionFactory")
//public class SpeechDataSourceConfig {
//
//  static final String SPEECH_BASEPACKAGE = "com.garfield.testmybatisplus.mapper;";
//
//  static final String SPEECH_MAPPER_LOCATION = "classpath:mapper/*.xml";
//
//
//  @Bean(name = "speechDataSource")
//  @ConfigurationProperties("spring.datasource.druid.crm")
//  public DataSource speechDataSource() {
//    return DruidDataSourceBuilder.create().build();
//  }
//
//  @Bean(name = "speechTransactionManager")
//  public DataSourceTransactionManager speechTransactionManager() {
//    return new DataSourceTransactionManager(speechDataSource());
//  }
//
//  @Primary
//  @Bean(name = "speechSqlSessionFactory")
//  public SqlSessionFactory crmSqlSessionFactory(
//      @Qualifier("speechDataSource") DataSource speechDataSource)
//      throws Exception {
//    MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//    sqlSessionFactory.setDataSource(speechDataSource);
//    // 设置查找器
//    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//    sqlSessionFactory
//        .setMapperLocations(resolver.getResources(SpeechDataSourceConfig.SPEECH_MAPPER_LOCATION));
//    sqlSessionFactory.setTypeAliasesPackage("crm.zhexinit.aicc.speech.domain.entity");
//
//    MybatisConfiguration configuration = new MybatisConfiguration();
//    configuration.setJdbcTypeForNull(JdbcType.NULL);
//    configuration.setMapUnderscoreToCamelCase(false);
//    configuration.setCacheEnabled(false);
//    sqlSessionFactory.setConfiguration(configuration);
////    sqlSessionFactory.setPlugins(new Interceptor[]{speechPrepareInterceptor});
////    sqlSessionFactory.setGlobalConfig(globalConfiguration());
//
//    return sqlSessionFactory.getObject();
//  }
//
//
////  @Bean
////  public GlobalConfiguration globalConfiguration() {
////    GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
////    conf.setLogicDeleteValue("-1");
////    conf.setLogicNotDeleteValue("1");
////    conf.setIdType(0);
////    conf.setRefresh(true);
////    return conf;
////  }
//
//}
//
