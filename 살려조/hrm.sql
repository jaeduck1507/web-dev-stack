-- department (부서)
CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,   -- 부서id (PK)
    dept_name VARCHAR(30)                      -- 부서 이름
);

-- job (직급)
CREATE TABLE job (
    job_id INT AUTO_INCREMENT PRIMARY KEY,     -- 직급 id (PK)
    job_name VARCHAR(30)                       -- 직급 이름
);

-- employee (ERP 직원 정보)
CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,     -- 직원ID (PK)
    username VARCHAR(30),                      -- 아이디
    password VARCHAR(100),                     -- 비밀번호
    name VARCHAR(30),                          -- 이름
    phone VARCHAR(30),                         -- 폰번호
    email VARCHAR(50),                         -- 이메일
    dept_id INT,                               -- 부서번호 (FK → department.dept_id)
    job_id INT,                                -- 직급 번호 (FK → job.job_id)
    hire_date DATE,                            -- 입사일
    resign_date DATE,                          -- 퇴사일
    base_salary DECIMAL(12,2),                 -- 기본급
    status ENUM('active', 'resigned', 'on_leave')  -- 재직 상태
);

-- attendance (근태 관리)
CREATE TABLE attendance (
    attend_id INT AUTO_INCREMENT PRIMARY KEY,               -- 출결ID (PK)
    emp_id INT NOT NULL,                                    -- 직원ID (FK → employee.emp_id)
    attend_date DATE NOT NULL,          -- 근태 날짜
    check_in DATETIME DEFAULT NULL,                         -- 출근 시간
    check_out DATETIME DEFAULT NULL,                        -- 퇴근 시간
    status ENUM('출근', '지각', '조퇴', '결근', '휴가') NOT NULL DEFAULT '출근',  -- 근무 상태
    total_work_hours DECIMAL(5,2) DEFAULT 0.00,             -- 근무 시간(시간 단위)
    
    CONSTRAINT uq_attendance_emp_date UNIQUE (emp_id, attend_date)  -- 하루 1회만 출근 가능
);

CREATE TABLE leaved (
    leaved_id INT AUTO_INCREMENT PRIMARY KEY,      -- 휴가 ID (PK)
    emp_id INT,                                   -- 직원 ID (FK → employee.emp_id)
    leave_type ENUM('연차','병가','공가','경조사','기타'),  -- 휴가 종류
    start_date DATE,                               -- 휴가 시작일
    end_date DATE,                                 -- 휴가 종료일
    total_days INT,                                -- 총 휴가 일수
    reason VARCHAR(255),                           -- 사유
    status ENUM('대기','승인','반려'),             -- 승인 상태
    approver_id INT,                               -- 승인자 (FK → employee.emp_id)
    request_date DATETIME,                         -- 신청일
    approve_date DATETIME                          -- 승인일
);