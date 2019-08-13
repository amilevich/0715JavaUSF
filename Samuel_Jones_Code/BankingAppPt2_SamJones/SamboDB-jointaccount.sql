--DROP TABLE accounts; -- DDL data definition language ALTER CREATE TRUNCATE DROP
--DROP TABLE users;
--DROP TABLE junctiontable;

-- run these three below to reset the sequences to 1, and empty the tables
DROP SEQUENCE aid_sequence; 
truncate table junctiontable;
truncate table  accounts;
truncate table users;
 
CREATE TABLE accounts(
    aid VARCHAR2(30) PRIMARY KEY,
    balance NUMBER(20) NOT NULL,
    isapproved NUMBER(1) NOT NULL,
    temptoken VARCHAR(30) UNIQUE
    );
--ALTER TABLE accounts(
    
CREATE TABLE users(
    username VARCHAR2(30) PRIMARY KEY,
    password VARCHAR2(30) NOT NULL
    );
    
CREATE TABLE junctiontable(
    username VARCHAR2(30),
    aid VARCHAR2(30)
    );
    
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
SELECT * FROM accounts;
SELECT * FROM junctiontable;
