create or replace procedure insert_new_customer(f_name in VARCHAR2, l_name in VARCHAR2, addr in VARCHAR2,
u_name in VARCHAR2, p_word in VARCHAR2)
as
    c_id number(10);
    begin
        select customer_id_seq.nextval into c_id from dual;
        insert into CUSTOMERS values(c_id, f_name, l_name, addr);
        insert into USERS values(u_name,p_word,'customer');
        insert into USER_JUNCTION values(u_name, c_id);
        commit;
    end;
    /

create or replace procedure insert_new_account(c_id in NUMBER)
as
    a_number number(10);
    begin
        select ACCOUNT_ID_SEQ.nextval into a_number from dual;
        insert into ACCOUNTS values(a_number, 0);
        insert into CUSTOMER_ACCOUNTS values(c_id, a_number);
        commit;
    end;
    /

create or replace procedure insert_new_joint_account(primary in NUMBER, secondary in NUMBER)
as
    a_number NUMBER(10);
    begin
        select ACCOUNT_ID_SEQ.nextval into a_number from DUAL;
        insert into ACCOUNTS values(a_number, 0);
        insert into JOINT_ACCOUNTS values(a_number, primary, secondary);
        commit;
    end;
    /

create or replace procedure approve_checking_app(a_id in NUMBER)
as
    c_id NUMBER(10);
    begin
        select CUSTOMER_ID into c_id from CHECKING_APPLICATIONS where app_id = a_id;
        delete from CHECKING_APPLICATIONS where APP_ID = a_id;
        insert_new_account(c_id);
        commit;
    end;
    /

create or replace procedure approve_joint_app(a_id in NUMBER)
as
    primary NUMBER(10);
    secondary NUMBER(10);
    begin
        select PRIMARY_CUSTOMER_ID into primary from JOINT_APPLICATION where APP_ID = a_id;
        select SECONDARY_CUSTOMER_ID into secondary from JOINT_APPLICATION where APP_ID = a_id;
        delete from JOINT_APPLICATION where APP_ID = a_id;
        insert_new_joint_account(primary, secondary);
    end;
    /

create sequence customer_id_seq
start with 1000
increment by 1;
/

create sequence app_id_seq
start with 1000
increment by 1;
/

create sequence account_id_seq
start with 1000
increment by 1;
/

begin
    insert_new_customer('Dan','Hecker','Connecticut','dan','password');
end;
/