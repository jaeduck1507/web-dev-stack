CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,      -- userid (PK)
    username VARCHAR(30),                        -- 아이디
    password VARCHAR(100),                     -- 비번
    name VARCHAR(30),                          -- 이름 또는 상호
    phone VARCHAR(30),                           -- 폰번호
    email VARCHAR(50),                           -- 이메일
    customer_type VARCHAR(10)                    -- 임대인/임차인 분류
);

CREATE TABLE persistent_logins (
    username  VARCHAR(64) NOT NULL COMMENT '사용자 아이디 (로그인 계정)',
    series    VARCHAR(64) NOT NULL COMMENT '기기/브라우저별 고유 식별자 (PK)',
    token     VARCHAR(64) NOT NULL COMMENT '현재 유효한 인증 토큰 (매번 갱신됨)',
    last_used TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막으로 자동 로그인이 실행된 시간'
);

CREATE TABLE rent_reservation (
    rr_id INT AUTO_INCREMENT PRIMARY KEY,        -- 임대장소등록id (PK)
    location_id INT,                             -- 임대장소id (FK → location)
    rent_start DATE,                         -- 임대 시작일
    rent_end DATE,                           -- 임대 종료일
    rental_fee INT,                               -- 대관료
    rent_days INT,								 -- 대관 일수
    ad_cost INT,						             -- 대관료 10% X 대관 일수
    payment_key VARCHAR(300),					-- 결제정보 외래키
    is_blocked tinyint(1) DEFAULT '0'			-- 게시물 차단용
);

CREATE TABLE booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,   -- 예약id (PK)
    rr_id INT,                                   -- FK → rent_reservation
    user_id INT,                                 -- FK → user
    booking_start DATE,                      -- 예약 시작일
    booking_end DATE,                        -- 예약 종료일
    rent_purpose TEXT,                           -- 대관목적
    use_service BOOLEAN,                         -- 서비스 유무
    booking_fee INT,							-- 예약일수에 따른 금액
    rent_approval BOOLEAN,						 -- 예약 승인 여부		
	payment_key VARCHAR(300),					-- 결제키 외래키
    total_fee int,								-- 총 결제 금액(서비스 포함)
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 예약날짜
    is_canceled tinyint(1) DEFAULT 0, -- 예약 취소 여부 (0: 취소 안됨, 1: 취소됨)
    cancellation_date datetime DEFAULT NULL, -- 취소 처리 시간
    penalty_fee INT DEFAULT 0, -- 취소로 인해 발생한 위약금 금액
    refund_amount INT DEFAULT 0 -- 위약금을 제외하고 실제로 환불된 금액
);


CREATE TABLE service_management (
    sm_id INT AUTO_INCREMENT PRIMARY KEY,        -- PK
    transport BOOLEAN,                           -- 운송서비스 이용여부
    items BOOLEAN,                               -- 물품 대여 이용여부
    booking_id INT                               -- FK → booking
);


CREATE TABLE transport_service (
    ts_id INT AUTO_INCREMENT PRIMARY KEY,        -- PK
    t_start_date DATE,                         -- 운송 시작일
    t_end_date DATE,                           -- 운송 종료일
    transport_fee int,
    transport_num int,
    sm_id INT,                                 -- FK → service_management
    returnd boolean							   -- 반납 여부 확인
);


CREATE TABLE item_service (
    is_id INT AUTO_INCREMENT PRIMARY KEY,        -- PK
    i_start_date DATE,                         -- 대여 시작일
    i_end_date DATE,                           -- 대여 종료일
    item_fee int,
    sm_id INT                                    -- FK → service_management
);

CREATE TABLE location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,  -- 임대장소id (PK)
    user_id INT,                                 -- 임대인 user_id (FK → user.user_id)
	location_name VARCHAR(100),					-- 장소 이름 추가
    st_address VARCHAR(200),                     -- 도로명 주소
    detail_address VARCHAR(200),                 -- 상세 주소
    post_no VARCHAR(10),                         -- 우편번호

	desc_details TEXT,
    area_size FLOAT,                             -- 면적
    floor VARCHAR(30),                           -- 구조(지하, 루프탑, 층수 등)

    parking BOOLEAN,                             -- 주차시설 유무
    waterworks BOOLEAN,                          -- 급수설비 유무
    cooking_able BOOLEAN,                        -- 조리시설 유무
    audio_able BOOLEAN,                          -- 음향시설 유무
    lighting_able BOOLEAN,                       -- 조명시설 유무
    air_conditioner BOOLEAN,                     -- 에어컨 유무
    wifi BOOLEAN,                                -- 와이파이 유무
    elevator BOOLEAN,                            -- 엘리베이터 유무
    toilet BOOLEAN,                              -- 화장실 유무

    ad_able BOOLEAN,                             -- 외벽광고 가능 유무
    purpose VARCHAR(30),                         -- 사용용도 (카페형, 식당형, 팝업형, 전시장, 스튜디오)

    description TEXT,                            -- 상세설명
    photo TEXT,                                  -- 사진(여러 장이면 추후 JSON/별도 테이블 고려)
    thumbnail TEXT,                              -- 섬네일

    rental_fee INT,                              -- 대관료
    deposit INT,                                 -- 보증금 (대관료의 10~50%)

    location_approval BOOLEAN 					 -- 장소 허가(직원 확인)
);

CREATE TABLE payment_info (
  payment_key     VARCHAR(300) PRIMARY KEY,                     -- 기본키(결제 키)
  user_id		int,											-- user테이블 외래키
  order_id        VARCHAR(300) NOT NULL,                     -- 주문번호 (유니크 권장)
  order_name      VARCHAR(300) NOT NULL,                     -- 구매상품
  method          VARCHAR(100) ,                         -- 결제수단
  status          VARCHAR(50)  NOT NULL,                     -- 결제 처리 상태
  total_amount    INT NOT NULL,                              -- 총 결제 금액
  balance_amount  INT,                    -- 취소 가능 잔액
  requested_at    DATETIME,                         	-- 결제
  approved_at     DATETIME,
  payment_category VARCHAR(100),		-- 결제 종류(임대등록,예약등록)
  last_transaction_key VARCHAR(300)
  );
  
CREATE TABLE cancel_info (
	transaction_key VARCHAR(300) PRIMARY KEY,   -- 결제 정보 키
    payment_key VARCHAR(300), -- 결제 키 외래키
    user_id int,		-- user테이블 외래키
    cancel_reason VARCHAR(100), 	-- 취소사유
    cancel_amount int,		-- 취소금액
    cancel_status VARCHAR(300), -- 취소 상태
    canceled_at DATETIME 	-- 취소 일시
    
);


CREATE TABLE favorites (
	favorites_id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    user_id INT,
    favorites_status BOOLEAN
    
);


CREATE TABLE faq (
	faq_id INT AUTO_INCREMENT PRIMARY KEY,
    title TEXT,
    content TEXT,
    created_at DATETIME,
    updated_at DATETIME
);


CREATE TABLE announcement (
	an_id INT AUTO_INCREMENT PRIMARY KEY,
    title TEXT,
    content TEXT,
    created_at DATETIME,
    updated_at DATETIME
);

  CREATE TABLE notification (
    noti_id      INT AUTO_INCREMENT PRIMARY KEY,
    sender_id    INT NOT NULL,              -- 예약한 임차인
    receiver_id  INT NOT NULL,              -- 건물 임대인
    booking_id   INT NULL,                  -- 어떤 예약인지
    message      TEXT NOT NULL,             -- 알림 메시지
    is_read      CHAR(1) NOT NULL DEFAULT 'N',
    created_at   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    qna_id INT NULL                         -- FK qna.qna_id
);
  
create table qna(
	qna_id INT AUTO_INCREMENT PRIMARY KEY,
	qna_user_id INT NOT NULL,              -- 질문자 user_id (FK)
	qna_title   VARCHAR(200) NOT NULL, -- 질문 제목
	qna_content TEXT NOT NULL,  -- 질문 내용
	location_id INT,  -- fk location,
	status  VARCHAR(20) NOT NULL DEFAULT 'WAIT', -- 'WAIT' = 답변대기, 'DONE' = 답변완료, 'HIDDEN' = 숨김 등
	is_secret     CHAR(1) NOT NULL DEFAULT 'N',  -- 'Y' = 비밀글, 'N' = 공개
	created_at    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,       -- 질문 등록일
	updated_at  DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP  -- updated_at은 수정 시각을 기록하고 싶을 때 유용
	);

CREATE TABLE qna_answer (
    answer_id INT AUTO_INCREMENT PRIMARY KEY,        -- 답변 PK
    qna_id    INT NOT NULL,                          -- FK → qna.qna_id
    answer_user_id INT NOT NULL,                     -- 답변 작성자 user_id (관리자/사장/직원 등)
    answer_content TEXT NOT NULL,                    -- 답변 내용
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP        -- 답변 작성일
);

CREATE TABLE item_info (
    item_info_id      INT AUTO_INCREMENT PRIMARY KEY,   
    item_name  VARCHAR(50) ,             
    ic_id INT ,                     
    item_price INT,           
    rent_fee INT        
   );      
   
CREATE TABLE item_category (
    ic_id    INT PRIMARY KEY,  
    category VARCHAR(50)       
);

CREATE TABLE item (
    item_id         INT PRIMARY KEY,      
    item_info_id           INT,                  
    item_store_date DATE,                 
    is_id           INT DEFAULT 0
);

CREATE TABLE transport (
    transport_id INT AUTO_INCREMENT PRIMARY KEY,
    truck_num    INT,
    truck_fee    INT,
    rented       INT
);

create table project (
project_id  INT AUTO_INCREMENT PRIMARY KEY, 
booking_id int, 
sm_id int, 
status enum('대기', '반려', '승인', '진행중', '완료'), 
start_date DATE DEFAULT NULL, 
end_plan_date DATE DEFAULT NULL 
);

CREATE TABLE project_member (
    pm_id     INT AUTO_INCREMENT PRIMARY KEY,  
    project_id INT,                            
    emp_id     INT,                            
    name       VARCHAR(20),                    
    role       VARCHAR(20),                    
    join_date  DATE                            
);

CREATE TABLE schedule(
 schedule_id INT AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(100) NOT NULL,
 start_date DATETIME,
 end_date DATETIME
);

CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    booking_id INT NOT NULL,
    rr_id INT NOT NULL,
    location_id INT NOT NULL,
    rating INT,
    content TEXT,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id),
    FOREIGN KEY (rr_id) REFERENCES rent_reservation(rr_id),
    FOREIGN KEY (location_id) REFERENCES location(location_id)
);

CREATE TABLE transaction(
	trans_id INT AUTO_INCREMENT PRIMARY KEY, 
    trans_type VARCHAR(10) CHECK (trans_type IN ('수입', '지출')),
    trans_amount INT, 
    category VARCHAR(50), 
    trans_desc TEXT, 
    trans_date DATE 
);

CREATE TABLE purchase(
	purchase_id INT AUTO_INCREMENT PRIMARY KEY, 
	ii_id INT NOT NULL, 
    quantity INT, 
    var_amount INT, 
    total_amount INT, 
    purchase_date DATE
);

CREATE TABLE add_transport(
	at_id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT, -- 수량
    var_amount INT, -- 부가세 총액
    total_amount INT, -- 총액 unit_price * quantity 
    purchase_date DATE -- 매입일
);

CREATE TABLE salary (
    salary_id INT AUTO_INCREMENT PRIMARY KEY,    -- 급여ID (PK)
    emp_id INT,                                  -- 직원ID (FK → employee.emp_id)
    deduction INT,                               -- 공제금액
    total_salary INT,                            -- 총 지급액
    salary_date DATE                              -- 지급일
);

CREATE TABLE transport_income (
	ti_id INT AUTO_INCREMENT PRIMARY KEY,
    ts_id INT, -- 운송ID(FK -> transport_service)
    transport_amount INT, -- 운송 금액
    payment_date DATE -- 결제 날짜
);

CREATE TABLE item_income (
	ii_id INT AUTO_INCREMENT PRIMARY KEY,
    is_id INT, -- 운송ID(FK -> transport_service)
    item_amount INT, -- 운송 금액
    payment_date DATE -- 결제 날짜
);

CREATE TABLE payment_fee (
	pf_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT, -- 예약아이디(fk -> booking)
    booking_payment INT, -- 결제 금액
    booking_fee INT, -- 결제 수수료
    payment_date DATE -- 결제 날짜 
);
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
    status ENUM('active', 'resigned', 'on_leave'),  -- 재직 상태
    total_days INT NOT NULL DEFAULT 15          -- 기본 휴가
);


-- attendance (근태 관리)
CREATE TABLE attendance (
    attend_id INT AUTO_INCREMENT PRIMARY KEY,               -- 출결ID (PK)
    emp_id INT NOT NULL,                                    -- 직원ID (FK → employee.emp_id)
    attend_date DATE NOT NULL,          					-- 근태 날짜
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
    reason VARCHAR(255),                           -- 사유
    status ENUM('대기','승인','반려') NOT NULL DEFAULT '대기',             -- 승인 상태
    approver_id INT,                               -- 승인자 (FK → employee.emp_id)
    request_date DATETIME,                         -- 신청일
    approve_date DATETIME,                          -- 승인일
    leaved_days INT                                -- 총 휴가 일수
);


