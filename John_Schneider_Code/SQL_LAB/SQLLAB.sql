--2.1:
SELECT * FROM Employee;
SELECT * FROM Employee WHERE LastName = 'King';
SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportsTo is NULL;

--2.2:
SELECT * FROM Album ORDER BY(title) DESC;
SELECT FirstName FROM Customer ORDER BY(City);

--2.3:
INSERT INTO Genre VALUES(123, 'Genre-123');
INSERT INTO Genre VALUES(321, 'Genre-321');

INSERT INTO Employee VALUES(123, 'firstname12', 'lastname3', null,null,null,null,null,null,null,null,null,null,null,null);
INSERT INTO Employee VALUES(321, 'firstname32', 'lastname1', null,null,null,null,null,null,null,null,null,null,null,null);

INSERT INTO Customer (CustomerId, FirstName, LastName, Email) VALUES(123, 'firstname123', 'lastname123', 'koolcat@aol.com');
INSERT INTO Customer (CustomerId, FirstName, LastName, Email) VALUES(321, 'firstname321', 'lastname321', '3fast5u@hotmail.com');

--2.4:
UPDATE Customer SET FirstName='Robert', LastName='Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5:
SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

--2.6:
SELECT * FROM Invoice WHERE total > 15 AND total < 50;
SELECT * FROM Employee WHERE HireDate > TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND HireDate < TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss')

--2.7:
DELETE FROM InvoiceLine WHERE invoiceid=342 OR invoiceid=50 OR invoiceid=61 OR invoiceid=116 OR invoiceid=245
OR invoiceid=268 OR invoiceid=290;
DELETE FROM Invoice WHERE CustomerId=32;
DELETE FROM Customer WHERE firstname='Robert' AND lastname='Walter';
SELECT * FROM Customer;

--3.1:
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS
    current_date VARCHAR2(50);
BEGIN
    SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') INTO current_date FROM dual;
    RETURN current_date;
END;
/

CREATE OR REPLACE FUNCTION get_mediatype_length(media_type_id NUMBER)
RETURN NUMBER
IS
    mediatype_length NUMBER(35);
BEGIN
    SELECT SUM(Milliseconds) INTO mediatype_length FROM Track WHERE MediaTypeId = media_type_id;
    RETURN mediatype_length;
END;
/

--3.2:
CREATE OR REPLACE FUNCTION avg_invoice_total
RETURN NUMBER
IS
    avg_total NUMBER(10,2);
BEGIN
    SELECT AVG(Total) INTO avg_total FROM Invoice;
    RETURN avg_total;
END;
/

CREATE OR REPLACE FUNCTION get_most_expensive_track
RETURN NUMBER
IS
    most_expensive NUMBER(10);
BEGIN
    SELECT MAX(UnitPrice) INTO most_expensive FROM Track;
    RETURN most_expensive;
END;
/

--3.3:
CREATE OR REPLACE FUNCTION avg_invoiceline_price
RETURN NUMBER
IS
    avg_price Number(10,2);
BEGIN
    SELECT AVG(UnitPrice) INTO avg_price FROM InvoiceLine;
    RETURN avg_price;
END;
/

--3.4:
CREATE OR REPLACE TYPE employee_row AS OBJECT(
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/
CREATE OR REPLACE TYPE employee_table IS TABLE OF employee_row;
/

CREATE OR REPLACE FUNCTION employee_68
RETURN employee_table PIPELINED
IS
BEGIN
    FOR i IN(SELECT * FROM Employee WHERE BirthDate > TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss')) loop
        PIPE ROW(employee_row(i.employeeid, i.lastname, i.firstname, i.title, i.reportsto, i.birthdate, i.hiredate,
                i.address, i.city, i.state, i.country, i.postalcode, i.phone, i.fax, i.email));
    END LOOP;
    RETURN;
END;
/

--4.1:
CREATE OR REPLACE PROCEDURE first_last_name
AS
BEGIN
    FOR name IN (SELECT firstname, lastname FROM Employee) loop
        DBMS_OUTPUT.PUT_LINE('first name: ' || name.firstname);
        DBMS_OUTPUT.PUT_LINE('last name: ' || name.lastname);
    END LOOP;
END;
/

--4.2:

CREATE OR REPLACE PROCEDURE update_info
( empId IN NUMBER, new_phone IN VARCHAR2, new_email IN VARCHAR2 )
IS
BEGIN
    UPDATE Employee SET Phone = new_phone, Email = new_email WHERE EmployeeId = empId;
END;
/

CREATE OR REPLACE PROCEDURE get_managers ( empId IN NUMBER, mngr OUT VARCHAR2 )
IS
BEGIN
    SELECT firstname INTO mngr FROM Employee WHERE EmployeeId = (SELECT ReportsTo FROM Employee WHERE EmployeeId = empId);
END;
/

DECLARE mngr VARCHAR(25);
BEGIN
    get_managers(6,mngr);
    DBMS_OUTPUT.PUT_LINE(mngr);
END;
/ 

--4.3:
CREATE OR REPLACE PROCEDURE customer_name_company (cid IN NUMBER, cname OUT VARCHAR2, ccompany OUT VARCHAR2)
IS
BEGIN
    SELECT FirstName INTO cname FROM Customer WHERE CustomerId = cid;
    SELECT Company INTO ccompany FROM Customer WHERE CustomerId = cid;
END;
/

--5.0:
CREATE OR REPLACE PROCEDURE delete_invoice (inid IN NUMBER)
IS
BEGIN
    DELETE FROM Invoice WHERE invoiceid = inid;
END;
/

CREATE OR REPLACE PROCEDURE insert_a_customer (cid IN NUMBER, cfname IN VARCHAR2, clname IN VARCHAR2, clemail IN VARCHAR2)
IS
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Email) VALUES(cid, cfname, clname, clemail);
END;
/

--6.1:
CREATE TRIGGER employee_trigger
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Employee inserted.');
END;
/

CREATE TRIGGER album_trigger
BEFORE INSERT ON Album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Album inserted.');
END;
/

CREATE TRIGGER customer_trigger
BEFORE INSERT ON Customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Customer inserted.');
END;
/

--7.1:
SELECT Customer.firstname, Invoice.InvoiceId FROM Customer INNER JOIN Invoice ON Customer.customerid = Invoice.customerid;

SELECT Customer.customerid, Customer.firstname, Customer.lastname, Invoice.InvoiceId, Invoice.total FROM Customer FULL OUTER JOIN Invoice ON Customer.customerid = Invoice.customerid;

SELECT Artist.name, Album.title FROM Artist RIGHT OUTER JOIN Album ON Artist.artistid = Album.artistid;

SELECT * FROM Album CROSS JOIN Artist ORDER BY Artist.name;

SELECT * FROM Employee a, Employee b WHERE a.reportsto = b.employeeid;