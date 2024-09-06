package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(false);
            java.util.Date currentDate = session.selectOne("TestMapper.selectSysdate");
            System.out.println("currentDate = " + currentDate);

            Integer integerResult = session.selectOne("TestMapper.select1");
            System.out.println("integerResult = " + integerResult);

            int intResult = session.selectOne("TestMapper.select1");
            System.out.println("intResult = " + intResult);

            boolean isConnected = (int)session.selectOne("TestMapper.select1") != 1 ? false : true ;
            System.out.println("isConnected = " + isConnected);

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
