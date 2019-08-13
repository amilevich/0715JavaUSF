CREATE TABLE person(
    username VARCHAR2(100) NOT NULL PRIMARY KEY,
    pwd VARCHAR2(100) NOT NULL,
    nmcustomer VARCHAR2(100) NOT NULL,
    address VARCHAR2(100) NOT NULL,
    phone VARCHAR2(15),
    kindperson VARCHAR2(1)
    );
    
CREATE TABLE account(
    accountnumber VARCHAR2(100) NOT NULL PRIMARY KEY,
    amount DECIMAL(38,2),
    kindaccount VARCHAR2(1) NOT NULL,
    dateacount DATE NOT NULL,
    status VARCHAR2(1)
    );
 
 DROP TABLE account;
    
CREATE TABLE transaction(
    idtransaction NUMBER(38) NOT NULL PRIMARY KEY,
    amount DECIMAL(38,2),
    datetime DATE NOT NULL,
    kindtransaction VARCHAR2(1) NOT NULL,
    observation VARCHAR2(300) NULL,
    accountnumber VARCHAR2(100) NOT NULL,
    CONSTRAINT account_id_fk FOREIGN KEY (accountnumber) REFERENCES account(accountnumber) 
    );
    
    DROP TABLE transaction;
    
ALTER TABLE jointaccount ADD status VARCHAR2(1);

CREATE TABLE jointaccount(
    username VARCHAR2(100) NOT NULL,
    accountnumber VARCHAR2(100) NOT NULL,
    status VARCHAR2(1) NOT NULL,
    CONSTRAINT personjacct_id_fk FOREIGN KEY (username) REFERENCES person(username),
    CONSTRAINT accountjacct_id_fk FOREIGN KEY (accountnumber) REFERENCES account(accountnumber)
    );

CREATE SEQUENCE transaction_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER transaction_seq_trigger
BEFORE INSERT ON transaction
FOR EACH ROW 
BEGIN
    IF :new.idtransaction IS NULL THEN
        SELECT transaction_seq.nextval
        INTO :new.idtransaction
        FROM dual;
    END IF;
END;

execute immediate 'DROP TRIGGER' || owner.transaction_seq_trigger;

DROP TRIGGER transaction_seq_trigger;
DROP SEQUENCE transaction_seq;
/*CREATE OR REPLACE TRIGGER TRIGGER1
BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
IF :new.ID IS NULL THEN 
SELECT ACCOUNTS_SEQ.NEXTVAL 
INTO :new.ID
FROM dual;
END IF;
END;*/
    
 SELECT * FROM PERSON;   
 
 CREATE TABLE parameters(
    idparameter NUMBER(38) NOT NULL PRIMARY KEY,
    seqaccount NUMBER(38) NOT NULL,
    nameparameter VARCHAR2(100) NOT NULL
);

DROP TRIGGER parameter_seq_trigger;
DROP SEQUENCE parameter_seq;
DROP TABLE parameters;

CREATE SEQUENCE parameter_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER parameter_seq_trigger
BEFORE INSERT ON parameters
FOR EACH ROW 
BEGIN
    IF :new.idparameter IS NULL THEN
        SELECT parameter_seq.nextval
        INTO :new.idparameter
        FROM dual;
    END IF;
END;
/

DELETE FROM parameters;

INSERT INTO parameters VALUES(NULL,1,'Acount Number');
update parameters SET seqaccount = 1 WHERE idparameter = 2;

SELECT * FROM parameters;




    