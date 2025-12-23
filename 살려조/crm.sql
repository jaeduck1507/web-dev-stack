CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,      -- userid (PK)
    username VARCHAR(30),                        -- 아이디
    password VARCHAR(100),                     -- 비번
    name VARCHAR(30),                          -- 이름 또는 상호
    phone VARCHAR(30),                           -- 폰번호
    email VARCHAR(50),                           -- 이메일
    customer_type VARCHAR(10)                    -- 임대인/임차인 분류
    
);

-- rent_reservation(임대 장소 등록)
CREATE TABLE rent_reservation (
    rr_id INT AUTO_INCREMENT PRIMARY KEY,        -- 임대장소등록id (PK)
    location_id INT,                             -- 임대장소id (FK → location)
    rent_start DATE,                         -- 임대 시작일
    rent_end DATE,                           -- 임대 종료일
    rental_fee INT,                               -- 대관료
    rent_days INT,								 -- 대관 일수
    ad_cost INT,						             -- 대관료 10% X 대관 일수
    payment_key VARCHAR(300)					-- 결제정보 외래키
);

-- booking(예약)
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
    total_fee int								-- 총 결제 금액(서비스 포함)
    
);

-- service_management(통합 서비스 관리)
CREATE TABLE service_management (
    sm_id INT AUTO_INCREMENT PRIMARY KEY,        -- PK
    transport BOOLEAN,                           -- 운송서비스 이용여부
    items BOOLEAN,                               -- 물품 대여 이용여부
    booking_id INT                               -- FK → booking
);

-- transport_service(운송 서비스)
CREATE TABLE transport_service (
    ts_id INT AUTO_INCREMENT PRIMARY KEY,        -- PK
    t_start_date DATE,                         -- 운송 시작일
    t_end_date DATE,                           -- 운송 종료일
    transport_fee int,
    transport_num int,
    sm_id INT                                    -- FK → service_management
);

-- item_service(물품 대여 서비스)
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

-- 즐겨찾기
CREATE TABLE favorites (
	favorites_id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    user_id INT,
    favorites_status BOOLEAN
    
);

-- 자주 묻는 질문(faq)
CREATE TABLE faq (
	faq_id INT AUTO_INCREMENT PRIMARY KEY,
    title TEXT,
    content TEXT,
    created_at DATETIME,
    updated_at DATETIME
);

-- 공지사항
CREATE TABLE announcement (
	an_id INT AUTO_INCREMENT PRIMARY KEY,
    title TEXT,
    content TEXT,
    created_at DATETIME,
    updated_at DATETIME
);


