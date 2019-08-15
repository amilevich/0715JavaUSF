--2.1--
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2--
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

--2.3--
INSERT INTO GENRE VALUES(26,'BRITPOP');
INSERT INTO GENRE VALUES(27,'POPPUNK');
INSERT INTO EMPLOYEE VALUES('9','HELGELAND','NICK','SOFTWARE ENGINEER',7,'29-DEC-94','11-FEB-18','3359 STATE ROUTE 36','JASPER','NY','US','14855','6076615741','NONE','NICKHELGELAND94@GMAIL.COM');
INSERT INTO EMPLOYEE VALUES('10','HECKER','DAN','SOFTWARE ENGINEER',7,'03-MAR-95','11-FEB-18','SOMEWHER','GLASTONBURY','CT','US','XXXXX','123456789','NONE','DAN@COX.NET');
INSERT INTO CUSTOMER VALUES('60','NICK','HELGELAND','REVATURE','3359 STATE ROUTE 36','JASPER','NY','US','14855','6076615741','NONE','NICKHELGELAND94@GMAIL.COM',5);
INSERT INTO CUSTOMER VALUES('61','DAN','HECKER','AETNA','SOMEWHERE','GLASTONBURY','CT','US','XXXXX','123456789','NONE','DAN@COX.COM',1);

--2.4--
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

--2.5--
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6--
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7--
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--3.1--
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
RETURN TIMESTAMP IS
CURRENT_TIME TIMESTAMP;
BEGIN
CURRENT_TIME := LOCALTIMESTAMP;
RETURN CURRENT_TIME;
END;
/
SELECT GET_CURRENT_TIME() FROM DUAL;

CREATE OR REPLACE FUNCTION NAME_LENGTH
(MEDIA_ID NUMBER)
RETURN NUMBER IS 
STRLENGTH NUMBER;
BEGIN
SELECT LENGTH(NAME) INTO STRLENGTH FROM MEDIATYPE WHERE MEDIATYPEID=MEDIA_ID;
RETURN STRLENGTH;
END;
/
SELECT NAME_LENGTH(2) FROM DUAL;

--3.2--
CREATE OR REPLACE FUNCTION TOTAL_AVG
RETURN NUMBER IS
AVERAGE NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO AVERAGE FROM INVOICE;
RETURN AVERAGE;
END;
/
SELECT TOTAL_AVG() FROM DUAL;

CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_PRICE
RETURN VARCHAR2 IS
MAX_TRACK NUMBER;
BEGIN
SELECT MAX(UNITPRICE) INTO MAX_TRACK FROM TRACK;
RETURN MAX_TRACK;
END;
/
SELECT MOST_EXPENSIVE_PRICE() FROM DUAL;

--3.3--
CREATE OR REPLACE FUNCTION AVG_UNITPRICE
RETURN NUMBER IS
AVG_PRICE NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
RETURN AVG_PRICE;
END;
/
SELECT AVG_UNITPRICE() FROM DUAL;

--3.4--
CREATE OR REPLACE FUNCTION YOUNGISH_EMPLOYEES
RETURN SYS_REFCURSOR IS
Y_EMPLOYEES SYS_REFCURSOR;
BEGIN
OPEN Y_EMPLOYEES FOR
SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';
RETURN Y_EMPLOYEES;
END;
/
SELECT YOUNGISH_EMPLOYEES() FROM DUAL;

--4.0--
CREATE OR REPLACE PROCEDURE GET_NAME
AS
FULL_NAMES SYS_REFCURSOR;
BEGIN
OPEN FULL_NAMES FOR
SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
COMMIT;
END;
/
EXECUTE GET_NAME;

--4.2--
CREATE OR REPLACE PROCEDURE UPDATE_INFO(E_ID IN NUMBER, F_NAME IN VARCHAR2, L_NAME IN VARCHAR2, B_DAY IN DATE)
AS
BEGIN
UPDATE EMPLOYEE SET FIRSTNAME=F_NAME, LASTNAME=L_NAME, BIRTHDATE=B_DAY WHERE EMPLOYEEID=E_ID;
COMMIT;
END;
/
EXECUTE UPDATE_INFO(8,'NICK','HELGELAND','29-DEC-94');

CREATE OR REPLACE PROCEDURE GET_MANAGER(E_ID IN NUMBER, MANAGER OUT VARCHAR2)
AS 
BEGIN
SELECT FIRSTNAME INTO MANAGER FROM EMPLOYEE WHERE EMPLOYEEID=(SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID=E_ID);
COMMIT;
END;
/
SET SERVEROUTPUT ON;
DECLARE MANAGER VARCHAR2(20);
BEGIN
GET_MANAGER(6,MANAGER);
dbms_output.put_line(MANAGER);
END;

--4.3--
CREATE OR REPLACE PROCEDURE GET_NAME_AND_COMPANY(C_ID IN NUMBER, F_NAME OUT VARCHAR2, L_NAME OUT VARCHAR2, C_NAME OUT VARCHAR2)
AS
BEGIN
SELECT FIRSTNAME INTO F_NAME FROM CUSTOMER WHERE CUSTOMERID=C_ID;
SELECT LASTNAME INTO L_NAME FROM CUSTOMER WHERE CUSTOMERID=C_ID;
SELECT COMPANY INTO C_NAME FROM CUSTOMER WHERE CUSTOMERID=C_ID;
COMMIT;
END;
/

DECLARE FIRSTNAME VARCHAR2(20);
LASTNAME VARCHAR2(20);
COMPANY VARCHAR2(80);
BEGIN
GET_NAME_AND_COMPANY(10,FIRSTNAME,LASTNAME,COMPANY);
dbms_output.put_line(FIRSTNAME||' '||LASTNAME||' '||COMPANY);
END;

--5.0--
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(I_ID IN NUMBER)
AS
BEGIN
SET TRANSACTION READ WRITE;
DELETE FROM INVOICELINE WHERE INVOICEID=I_ID;
DELETE FROM INVOICE WHERE INVOICEID=I_ID;
COMMIT;
END;
/
EXECUTE DELETE_INVOICE(216);

CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(C_ID IN NUMBER, F_NAME IN VARCHAR2, L_NAME IN VARCHAR2, C_COMPANY IN VARCHAR2, 
C_ADDRESS IN VARCHAR2, C_CITY IN VARCHAR2, C_STATE IN VARCHAR2, C_COUNTRY IN VARCHAR2, C_POSTAL IN VARCHAR2, C_PHONE IN VARCHAR2,
C_FAX IN VARCHAR2, C_EMAIL IN VARCHAR2, C_SID IN NUMBER)
AS 
BEGIN
SET TRANSACTION READ WRITE;
INSERT INTO CUSTOMER VALUES(C_ID, F_NAME, L_NAME, C_COMPANY, C_ADDRESS, C_CITY, C_STATE, C_COUNTRY, C_POSTAL, C_PHONE, C_FAX, C_EMAIL, C_SID);
COMMIT;
END;
/
EXECUTE INSERT_CUSTOMER('62','MICHEAL','SCOTT','DUNDER MIFFLIN','SOMEWHERE','SCRANTON','PA','US','XXXXX','123456789','NONE','MSCOTT@DUNDERMIFFLIN.NET',1);

--6.1--
CREATE OR REPLACE TRIGGER AFTER_INSER_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
--DO SOMETHING--
dbms_output.put_line(:NEW.FIRSTNAME);
END;
/

CREATE OR REPLACE TRIGGER AFTER_UPDATE_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
dbms_output.put_line(:NEW.TITLE);
END;
/
UPDATE ALBUM SET TITLE='BALL TO THE WALL' WHERE TITLE='Balls to the Wall';

CREATE OR REPLACE TRIGGER AFTER_DELETE_TRIGGER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
dbms_output.put_line('ROW DELETED');
END;
/

--7.1--
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

--7.2--
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER LEFT OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

--7.3--
SELECT ARTIST.NAME,ALBUM.TITLE
FROM ALBUM RIGHT OUTER JOIN ARTIST
ON ALBUM.ARTISTID=ARTIST.ARTISTID;

--7.4--
SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

--7.5--
SELECT A.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO=B.REPORTSTO;