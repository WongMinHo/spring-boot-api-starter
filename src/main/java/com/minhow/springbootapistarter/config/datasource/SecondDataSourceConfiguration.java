package com.minhow.springbootapistarter.config.datasource;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.minhow.springbootapistarter.common.constant.DBConstants;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author MinHow
 * @date 2018/3/4  7:20 下午
 */
@Configuration
@MapperScan(basePackages = DBConstants.SECOND_MAPPER, sqlSessionFactoryRef = DBConstants.SECOND_SQL_SESSION_FACTORY)
public class SecondDataSourceConfiguration {
    @Autowired
    private SecondDataSourceProperties secondDataSourceProperties;

    /**
     * 配置第二个数据源
     * @return
     */
    @Bean(DBConstants.SECOND_DATA_SOURCE)
    public DataSource secondDataSource() {
//        使用Druid的分布式驱动，暂时发现不支持mysql8以上的版本
//        DruidXADataSource druidXADataSource = new DruidXADataSource();
//        BeanUtils.copyProperties(secondDataSourceProperties, druidXADataSource);

        //使用mysql的分布式驱动，支持mysql5.*、mysql8.* 以上版本
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(secondDataSourceProperties.getUrl());
        mysqlXaDataSource.setPassword(secondDataSourceProperties.getPassword());
        mysqlXaDataSource.setUser(secondDataSourceProperties.getUsername());

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(DBConstants.SECOND_DATA_SOURCE);
        xaDataSource.setPoolSize(secondDataSourceProperties.getInitialSize());
        xaDataSource.setMinPoolSize(secondDataSourceProperties.getMinIdle());
        xaDataSource.setMaxPoolSize(secondDataSourceProperties.getMaxActive());
        xaDataSource.setMaxIdleTime(secondDataSourceProperties.getMinIdle());
        xaDataSource.setMaxLifetime(secondDataSourceProperties.getMinEvictableIdleTimeMillis());
        xaDataSource.setConcurrentConnectionValidation(secondDataSourceProperties.getTestWhileIdle());
        xaDataSource.setTestQuery(secondDataSourceProperties.getValidationQuery());

        return xaDataSource;
    }

    /**
     * 创建第二个SqlSessionFactory
     * @param secondDataSource
     * @return
     * @throws Exception
     */
    @Bean(DBConstants.SECOND_SQL_SESSION_FACTORY)
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier(DBConstants.SECOND_DATA_SOURCE) DataSource secondDataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(secondDataSource);
        //设置mapper位置
        bean.setTypeAliasesPackage(DBConstants.SECOND_MAPPER);
        //设置mapper.xml文件的路径
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(DBConstants.SECOND_MAPPER_XML));

        return bean.getObject();
    }
}
