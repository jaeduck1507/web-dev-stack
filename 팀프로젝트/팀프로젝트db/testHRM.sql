SELECT * FROM employee_info;
SELECT * FROM job_position;
SELECT * FROM department;
SELECT * FROM attendance_log;
SELECT * FROM leave_request;
SELECT * FROM performance_review;
SELECT * FROM salary_history;

SELECT dept_name,job_title ,emp_name FROM employee_info
JOIN department USING(dept_no)
JOIN job_position USING(job_no);