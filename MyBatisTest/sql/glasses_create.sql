drop user 'kim'@'%';
-- 계정 생성 후 데이터베이스 활용

-- 1) 새로운 ohgiraffers 계정 만들기
CREATE USER 'kim'@'%' IDENTIFIED BY  'kim'; -- 'localhost' 대신 '%'를 쓰면 외부 ip로 접속 가능하다.

-- 현재 존재하는 데이터베이스 확인
SHOW databases;

-- mysql 데이터베이스로 계정 정보 확인하기
USE mysql;	-- 기본 적으로 제공되는 mysql database

SELECT * FROM user;	-- mysql database에서 user를 확인해 계정이 추가된 것을 확인한다.

-- 2) 데이터베이스 생성 후 계정에 권한 부여
-- 데이터베이스(스키마) 생성
CREATE DATABASE glassesdb;
-- CREATE SCHEMA menudb;

-- 왼쪽 Navigator를 새로고침해서 menudb database(schema)가 추가된 것을 확인한다.
-- MySQL은 개념적으로 database와 schema를 구분하지 않는다.
-- (CREATE DATABASE와 CREATE SCHEMA가 같은 개념이다.)

GRANT ALL PRIVILEGES ON glassesdb.* TO 'kim'@'%';	-- menu에 대한 모든 권한 부여

SHOW GRANTS FOR 'kim'@'%';

-- 3) 새로운 접속기 생성 후 접속하고 데이터베이스 활용하기
-- 좌측 상단의 home 버튼을 눌러 ohgiraffers 계정 접속기를 만들어 접속하고 database(schema)를 사용한다.
-- 접속기의 Connection Name은 'ohgiraffers'로 지정
-- Parameters의 Username은 'ohgiraffers'로 지정(계정명)
-- Default Schema(기본 데이터베이스(스키마) 설정)는 'menudb'로 지정
USE glassesdb;