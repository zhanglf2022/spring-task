package com.lingoace.task.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author zhanglifeng
 * @date 2020-04-14
 */
@Configuration
public class SqlSessionFactoryConfig implements TransactionManagementConfigurer {
    private final static Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryConfig.class);
    @Resource
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            org.springframework.core.io.Resource[] resources = resolver.getResources("classpath*:mapper/**/*.xml");
            bean.setMapperLocations(resources);
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        } catch (Exception e) {
            LOGGER.warn("classpath*:mapper/**/*.xml not existence");
        }
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}