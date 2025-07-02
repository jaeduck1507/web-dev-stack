SELECT * FROM user_info;
INSERT INTO user_info(id, password,name) VALUES('user','1234','김미경');
DELETE FROM USER_INFO WHERE user_no = 2;
UPDATE user_info SET email = 'email@naver.com' WHERE user_no = 1;

rollback;