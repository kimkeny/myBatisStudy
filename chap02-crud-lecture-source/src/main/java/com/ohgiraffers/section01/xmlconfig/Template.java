package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        /* 설명. sqlSessionFactory가 아직 인스턴스화 되지 않았다면 */
        if(sqlSessionFactory == null) {

            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return sqlSessionFactory.openSession(false);
    }
}
