-- SQL LAB HOMEWORK

-- 2.0 SQL QUERIES

-- 2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
SELECT * FROM Album;
SELECT * FROM Album ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM customer ORDER BY CITY;

-- 2.3 INSERT INTO
SELECT * FROM Genre;
INSERT INTO GENRE VALUES(26, 'Future Soul');
INSERT INTO GENRE VALUES(27, 'Smooth Melondies');
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES(9, 'Rick', 'Jared');
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES(10, 'JT', 'Barret');
INSERT INTO Customer (customerid, firstname, lastname, email) VALUES(60, 'Baker', 'Tim', 'you@email.com');
INSERT INTO Customer (customerid, firstname, lastname, email) VALUES(61, 'Gavin', 'Blatch', 'me@email.com');


-- 2.4 UPDATE
UPDATE Customer
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE artist
SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
SELECT * FROM invoice WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
SELECT * FROM invoice WHERE TOTAL BETWEEN 15 AND 30;
SELECT * FROM employee WHERE HIREDATE BETWEEN TO_DATE('2003-06-01', 'yyyy-mm-dd') AND TO_DATE('2004-03-01', 'yyyy-mm-dd');

-- 2.7 DELETE
ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE;
ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) 
    REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
DELETE FROM customer WHERE FIRSTNAME = 'Robert' and LASTNAME = 'Walter';


-- 3.0 SQL FUNCTIONS 

-- 3.1 System Defined Functions
CREATE OR REPLACE FUNCTION getTime RETURN TIMESTAMP IS
BEGIN 
RETURN sysdate; 
END;
/
DECLARE
    today TIMESTAMP;
BEGIN
    today := getTime;
    dbms_output.put_line(today);
END;
/

CREATE OR REPLACE FUNCTION getlength(x IN VARCHAR2) 
RETURN INTEGER AS y VARCHAR2(200);
BEGIN 
    y := LENGTH(x);
    RETURN y;
END;
/
SELECT getlength(NAME) FROM mediatype;

-- 3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION my_avg
RETURN NUMBER AS x NUMBER;
BEGIN 
    SELECT AVG(total) INTO x FROM invoice;
    RETURN x;
END;
/
SELECT my_avg FROM dual;

CREATE OR REPLACE FUNCTION my_max
RETURN NUMBER AS x NUMBER (10, 2);
BEGIN 
    SELECT MAX(unitprice) INTO x FROM track;
    RETURN x;
END;
/
SELECT my_max FROM dual;

-- 3.3 User Defined Scalar Funtions
CREATE OR REPLACE FUNCTION my_other_avg
RETURN NUMBER AS x NUMBER;
BEGIN 
    SELECT AVG(unitprice) INTO x FROM invoiceline;
    RETURN x;
END;
/
SELECT my_other_avg FROM dual;

-- 3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION bornafter(x date)
RETURN sys_refcursor is refcur sys_refcursor;
BEGIN
    OPEN refcur FOR 'select firstname, lastname from employee 
    where birthdate >= :x' USING x;
    RETURN refcur;
END;
/

DECLARE 
x date;
fn employee.firstname%type;
ln employee.lastname%type;
returncur sys_refcursor;
BEGIN
x := to_date('1968', 'yyyy');
SELECT bornafter(x) INTO returncur FROM dual;
dbms_output.put_line('here');
    LOOP
        FETCH returncur INTO fn, ln;
        EXIT WHEN returncur%notfound;
        DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
    END LOOP;
END;
/


-- 4.0 Stored Procedures

-- 4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE getemployeename(s out sys_refcursor)
AS BEGIN
 OPEN s FOR SELECT firstname, lastname FROM employee;
END;
/
DECLARE
    s sys_refcursor;
    fn employee.firstname%type;
    ln employee.lastname%type;
BEGIN 
    getemployeename(s);
    LOOP 
        FETCH s INTO fn, ln;
        EXIT WHEN s%notfound;
        dbms_output.put_line(fn || ', ' || ln);
    END LOOP;
    CLOSE s;
END;
/
-- 4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE updatepersonalemployee(newemail IN VARCHAR2, employeeid IN NUMBER)
AS BEGIN
    UPDATE employee SET email = newemail WHERE employeeid = employee.employeeid;
END;
/
SELECT firstname, lastname, email FROM employee WHERE employeeid = 7;
BEGIN
    updatepersonalemployee('random@email.com', 7);
END;
/

CREATE OR REPLACE PROCEDURE managedby(s out sys_refcursor, inemployeeid IN NUMBER)
AS BEGIN 
    OPEN s FOR SELECT emp.employeeid, emp.firstname, emp.lastname 
    FROM employee e JOIN employee emp ON e.reportsto = emp.employeeid 
    WHERE e.employeeid = inemployeeid; 
END;
/
DECLARE
    s sys_refcursor;
    fn employee.firstname%type;
    ln employee.lastname%type;
    employeeid employee.employeeid%type;
    inemployeeid number;
BEGIN 
    inemployeeid := 2;
    managedby(s, inemployeeid);
    LOOP 
        FETCH s INTO employeeid, fn, ln;
        EXIT WHEN s%notfound;
        dbms_output.put_line(employeeid || ', ' || fn || ', ' || ln);
    END LOOP;
    CLOSE s;
END;
/
-- 4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE getcompname(compname OUT VARCHAR2, fn OUT VARCHAR2, ln OUT VARCHAR2, cid IN NUMBER)
AS BEGIN
    SELECT company INTO compname FROM customer WHERE customerid = cid;
    SELECT firstname INTO fn FROM customer WHERE customerid = cid;
    SELECT lastname INTO ln FROM customer WHERE customerid = cid;
END;
/
DECLARE
    cname VARCHAR2(200);
    nf VARCHAR2(200);
    nl VARCHAR2(200);
    cid NUMBER;
BEGIN
    cid := 5;
    getcompname(cname, nf, nl, cid);
    dbms_output.put_line(cname || ' ' || nf || ' ' || nl);
END;
/

-- 5.0 Transactions
BEGIN
    DELETE FROM INVOICELine WHERE invoiceid = 21;
    DELETE FROM invoice WHERE invoiceid = 21;
END;
/
SELECT * FROM invoice;

CREATE OR REPLACE PROCEDURE insertcust(cid IN NUMBER, fn IN VARCHAR, ln IN VARCHAR, email IN VARCHAR2)
AS BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email) 
        VALUES(cid, fn, ln, email);
END;
/
BEGIN
insertcust(61, 'jack', 'reidy', 'myemail@gmail.com');
END;
/
SELECT * FROM customer WHERE customerid = 61;


-- 6.0 Triggers

-- 6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER trigger_1
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('Trigger Happened');
END;
/

CREATE OR REPLACE TRIGGER trigger_2
AFTER UPDATE ON album 
BEGIN
    DBMS_output.put_line('Trigger On Update');
END;
/

CREATE OR REPLACE TRIGGER trigger_3
AFTER DELETE ON customer 
BEGIN
    DBMS_output.put_line('Trigger Happened');
END;
/


-- 7.0 JOINS

-- 7.1 INNER
SELECT * FROM customer cust INNER JOIN 
invoice x on cust.customerid = x.customerid;

-- 7.2 OUTER
SELECT c.firstname, c.lastname, i.invoiceid, i.total 
FROM customer c LEFT OUTER JOIN invoice i ON c.customerid = i.customerid;

-- 7.3 RIGHT
SELECT art.name, al.title 
FROM artist art RIGHT JOIN album al ON art.artistid = al.artistid;

-- 7.4 CROSS
SELECT art.name FROM artist art 
CROSS JOIN album al WHERE art.artistid = al.artistid ORDER BY art.name;

-- 7.5 SELF
SELECT * FROM employee e JOIN employee emp on emp.reportsto = e.employeeid;