CREATE TABLE board (
    no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    url VARCHAR(100),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM board;
delete from board;