CREATE TABLE pendingaccounts (
    username VARCHAR2(30) PRIMARY KEY, AUTO INCREMENT,
    pw VARCHAR2(30) NOT NULL,
    balance NUMBER(12) NOT NULL,
    firstname VARCHAR2(30) NOT NULL,
    lastname VARCHAR2(30) NOT NULL,
    jointfirst VARCHAR2(30),
    jointlast VARCHAR2(30)
    );
CREATE TABLE approvedaccounts (
    username VARCHAR2(30) PRIMARY KEY, AUTO INCREMENT,
    password VARCHAR2(30) NOT NULL,
    balance NUMBER(12) NOT NULL,
    firstname VARCHAR2(30) NOT NULL,
    lastname VARCHAR2(30) NOT NULL,
    jointfirst VARCHAR2(30),
    jointlast VARCHAR2(30)
    );
--   DROP TABLE pendingaccounts;
--   DROP TABLE approvedaccounts;
--    SELECT * FROM pendingaccounts;
    
    
    