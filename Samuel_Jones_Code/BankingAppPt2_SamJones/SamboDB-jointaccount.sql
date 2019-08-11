--DROP TABLE accounts; -- DDL data definition language ALTER CREATE TRUNCATE DROP
--DROP TABLE users;
--DROP TABLE junctiontable;
-- run these three below to reset the sequences to 1, and empty the tables
DROP SEQUENCE aid_sequence; 
truncate table junctiontable;
truncate table  accounts;
truncate table users;
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
CREATE TABLE accounts(
    aid VARCHAR2(10) PRIMARY KEY,
    balance NUMBER(20) NOT NULL,
    isapproved NUMBER(1) NOT NULL,
    temptoken VARCHAR(20) UNIQUE
    );
--ALTER TABLE accounts(
    
CREATE TABLE users(
    username VARCHAR2(10) PRIMARY KEY,
    password VARCHAR2(10) NOT NULL
    );
    
CREATE TABLE junctiontable(
    username VARCHAR2(10),
    aid VARCHAR2(10)
    );
--CREATE TABLE lookupTableJoint(
--    username1 VARCHAR2(10),
--    username2 VARCHAR2(10),
--    aid VARCHAR2(10)
--    );


--CREATE SEQUENCE aid_sequence2
--    start with 1
--    increment by 1;
--CREATE OR REPLACE TRIGGER increment_AID_Lookup
--    BEFORE INSERT ON lookuptable
--    FOR EACH ROW
--    BEGIN
--       IF: new.aid IS NULL THEN
--        SELECT aid_sequence.nextval INTO :new.aid FROM dual;
--        END IF;
--    END; 
 
    
 INSERT INTO users VALUES ('admin','admin');
--INSERT INTO lookuptable VALUES ('admin',null);
INSERT INTO users VALUES ('emp','emp');
INSERT INTO users VALUES ('test','test');
--INSERT INTO lookuptable VALUES ('emp',null);
SELECT * FROM users;
SELECT * FROM accounts;
SELECT * FROM junctiontable;
--INSERT INTO lookuptable VALUES ('sam',null);

--select * from accounts;
--INSERT INTO accounts (aid, balance,isApproved) VALUES (null, 100, F);
--DELETE FROM accounts WHERE aid ='1';
--DELETE FROM accounts WHERE aid = '2';