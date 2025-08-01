/*
    TCL(Transaction control Language)
    - 트랜잭션을 제어하는 언어
    - 데이터베이스는 데이터의 변경 사항(INSERT,UPDATE,DELETE)
        들을 묶어서 하나의 트랜잭션에 담아서 처리
    
    트랜잭션(Transaction)
    - 하나의 논리적인 작업 단위
    
    예시) ATM기
        1. 카드 삽입
        2. 메뉴 선택
        3. 금액 확인 및 인증
        4. 실제 계좌에서 금액만큼 인출
        5. 현금 인출
        6. 완료
        
    - 각각의 업무를 트랜잭션
    
    COMMIT : 모든 작업들을 정상적으로 처리하겠다고 확정
    ROLLBOACK : 모든 작업들을 취소하겠다고 확정 (마지막 커밋 시점)
    SVAEPOINT 잠시 저장 시점을 정하고 ROLLBACK 진행 시 SAVEPOINT까지 일부 롤백
*/

CREATE TABLE USER_03
AS SELECT USER_ID, NAME, AGE, GENDER, HOBBY
FROM USER_INFO;

SELECT * FROM USER_03;

-- USER_03에서 USER_ID가 10, 20인 사람들 삭제
DELETE FROM USER_03
WHERE USER_ID IN(10,20);
-- 두행이 삭제된 시점에서 SAVEPOINT 지정
SAVEPOINT SP;

--USER_ ID가 13,15인 사람들 삭제
DELETE FROM USER_03
WHERE USER_ID IN(13,15);
ROLLBACK TO SP;
SELECT * FROM USER_03;
ROLLBACK;

-- HOBBY가 게임이 포함되신분들 삭제
DELETE FROM USER_03
WHERE HOBBY LIKE '%게임%';

CREATE TABLE TEST_03(
    TID NUMBER
);
ROLLBACK;