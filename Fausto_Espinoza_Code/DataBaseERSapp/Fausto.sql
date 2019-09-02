DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;
DROP TABLE ers_users;
DROP TABLE ers_reimbursement;


CREATE TABLE ers_reimbursement_status(
    reimb_status_id NUMBER NOT NULL,
    reimb_status VARCHAR2(10) NOT NULL,
    CONSTRAINT reimb_status_pk_pk PRIMARY KEY(reimb_status_id)
);

DROP TRIGGER ers_reimbs_status_trigger;
DROP SEQUENCE ers_reimbursement_status_seq;

CREATE SEQUENCE ers_reimbursement_status_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_reimbs_status_trigger
BEFORE INSERT ON ers_reimbursement_status
FOR EACH ROW 
BEGIN
    IF :new.reimb_status_id IS NULL THEN
        SELECT ers_reimbursement_status_seq.nextval
        INTO :new.reimb_status_id
        FROM dual;
    END IF;
END;

CREATE TABLE ers_reimbursement_type(
    reimb_type_id NUMBER NOT NULL,
    reimb_type VARCHAR2(200) NOT NULL,
    CONSTRAINT reimb_type_pk PRIMARY KEY(reimb_type_id)
);

drop trigger ers_reimbs_type_trigger;
drop sequence ers_reimbursement_type_seq;
drop table ers_reimbursement_type;

CREATE SEQUENCE ers_reimbursement_type_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_reimbs_type_trigger
BEFORE INSERT ON ers_reimbursement_type
FOR EACH ROW 
BEGIN
    IF :new.reimb_type_id IS NULL THEN
        SELECT ers_reimbursement_type_seq.nextval
        INTO :new.reimb_type_id
        FROM dual;
    END IF;
END;

CREATE TABLE ers_user_roles(
    ers_user_role_id NUMBER NOT NULL,
    user_role VARCHAR2(10) NOT NULL,
    CONSTRAINT ers_user_roles_pk PRIMARY KEY(ers_user_role_id)
);

delete from ers_user_roles;
commit;

drop TRIGGER ers_reimbs_roles_trigger;
drop SEQUENCE ers_user_roles_seq;

CREATE SEQUENCE ers_user_roles_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_reimbs_roles_trigger
BEFORE INSERT ON ers_user_roles
FOR EACH ROW 
BEGIN
    IF :new.ers_user_role_id IS NULL THEN
        SELECT ers_user_roles_seq.nextval
        INTO :new.ers_user_role_id
        FROM dual;
    END IF;
END;



CREATE TABLE ers_users(
    ers_users_id NUMBER NOT NULL,
    ers_username VARCHAR2(50) NOT NULL,
    ers_password VARCHAR2(200) NOT NULL,
    user_first_name VARCHAR2(100) NOT NULL,
    user_last_name VARCHAR2(100) NOT NULL,
    user_email VARCHAR2(150) NOT NULL,
    user_role_id NUMBER NOT NULL,
    CONSTRAINT ers_users_pk PRIMARY KEY(ers_users_id),
    CONSTRAINT ers_users_unv1 UNIQUE(ers_username, user_email),
    CONSTRAINT user_role_fk FOREIGN KEY (user_role_id) REFERENCES ers_user_roles(ers_user_role_id)    
);

CREATE SEQUENCE ers_users_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_users_trigger
BEFORE INSERT ON ers_users
FOR EACH ROW 
BEGIN
    IF :new.ers_users_id IS NULL THEN
        SELECT ers_users_seq.nextval
        INTO :new.ers_users_id
        FROM dual;
    END IF;
END;

--drop table ers_reimbursement;
drop trigger ers_users_trigger;
drop SEQUENCE ers_users_seq;

CREATE TABLE ers_reimbursement(
    reimb_id NUMBER NOT NULL,
    reimb_amount NUMBER(34,2) NOT NULL,
    reimb_submitted TIMESTAMP NOT NULL,
    reimb_resolved TIMESTAMP NULL,
    reimb_description VARCHAR2(250) NULL,
    reimb_receipt BLOB NULL,
    reimb_autor NUMBER NOT NULL,
    reimb_resolver NULL,
    reimb_status_id NUMBER NOT NULL,
    reimb_type_id NUMBER NOT NULL,
    CONSTRAINT ers_reimbursement_pk PRIMARY KEY(reimb_id), 
    CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_autor) REFERENCES ers_users(ers_users_id),
    CONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users(ers_users_id),
    CONSTRAINT ers_reimbursement_satatus_fk FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
    CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
);

drop trigger ers_reimbursement_trigger;
drop SEQUENCE ers_reimbursement_seq;

CREATE SEQUENCE ers_reimbursement_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_reimbursement_trigger
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW 
BEGIN
    IF :new.reimb_id IS NULL THEN
        SELECT ers_reimbursement_seq.nextval
        INTO :new.reimb_id
        FROM dual;
    END IF;
END;    

--select * from ers_reimbursement_type;
--insert into ers_reimbursement_type values(1,"Loging");


CREATE TABLE email (
    email_id NUMBER NOT NULL,
    email_fromEmail VARCHAR2(200) NOT NULL,
    email_password VARCHAR2(200) NOT NULL,
    email_subject VARCHAR2(100) NOT NULL,
    email_message VARCHAR2(500) NOT NULL,
    CONSTRAINT email_pk PRIMARY KEY(email_id)
);

CREATE SEQUENCE email_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER email_trigger
BEFORE INSERT ON email
FOR EACH ROW 
BEGIN
    IF :new.email_id IS NULL THEN
        SELECT email_seq.nextval
        INTO :new.email_id
        FROM dual;
    END IF;
END; 

--INSERT INTO email VALUES(NULL,'frerespinoza@gmail.com','cnVwZXJ0bzE=',', Welcome to the applicatom ERSapp','You are registered in this application, and we also welcome you. enjoy the system, thanks: don not reply the message.');
--commit;