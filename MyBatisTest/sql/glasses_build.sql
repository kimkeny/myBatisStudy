-- SET FOREIGN_KEY_CHECKS = 0;

-- 1. 기존 테이블 삭제
DROP TABLE IF EXISTS tbl_order_glasses CASCADE;
DROP TABLE IF EXISTS tbl_order CASCADE;
DROP TABLE IF EXISTS tbl_lens CASCADE;
DROP TABLE IF EXISTS tbl_glasses CASCADE;
DROP TABLE IF EXISTS tbl_category CASCADE;

-- SET FOREIGN_KEY_CHECKS = 1;

-- 2. 테이블 생성
CREATE TABLE IF NOT EXISTS tbl_category (
    category_code INT AUTO_INCREMENT COMMENT '카테고리코드',
    category_name VARCHAR(30) NOT NULL COMMENT '카테고리명',
    PRIMARY KEY (category_code)
) ENGINE=INNODB COMMENT '카테고리';

CREATE TABLE IF NOT EXISTS tbl_glasses (
    glasses_code INT AUTO_INCREMENT COMMENT '안경코드',
    glasses_name VARCHAR(30) NOT NULL COMMENT '안경이름',
    glasses_price INT NOT NULL COMMENT '안경가격',
    category_code INT NOT NULL COMMENT '카테고리코드',
    PRIMARY KEY (glasses_code),
    FOREIGN KEY (category_code) REFERENCES tbl_category (category_code)
) ENGINE=INNODB COMMENT '안경';

CREATE TABLE IF NOT EXISTS tbl_lens (
    lens_code INT AUTO_INCREMENT COMMENT '렌즈코드',
    lens_name VARCHAR(30) NOT NULL COMMENT '렌즈이름',
    lens_price INT NOT NULL COMMENT '렌즈가격',
    category_code INT NOT NULL COMMENT '카테고리코드',
    PRIMARY KEY (lens_code),
    FOREIGN KEY (category_code) REFERENCES tbl_category (category_code)
) ENGINE=INNODB COMMENT '렌즈';

CREATE TABLE IF NOT EXISTS tbl_order (
    order_code INT AUTO_INCREMENT COMMENT '주문코드',
    order_date VARCHAR(10) NOT NULL COMMENT '주문일자',
    order_time VARCHAR(10) NOT NULL COMMENT '주문시간',
    total_order_price INT NOT NULL COMMENT '총주문금액',
    PRIMARY KEY (order_code)
) ENGINE=INNODB COMMENT '주문';

CREATE TABLE IF NOT EXISTS tbl_order_glasses (
    order_code INT NOT NULL COMMENT '주문코드',
    glasses_code INT NOT NULL COMMENT '안경코드',
    lens_code INT NOT NULL COMMENT '렌즈코드',
    order_amount INT NOT NULL COMMENT '주문수량',
    PRIMARY KEY (order_code, glasses_code, lens_code),
    FOREIGN KEY (order_code) REFERENCES tbl_order (order_code),
    FOREIGN KEY (glasses_code) REFERENCES tbl_glasses (glasses_code),
    FOREIGN KEY (lens_code) REFERENCES tbl_lens (lens_code)
) ENGINE=INNODB COMMENT '주문별안경';

-- 3. 데이터 삽입
INSERT INTO tbl_category VALUES (null, '메탈테');
INSERT INTO tbl_category VALUES (null, '뿔테');
INSERT INTO tbl_category VALUES (null, '반무테');
INSERT INTO tbl_category VALUES (null, '고글');
INSERT INTO tbl_category VALUES (null, '선글라스');
INSERT INTO tbl_category VALUES (null, '일반렌즈');
INSERT INTO tbl_category VALUES (null, '주문렌즈');

INSERT INTO tbl_glasses VALUES (null, '린드버그', 600000, 1);
INSERT INTO tbl_glasses VALUES (null, '마르쿠스마리엔펠트', 1500000, 1);
INSERT INTO tbl_glasses VALUES (null, '애쉬크로프트', 160000, 2);
INSERT INTO tbl_glasses VALUES (null, '젠틀몬스터', 350000, 2);
INSERT INTO tbl_glasses VALUES (null, '까르띠에', 900000, 3);
INSERT INTO tbl_glasses VALUES (null, '페라가모', 190000, 3);
INSERT INTO tbl_glasses VALUES (null, '오클리', 200000, 4);
INSERT INTO tbl_glasses VALUES (null, '루디프로젝트', 300000, 4);
INSERT INTO tbl_glasses VALUES (null, '레이벤', 150000, 5);
INSERT INTO tbl_glasses VALUES (null, '톰포드', 450000, 5);

INSERT INTO tbl_lens VALUES (null, '싸구려렌즈', 10000, 6);
INSERT INTO tbl_lens VALUES (null, '자외선차단렌즈', 30000, 6);
INSERT INTO tbl_lens VALUES (null, '블루라이트차단렌즈', 50000, 6);
INSERT INTO tbl_lens VALUES (null, '착색렌즈', 80000, 7);
INSERT INTO tbl_lens VALUES (null, '편광렌즈', 100000, 7);
INSERT INTO tbl_lens VALUES (null, '누진다초점렌즈', 300000, 7);




COMMIT;
