CREATE TABLE pending_customer (
    user_name VARCHAR2(20) PRIMARY KEY,
    pass_word VARCHAR2(20),
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    phone_number VARCHAR2(20),
    customer_id VARCHAR2(20),
    account_balance NUMBER(10)   
);

CREATE TABLE approved_customer (
    user_name VARCHAR2(20) PRIMARY KEY,
    pass_word VARCHAR2(20),
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    phone_number VARCHAR2(20),
    customer_id VARCHAR2(20),
    account_balance NUMBER(10)    
);

SELECT * FROM pending_customer;
SELECT * FROM approved_customer;

DROP TABLE pending_customer;
DROP TABLE approved_customer;

commit;

CREATE TABLE customer (
    user_name VARCHAR2(20) PRIMARY KEY,
    pass_word VARCHAR2(20),
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    phone_number VARCHAR2(20),
    customer_id VARCHAR2(20),
    account_balance NUMBER(10),
    status VARCHAR2(9)
);

SELECT * FROM customer;

DROP TABLE customer;




