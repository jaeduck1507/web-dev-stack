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

-- 퇴사자 관리 테이블 (애매함) -- 퇴직금 지불 여부 및 지급 금액 표시
CREATE TABLE quitter(
quit_no INT PRIMARY KEY,
quit_name VARCHAR(20), -- 퇴사자 이름
quit_in VARCHAR(20), -- 퇴사자 주민번호
hire_date DATE, -- 퇴사자 입사일
quit_date DATE, -- 퇴사자 퇴사일
phone VARCHAR(20), -- 퇴사자 전화번호
email VARCHAR(20), -- 퇴사자 이메일
quit_pay int, -- 퇴사자 퇴직금
quit_pay_date int, -- 퇴사자 
emp_no INT
);

