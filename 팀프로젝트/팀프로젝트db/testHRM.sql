SELECT * FROM employee_info;
SELECT * FROM job_position;
SELECT * FROM department;
SELECT * FROM attendance_log;
SELECT * FROM leave_request;
SELECT * FROM leave_remain;
SELECT * FROM performance_review;
SELECT * FROM salary_history;

-- 사원 기본 정보 조회
SELECT emp_name, phone, email,hire_date, dept_name, job_title ,TRUNCATE(datediff(current_date, hire_date)/365,0) as '근속년수'
FROM employee_info
JOIN department USING(dept_no)
JOIN job_position USING(job_no)
WHERE emp_no = 1;

SELECT emp_name, dept_name, job_title 
FROM employee_info
JOIN department USING(dept_no)
JOIN job_position USING(job_no)
WHERE dept_name = '인사팀'
AND job_title = '대표이사';
SELECT emp_name, hire_date, TRUNCATE(datediff(current_date, hire_date)/365,0) as '근속년수'
FROM employee_info;

-- 사원 정보 수정
UPDATE employee_info 
SET 
email = 'jd@naver.com',
phone = '010-9476-1507'
WHERE emp_no =1;

-- 부서별 직급별 사원 목록 필터 기능
SELECT emp_name, phone, email,hire_date, dept_name, job_title 
FROM employee_info
JOIN department USING(dept_no)
JOIN job_position USING(job_no)
WHERE dept_name = '마케팅팀' and job_title = '사원';

-- 휴가자 목록 조회
SELECT * FROM leave_request
WHERE start_date <= '2025-08-01'
and end_date >= '2025-08-01'
and status = '승인';

-- 사원별 급여, 수당, 공제 포함 내역 조회

SELECT emp_name, job_title, dept_name, salary ,bonus_name, payment, pay_date, bonus_desc 
FROM bonus
JOIN bonus_payment USING(bonus_no)
JOIN employee_info USING(emp_no)
JOIN department USING(dept_no)
JOIN job_position USING(job_no)
WHERE emp_no = 1;

-- 퇴사자 조회 테이블
SELECT emp_name, quit_date ,quit_pay, quit_pay_date FROM quitter
JOIN employee_info USING(emp_no);