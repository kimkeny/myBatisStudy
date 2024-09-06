package com.ohgiraffers.mixed;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String  DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String  URL = "jdbc:mysql://localhost/glassesdb";
    private static String  USER = "kim";
    private static String  PSSSWORD = "kim";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {


        if(sqlSessionFactory == null) {

            Environment env = new Environment("dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PSSSWORD));

            Configuration conf = new Configuration(env);

            conf.addMapper(GlassesMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(conf);

        }

        return sqlSessionFactory.openSession(false);
    }
}
