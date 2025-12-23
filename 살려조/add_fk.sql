-- =========================
-- CRM
-- =========================

-- rent_reservation.location_id → location.location_id
ALTER TABLE rent_reservation
    ADD FOREIGN KEY (location_id) REFERENCES location(location_id);

-- booking.rr_id → rent_reservation.rr_id
ALTER TABLE booking
    ADD FOREIGN KEY (rr_id) REFERENCES rent_reservation(rr_id);

-- booking.user_id → user.user_id
ALTER TABLE booking
    ADD FOREIGN KEY (user_id) REFERENCES user(user_id);

-- service_management.booking_id → booking.booking_id
ALTER TABLE service_management
    ADD FOREIGN KEY (booking_id) REFERENCES booking(booking_id);

-- transport_service.sm_id → service_management.sm_id
ALTER TABLE transport_service
    ADD FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);

-- item_service.sm_id → service_management.sm_id
ALTER TABLE item_service
    ADD FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);
    
ALTER TABLE location
    ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
    

-- =========================
-- hrm
-- =========================

-- employee.dept_id → department.dept_id
ALTER TABLE employee
    ADD FOREIGN KEY (dept_id) REFERENCES department(dept_id);

-- employee.job_id → job.job_id
ALTER TABLE employee
    ADD FOREIGN KEY (job_id) REFERENCES job(job_id);

ALTER TABLE attendance
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);

-- 휴가 신청자 FK
ALTER TABLE leaved
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);

-- 승인자 FK (employee 재참조)
ALTER TABLE leaved
    ADD FOREIGN KEY (approver_id) REFERENCES employee(emp_id);
    

-- FK 별도 추가(pm sm)
-- ic_id 외래키   
ALTER TABLE item_info ADD
    FOREIGN KEY (ic_id) REFERENCES item_category(ic_id);

ALTER TABLE item ADD
    FOREIGN KEY (ii_id) REFERENCES item_info(ii_id);
    
-- 외래키는 따로 추가
ALTER TABLE project ADD
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id);

ALTER TABLE project ADD
    FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);

-- ALTER TABLE project ADD
   -- FOREIGN KEY (pm_id) REFERENCES project_member(pm_id);
    
ALTER TABLE project_member ADD
    FOREIGN KEY (project_id) REFERENCES project(project_id);

ALTER TABLE project_member ADD
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id);
    

-- =========================
-- FM
-- =========================

-- 외래키 추가 (transaction 테이블에 관련 없음, 자체적으로 관리됨)

-- purchase 테이블의 물품명 외래키 (item_info 테이블 참조)
ALTER TABLE purchase
    ADD FOREIGN KEY (ii_id) REFERENCES item_info(ii_id);

-- salary 테이블의 직원ID 외래키 (employee 테이블 참조)
ALTER TABLE salary
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);

-- transport_income 테이블의 운송ID 외래키 (transport_service 테이블 참조)
ALTER TABLE transport_income
    ADD FOREIGN KEY (ts_id) REFERENCES transport_service(ts_id);

-- item_income 테이블의 운송ID 외래키 (transport_service 테이블 참조)
ALTER TABLE item_income
    ADD FOREIGN KEY (is_id) REFERENCES item_service(is_id);

-- payment_fee 테이블의 예약아이디 외래키 (booking 테이블 참조)
ALTER TABLE payment_fee
    ADD FOREIGN KEY (booking_id) REFERENCES booking(booking_id);