package com.minhow.springbootapistarter.common.constant;

/**
 * 数据库常量
 * @author MinHow
 * @date 2018/3/8 4:13 下午
 */
public class DBConstants {

    /**
     * 数据源配置
     */
    public static final String FIRST_DATA_SOURCE = "firstDataSource";
    public static final String SECOND_DATA_SOURCE = "secondDataSource";

    /**
     * sqlSessionFactory
     */
    public static final String FIRST_SQL_SESSION_FACTORY = "firstSqlSessionFactory";
    public static final String SECOND_SQL_SESSION_FACTORY = "secondSqlSessionFactory";

    /**
     * mapper接口
     */
    public static final String FIRST_MAPPER = "com.minhow.springbootapistarter.dao.first.mapper";
    public static final String SECOND_MAPPER = "com.minhow.springbootapistarter.dao.second.mapper";
    /**
     * mapper.xml目录
     */
    public static final String FIRST_MAPPER_XML = "classpath:first-mapper/*.xml";
    public static final String SECOND_MAPPER_XML = "classpath:second-mapper/*.xml";
}
