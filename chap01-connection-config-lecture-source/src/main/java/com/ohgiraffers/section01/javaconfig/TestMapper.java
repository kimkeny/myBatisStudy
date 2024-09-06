package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface TestMapper {

//    @Select("SELECT current_date() from dual")
    @Select("select curdate()")
    java.util.Date selectSysdate();

    @Select("SELECT 1")
    int select1();

    /* 설명. MySQL의 DUAL 테이블:
     *  DUAL은 MySQL 뿐만 아니라, 기타 관계형 데이터베이스 시스템에서도 사용하는 특수 테이블이다.
     *  주로 SELECT문에서 데이터베이스(또는 스키마) 내의 실제 테이블이 아닌 곳에서 데이터를 검색할 때 사용되며,
     *  단일행-단일열로 구성된 '가상 테이블'이다.
     *  ---------------------------------------------------------------------------------------------------
     *  각 RDBMS 별 DUAL 테이블의 정의 및 사용법:
     *  1. Oracle
     *   - DUAL 테이블은 Oracle에서 탄생한 개념으로, Oracle DB 내에서는 DUAL 테이블이 실존한다.
     *   - Oracle의 DUAL 테이블은 단일행-단일열(col: DUMMY)울 가지고 있다.
     *   - 아래와 같이 정의되어 있다.
     *     CREATE TABLE DUAL (
     *       DUMMY VARCHAR2(1)
     *     );
     *     INSERT INTO DUAL (DUMMY) VALUES ('SOME_VALUE');
     *  2. MySQL
     *   - 사용법은 Oracle과 크게 다르지 않다.
     *   - 다만, MySQL에서는 DUAL 테이블이 실존하지는 않고, 가상 테이블로 존재해 물리적으로 저장되지 않는다.
     *   - 따라서 SELECT 구문에서 DUAL을 생략할 수 있다.
     *  3. PostgreSQL
     *   - MySQL과 동일하게 DUAL 테이블이 가상으로 존재해 DUAL 테이블을 사용하지 않고 동일한 결과를 얻을 수 있다.
     * */
}
