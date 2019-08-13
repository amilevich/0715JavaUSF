CREATE TABLE customer_accounts(
    customerid NUMBER (5) PRIMARY KEY,
    username VARCHAR2 (25) NOT NULL,
    password VARCHAR2 (25), 
    firstname VARCHAR2 (25),
    lastname VARCHAR2 (25),
    phonenumber NUMBER(10),
    age NUMBER (3),
    jointaccess VARCHAR2(25),
    type NUMBER(1)
    );
SELECT * FROM customer_accounts;
DROP TABLE customer_accounts;

CREATE TABLE bank_accounts(
    accountid NUMBER (5)PRIMARY KEY,
    accountbalance NUMBER (7) NOT NULL,
    accounttype VARCHAR2 (25) NOT NULL,
    username VARCHAR2 (25),
    jointaccess VARCHAR2(50),
    status VARCHAR2(25)
    );
SELECT * FROM bank_accounts;
DROP TABLE bank_accounts;
    
    
CREATE TABLE account_access(
    accountid NUMBER (5),
    customerid NUMBER (5),
    jointaccess VARCHAR2(25)
    );
    
SELECT * FROM account_access;
DROP TABLE account_access;
    
    
CREATE TABLE employee_accounts(
    username VARCHAR2 (25) NOT NULL,
    password VARCHAR2(25)NOT NULL,
    firstname VARCHAR2(25),
    lastname VARCHAR2 (25),
    phonenumber NUMBER (10),
    type NUMBER(1),
    employeeID NUMBER(5)PRIMARY KEY
    );

DROP TABLE employee_accounts;
INSERT INTO employee_accounts (username, password, type, employeeID) VALUES ('boss', 'boss',3, 1876);
    
--SEQUENCE FOR CustomerID
CREATE SEQUENCE customerid_seq
START WITH 1
INCREMENT BY 1;
/
--TRIGGER for new Customer Accounts ID
CREATE TRIGGER set_customer_id
BEFORE INSERT ON customer_accounts
FOR EACH ROW
BEGIN
    IF: new.customerid IS NULL THEN
    SELECT customerid_seq.nextval INTO :new.customerid FROM dual;
    END IF;
    END;
    /
DROP TRIGGER set_customer_id;
DROP SEQUENCE customerid_seq;
  
  
  
  --SEQUENCE FOR BankAccountID
CREATE SEQUENCE bank_AccountId_seq
START WITH 111
INCREMENT BY 1;
/
--TRIGGER for new Bank Accounts ID
CREATE TRIGGER set_account_id
BEFORE INSERT ON bank_accounts
FOR EACH ROW
BEGIN
    IF: new.accountid IS NULL THEN
    SELECT bank_AccountId_seq.nextval INTO :new.accountid FROM dual;
    END IF;
    END;
    /
    
DROP TRIGGER set_account_id;
DROP SEQUENCE bank_AccountId_seq;