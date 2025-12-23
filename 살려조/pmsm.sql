-- 물품 정보 테이블
CREATE TABLE item_info (
    item_info_id      INT AUTO_INCREMENT PRIMARY KEY,   -- 물품 PK
    item_name  VARCHAR(50) ,             -- 물품 이름
    ic_id INT ,                     -- 카테고리 FK(추후 추가)
    item_price INT,           -- 물품 가격
    rent_fee INT        -- 대여 가격
   );      



-- 상품 카테고리 테이블
CREATE TABLE item_category (
    ic_id    INT PRIMARY KEY,  -- 카테고리 PK
    category VARCHAR(50)       -- 카테고리명
);



-- item(물품) 테이블
CREATE TABLE item (
    item_id         INT PRIMARY KEY,      -- 개별물품 PK
    item_info_id           INT,                  -- item_info FK (추후 추가)
    item_store_date DATE,                 -- 입고일(물품)
    is_id           INT DEFAULT 0         -- 물품 대여 여부(0=미대여)
);

    


-- transport
CREATE TABLE transport (
    transport_id INT AUTO_INCREMENT PRIMARY KEY,
    truck_num    INT,
    truck_fee    INT,
    rented       INT
);


create table project (
project_id  INT AUTO_INCREMENT PRIMARY KEY, -- PK
booking_id int, -- 예약된 정보 FK(booking)
sm_id int, -- 빌린 물품/차량 FK(service_management)
status enum('대기', '반려', '승인', '진행중', '완료'), -- 상태
start_date DATE DEFAULT NULL, -- 프로젝트 시작일
end_plan_date DATE DEFAULT NULL, -- 프로젝트 종료 예정일
end_date DATE DEFAULT NULL -- 프로젝트 종료일
);




-- project_member 테이블
CREATE TABLE project_member (
    pm_id     INT AUTO_INCREMENT PRIMARY KEY,  -- PK
    project_id INT,                            -- FK (project)
    emp_id     INT,                            -- FK (employee)
    role       VARCHAR(20),                    -- 역할
    join_date  DATE                            -- 참여날짜
);

CREATE TABLE schedule(
 schedule_id INT AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(100) NOT NULL,
 START_DATE DATETIME,
 END_DATE DATETIME
);