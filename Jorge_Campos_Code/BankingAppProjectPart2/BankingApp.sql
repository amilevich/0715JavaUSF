CREATE TABLE Users (    
    u_user_name VARCHAR2(15) PRIMARY KEY,
    u_password VARCHAR2(15),
    u_balance NUMBER(15),
    u_approved NUMBER(1),
    u_joint NUMBER(1),
    u_employee NUMBER(1),
    u_admin NUMBER(1),
    u_account_num NUMBER(9),
    u_joint_id VARCHAR2(9)
);
SELECT * FROM users;


CREATE SEQUENCE acct_num_seq
    START WITH 1000
    INCREMENT BY 1;
    --This sequence can be used to handle the id field for employees.
/


CREATE TRIGGER acct_num_seq_trigger --naming the trigger
BEFORE INSERT ON Users -- when and what action happens 'AFTER'
FOR EACH ROW
BEGIN --signifies a block for a transaction
    IF :new.u_account_num = 0 THEN
    SELECT acct_num_seq.nextval INTO :new.u_account_num FROM dual;
    END IF;
END;
/

DELETE FROM  users where u_user_name = 'test';

SELECT * FROM users;

Insert INTO Users Values('test','word',0,0,0,0,0,0);