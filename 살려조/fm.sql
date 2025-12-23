CREATE TABLE transaction(
	trans_id INT AUTO_INCREMENT PRIMARY KEY, -- 거래 번호
    trans_type VARCHAR(10) CHECK (trans_type IN ('수입', '지출')), -- 수입/지출
    trans_amount INT, -- 금액
    category VARCHAR(50), -- 분류
    trans_desc TEXT, -- 수입/지출 내역 상세
    trans_date DATE -- 수입/지출 발생 일자
);

CREATE TABLE purchase(
	purchase_id INT AUTO_INCREMENT PRIMARY KEY, -- 매입 번호
	ii_id INT NOT NULL, -- 물품명 외래키(item_info)
    quantity INT, -- 수량
    var_amount INT, -- 부가세 총액
    total_amount INT, -- 총액 unit_price * quantity 
    purchase_date DATE -- 매입일
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