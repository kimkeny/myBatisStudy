package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";


    public static void main(String[] args) {

        /*목차. 0. 환경 설정*/
        /* 목차. 0-1. DB 접속을 위한 환경 설정 진행.
         *  Environment : DB 접속에 관한 환경 설정 정보를 가진 객체.
         *  -------------------------------------------------------
         *  JdbcTransactionFactory : 수동 커밋
         *  ManagedTransactionFactory : 자동 커밋
         *  -------------------------------------------------------
         *  PooledDataSource : ConnectionPool 사용
         *  UnpooledDataSource : ConnectionPool 미사용
         *  -------------------------------------------------------
         * */
        Environment env = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER,URL,USER,PASSWORD)
        );

        /* 목차. 0-2. 생성한 환경 설정 정보로 MyBatis 설정 객체 생성*/
        Configuration config = new Configuration(env);

        /* 목차. 0-3. 설정 객체에 매퍼를 등록*/
        config.addMapper(TestMapper.class);

        /*목차. 1. SQL Session 생성*/
        /*목차. 1-1 SqlSessionfactory 객체 생성
         * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         * SqlSessionFactoryBuilder :  SqlSessionFactory 인터페이스 타입의 하위 구현체를 생성하기 위한 빌드 역할
         * SqlSessionFactoryBuilder.build(Configuration) : 전달인자로 전달 받은 Configuration 객체,
         * 혹은 외부설정 파일과 연결된 Stream을 전달 인자로 전달하면 SqlSessionFactory 인터페이스 타입의
         * 객체를 반환하는 메소드
         *  */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

        /*목차 1-2. Sqlsession 객체 생성
        *  openSession() : Sqlsession 인터페이스 타입의 객체를 반환하는 메소드로, boolean 타입을 인자로 전달함.
        *  - false : Connection 인터페이스 타입 객첼 DML 수행 후, auto_Commit에 대한 옵션을 false로 지정(권장)
        *  - true : Connection 인터페이스 타입 객첼 DML 수행 후, auto_Commit에 대한 옵션을 true로 지정
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /*목차. 2. Mapper에 정의된 쿼리 실행*/
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        java.util.Date currentDate = mapper.selectSysdate();
        System.out.println("currentDate = " + currentDate);

        int num = mapper.select1();
        System.out.println("num = " + num);

        boolean isConnected = mapper.select1() != 1 ? false : true;
        System.out.println("isConnected = " + isConnected);

        /*목차. 3. SQL Session 반환*/
        sqlSession.close();
    }
}
