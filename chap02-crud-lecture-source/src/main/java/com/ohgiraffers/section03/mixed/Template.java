package com.ohgiraffers.section03.mixed;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String  DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String  URL = "jdbc:mysql://localhost/menudb";
    private static String  USER = "ohgiraffers";
    private static String  PSSSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {


        if(sqlSessionFactory == null) {

            Environment env = new Environment("dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PSSSWORD));

            Configuration conf = new Configuration(env);

            conf.addMapper(MenuMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(conf);

        }

        return sqlSessionFactory.openSession(false);
    }
}
