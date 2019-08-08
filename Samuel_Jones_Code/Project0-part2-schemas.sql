CREATE TABLE pendingaccounts (
    username VARCHAR2(30) PRIMARY KEY,
    password VARCHAR2(30) NOT NULL,
    balance NUMBER(12) NOT NULL,
    firstname VARCHAR2(30) NOT NULL,
    lastname VARCHAR2(30) NOT NULL,
    jointfirst VARCHAR2(30),
    jointlast VARCHAR2(30)
    );
CREATE TABLE approvedaccounts (
    username VARCHAR2(30) PRIMARY KEY,
    password VARCHAR2(30) NOT NULL,
    balance NUMBER(12) NOT NULL,
    firstname VARCHAR2(30) NOT NULL,
    lastname VARCHAR2(30) NOT NULL,
    jointfirst VARCHAR2(30),
    jointlast VARCHAR2(30)
    );
    
    SELECT * FROM pendingaccounts;
    
    
    