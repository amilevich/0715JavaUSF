create table bank_admin(username varchar2(200) constraint admin_key primary key, pass_word varchar2(100));
create table bank_employee(username varchar2(200) constraint employee_key primary key, pass_word varchar2(100));
CREATE TABLE bank_user(USER_NAME VARCHAR2(100) CONSTRAINT PK_BANK_USERS PRIMARY KEY,PASS_WORD VARCHAR2(100), BALANCE NUMBER(38,2), col CHAR(1) CONSTRAINT cons_atable_col1 CHECK (col1 IN ('1','0')));

--truncate table bank_users;
insert into bank_admin (username, pass_word) values ('admin', 'adminpass');
insert into bank_employee (username, pass_word) values ('JackMa', 'alibaba');

--insert into BANK_USERS (USER_NAME, PASS_WORD, BALANCE) values ('cshoesmith2', 'eouQvN', 97839057.44);

commit;

select * from bank_users;

CREATE OR REPLACE PROCEDURE DEPOSIT_AMOUNT(CUST IN VARCHAR2, VAL IN NUMBER)
IS
BEGIN
    UPDATE bank_user -- TABLE
    SET BALANCE = BALANCE + VAL -- INCREASE BALANCE
    WHERE USER_NAME = CUST; -- DO THIS TO CORRECT USER
END;
/
COMMIT;

CREATE OR REPLACE PROCEDURE WITHDRAW_AMOUNT(CUST IN VARCHAR2, VAL IN NUMBER)
IS
BEGIN
    UPDATE bank_user -- TABLE
    SET BALANCE = BALANCE - VAL -- DECREASE BALANCE
    WHERE USER_NAME = CUST; -- DO THIS TO CORRECT USER
END;
/
COMMIT;

CREATE OR REPLACE PROCEDURE set_approval(CUST IN VARCHAR2, VAL IN NUMBER)
IS
BEGIN
    UPDATE bank_user -- TABLE
    SET BALANCE = BALANCE - VAL -- DECREASE BALANCE
    WHERE USER_NAME = CUST; -- DO THIS TO CORRECT USER
END;
/
COMMIT;

select * from bank_users;