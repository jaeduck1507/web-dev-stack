
ALTER TABLE qna_answer
    ADD FOREIGN KEY (qna_id) REFERENCES qna(qna_id);
    
ALTER TABLE favorites
    ADD FOREIGN KEY (location_id) REFERENCES location(location_id);

ALTER TABLE favorites
    ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
    
ALTER TABLE cancel_info
    ADD FOREIGN KEY (payment_key) REFERENCES payment_info(payment_key);

ALTER TABLE booking
    ADD FOREIGN KEY (payment_key) REFERENCES payment_info(payment_key);

ALTER TABLE rent_reservation
    ADD FOREIGN KEY (payment_key) REFERENCES payment_info(payment_key);



ALTER TABLE rent_reservation
    ADD FOREIGN KEY (location_id) REFERENCES location(location_id);


ALTER TABLE booking
    ADD FOREIGN KEY (rr_id) REFERENCES rent_reservation(rr_id);


ALTER TABLE booking
    ADD FOREIGN KEY (user_id) REFERENCES user(user_id);


ALTER TABLE service_management
    ADD FOREIGN KEY (booking_id) REFERENCES booking(booking_id);


ALTER TABLE transport_service
    ADD FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);


ALTER TABLE item_service
    ADD FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);
    
ALTER TABLE location
    ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
    


ALTER TABLE employee
    ADD FOREIGN KEY (dept_id) REFERENCES department(dept_id);


ALTER TABLE employee
    ADD FOREIGN KEY (job_id) REFERENCES job(job_id);

ALTER TABLE attendance
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);


ALTER TABLE leaved
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);


ALTER TABLE leaved
    ADD FOREIGN KEY (approver_id) REFERENCES employee(emp_id);
    


ALTER TABLE item_info ADD
    FOREIGN KEY (ic_id) REFERENCES item_category(ic_id);

ALTER TABLE item ADD
    FOREIGN KEY (item_info_id) REFERENCES item_info(item_info_id);
    

ALTER TABLE project ADD
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id);

ALTER TABLE project ADD
    FOREIGN KEY (sm_id) REFERENCES service_management(sm_id);

    
ALTER TABLE project_member ADD
    FOREIGN KEY (project_id) REFERENCES project(project_id);

ALTER TABLE project_member ADD
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id);
    




ALTER TABLE purchase
    ADD FOREIGN KEY (ii_id) REFERENCES item_info(item_info_id);


ALTER TABLE salary
    ADD FOREIGN KEY (emp_id) REFERENCES employee(emp_id);


ALTER TABLE transport_income
    ADD FOREIGN KEY (ts_id) REFERENCES transport_service(ts_id);


ALTER TABLE item_income
    ADD FOREIGN KEY (is_id) REFERENCES item_service(is_id);


ALTER TABLE payment_fee
    ADD FOREIGN KEY (booking_id) REFERENCES booking(booking_id);