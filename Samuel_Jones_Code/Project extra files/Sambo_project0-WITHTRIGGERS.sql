CREATE TABLE accounts(
    aid VARCHAR2(10) PRIMARY KEY,
    balance NUMBER(20) NOT NULL,
    isApproved CHAR(1) NOT NULL
    );

CREATE TABLE users(
    username VARCHAR2(10) PRIMARY KEY,
    password VARCHAR2(10) NOT NULL
    );
    
CREATE TABLE lookupTable(
    username VARCHAR2(10),
    aid VARCHAR2(10)
    );
--DROP TABLE approvedaccounts;
--DROP TABLE pendingaccounts;
--DROP SEQUENCE aid_sequence;
CREATE SEQUENCE aid_sequence
    START WITH 1
    INCREMENT BY 1;
    /
CREATE OR REPLACE TRIGGER increment_accountid
    BEFORE INSERT ON accounts
    FOR EACH ROW
    BEGIN
        IF: new.aid IS NULL THEN
        SELECT aid_sequence.nextval INTO :new.aid FROM dual;
        END IF;
    END;    
SELECT * FROM users;
INSERT INTO users VALUES ('new', 'pw');
SELECT * FROM lookuptable;
--select * from accounts;
--INSERT INTO accounts (aid, balance,isApproved) VALUES (null, 100, F);
--DELETE FROM accounts WHERE aid ='1';
--DELETE FROM accounts WHERE aid = '2';