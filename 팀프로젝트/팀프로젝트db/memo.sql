-- 수당 관련 테이블 퇴사자 관리 테이블 인사이동 테이블 부서별 지급비 테이블(조인으로 가능할듯) 직급별 급여 기준 정리

-- 수당 종류 테이블
CREATE TABLE bonus (
bonus_no INT PRIMARY KEY,
bonus_name VARCHAR(50), -- 수당 이름
bonus_desc TEXT -- 수당 설명
);  
-- 수당 제공 되는 직원 정보 테이블
CREATE TABLE bonus_payment(
bonus_no INT AUTO_INCREMENT PRIMARY KEY,
payment INT NOT NULL, -- 수당 지급 금액
pay_date DATE NOT NULL, -- 수당 지급 날짜
al_no INT NOT NULL, -- 외래키 (수당 종류)
emp_no INT NOT NULL -- 외래키 (직원)
);

-- 퇴사자 관리 테이블 (애매함)
-- CREATE TABLE quitter(

-- );

