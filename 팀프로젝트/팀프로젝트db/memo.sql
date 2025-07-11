-- 수당 종류 테이블
CREATE TABLE allowance (
al_no INT PRIMARY KEY,
al_name VARCHAR(50), -- 수당 이름
al_desc TEXT -- 수당 설명
);  
-- 수당 제공 되는 직원 정보 테이블
CREATE TABLE al_payment(
alp_no INT AUTO_INCREMENT PRIMARY KEY,
payment INT NOT NULL, -- 수당 지급 금액
pay_date DATE NOT NULL, -- 수당 지급 날짜
al_no INT NOT NULL, -- 외래키 (수당 종류)
emp_no INT NOT NULL -- 외래키 (직원)
);