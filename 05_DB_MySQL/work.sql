CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

SELECT * FROM member;

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);



SELECT * FROM bank;
UPDATE bank SET BALANCE = 10000 WHERE name ='지은';
DROP TABLE bank;

DROP TABLE person;
CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);

UPDATE person SET name = 'a', age = 1, addr = 'a' WHERE id = 1;
DELETE FROM person WHERE id = 1;
SELECT * FROM person;
SELECT * FROM person WHERE name ='c' and age =1 and addr ='c';