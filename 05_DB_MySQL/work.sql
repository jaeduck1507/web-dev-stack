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


DROP TABLE book;
CREATE TABLE book(
	book_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    access_age INT DEFAULT 0
);
DROP TABLE member;
CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    age INT NOT NULL
);
DROP TABLE rent;
CREATE TABLE rent(
	rent_no INT AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(100),
    book_no INT,
    rent_date DATE DEFAULT (CURRENT_DATE)
);


ALTER TABLE rent ADD
FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE;
ALTER TABLE rent ADD
FOREIGN KEY (book_no) REFERENCES book(book_no);

-- SELECT * FROM member WHERE id = ? and pwd = ?;
select * from member;
select * from book;
select * from rent;

SELECT b.book_no, title, author, access_age FROM rent r 
JOIN book b ON r.book_no = b.book_no
JOIN member m ON m.id = r.id
WHERE m.id = 'a';  
DELETE FROM person WHERE id = 1;
SELECT count(id) AS cnt FROM rent WHERE id = 'a' GROUP BY id ;
SELECT count(book_no) AS cnt FROM rent WHERE book_no = 5 GROUP BY book_no;

INSERT INTO member VALUES('a', 'a', 'a', 10);
INSERT INTO member VALUES('admin', '관리자', '1234', 9999);
INSERT INTO book(title, author, access_age) VALUES('a', 'a', 1);
INSERT INTO book(title, author, access_age) VALUES('b', 'a', 1);
INSERT INTO book(title, author, access_age) VALUES('c', 'a', 1);
INSERT INTO book(title, author, access_age) VALUES('d', 'a', 1);
INSERT INTO book(title, author, access_age) VALUES('e', 'a', 1);
INSERT INTO book(title, author, access_age) VALUES('f', 'a', 1);
INSERT INTO rent(id, book_no) VALUES('a', '1');

