

CREATE TABLE ers_reium_status
(
  reimb_status_id NUMBER(6) NOT NULL,
  reimb_status VARCHAR2(100) NOT NULL,
  PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reium_type
(
  reimb_type_id NUMBER(6) NOT NULL,
  reimb_type VARCHAR2(100) NOT NULL,
  PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles
(
  ers_user_role_id NUMBER(6) NOT NULL,
  user_role VARCHAR2(100) NOT NULL,
  PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ers_users
(
  ers_users_id NUMBER(6) NOT NULL,
  ers_username VARCHAR2(100) NOT NULL,
  ers_password VARCHAR2(100) NOT NULL,
  user_first_name VARCHAR2(100) NOT NULL,
  user_last_name VARCHAR2(100) NOT NULL,
  user_email VARCHAR2(100) NOT NULL,
  ers_user_role_id NUMBER(6) NOT NULL,
  PRIMARY KEY (ers_users_id),
  FOREIGN KEY (ers_user_role_id) REFERENCES ers_user_roles(ers_user_role_id),
  UNIQUE (ers_username),
  UNIQUE (user_email)
);

CREATE TABLE ers_reium
(
  reimb_id NUMBER(6) NOT NULL,
  reim_amount NUMBER(6) NOT NULL,
  reimb_submitted VARCHAR2(100) NOT NULL,
  reimb_resolved VARCHAR2(100) NOT NULL,
  reimb_description VARCHAR2(100) NOT NULL,
  reimb_receipt VARCHAR2(100) NOT NULL,
  reimb_status_id NUMBER(6) NOT NULL,
  reimb_type_id NUMBER(6) NOT NULL,
  ers_users_id NUMBER(6) NOT NULL,
  PRIMARY KEY (reimb_id),
  FOREIGN KEY (reimb_status_id) REFERENCES ers_reium_status(reimb_status_id),
  FOREIGN KEY (reimb_type_id) REFERENCES ers_reium_type(reimb_type_id),
  FOREIGN KEY (ers_users_id) REFERENCES ers_users(ers_users_id)
);

INSERT INTO ers_users VALUES(100, 'dude', 'man', 'john', 'wayne', 'john@wayne.com', 1);
INSERT INTO ers_users VALUES(101, 'babe', 'woo', 'ashley', 'baby', 'ashley@cherrypie.com', 2);
INSERT INTO ers_user_roles VALUES(1, 'Employee');
INSERT INTO ers_user_roles VALUES(2, 'Finance Manager');

COMMIT;

CREATE SEQUENCE ers_reium_seq
    START WITH 101
    INCREMENT BY 1;
/

CREATE TRIGGER ers_reium_seq_trigger
BEFORE INSERT ON ers_reium
FOR EACH ROW
BEGIN 
    IF :new.reimb_id IS NOT NULL THEN
    SELECT ers_reium_seq.nextval INTO :new.reimb_id FROM dual;
    END IF;
END;
/

INSERT INTO ers_reium_status VALUES(3, 'pending');

CREATE SEQUENCE ers_status_seq
    START WITH 201
    INCREMENT BY 1;
/

CREATE TRIGGER ers_status_seq_trigger
BEFORE INSERT ON ers_reium_status
FOR EACH ROW
BEGIN 
    IF :new.reimb_status_id IS NOT NULL THEN
    SELECT ers_status_seq.nextval INTO :new.reimb_status_id FROM dual;
    END IF;
END;
/

CREATE SEQUENCE ers_type_seq
    START WITH 301
    INCREMENT BY 1;
/

CREATE TRIGGER ers_type_seq_trigger
BEFORE INSERT ON ers_reium_type
FOR EACH ROW
BEGIN 
    IF :new.reimb_type_id IS NOT NULL THEN
    SELECT ers_type_seq.nextval INTO :new.reimb_type_id FROM dual;
    END IF;
END;
/
