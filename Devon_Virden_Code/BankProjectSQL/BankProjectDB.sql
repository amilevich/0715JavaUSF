CREATE TABLE bank_user
(
    user_id VARCHAR2(15) PRIMARY KEY,
    user_name VARCHAR2(200) NOT NULL,
    user_password VARCHAR2(15)NOT NULL,
    user_type VARCHAR2(100) NOT NULL
);    
    
CREATE TABLE bank_account
(
    account_number NUMBER(38) PRIMARY KEY,
    account_name VARCHAR2(50) NOT NULL,
    balance NUMBER(12,2),
    status VARCHAR2(10),
    CONSTRAINT balance_check CHECK (balance>=0)
);

CREATE TABLE linker
(
    link_index NUMBER(38)PRIMARY KEY,
    account_number NUMBER(38),
    user_id VARCHAR2(15),
    CONSTRAINT fk_id FOREIGN KEY (user_id) REFERENCES bank_user (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_number FOREIGN KEY (account_number) REFERENCES bank_account (account_number) ON DELETE CASCADE
);    

CREATE SEQUENCE link_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE TRIGGER link_seq_trigger
BEFORE INSERT ON linker
FOR EACH ROW
BEGIN
    IF :new.link_index = 0 THEN
    SELECT link_seq.nextval INTO :new.link_index FROM dual;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE retrieve(acc_num OUT NUMBER)
IS
BEGIN
    SELECT MAX(account_number) INTO acc_num FROM bank_account;
END;
/

CREATE SEQUENCE account_seq
    START WITH 1000
    INCREMENT BY 1;
/

CREATE TRIGGER account_seq_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW
BEGIN
    IF :new.account_number < 1000 THEN
    SELECT account_seq.nextval INTO :new.account_number FROM dual;
    END IF;
END;
/

COMMIT;