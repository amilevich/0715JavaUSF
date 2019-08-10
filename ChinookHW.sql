--2.1 SELECT TASKS
SELECT * FROM employee; -- total of 8 employees/records
SELECT * FROM employee WHERE (lastname = 'King');
SELECT * FROM employee WHERE (firstname = 'Andrew' AND reportsto = NULL);

--2.2 ORDER BY
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;

--2.3 INSERT INTO
-- checking how many records: SELECT * FROM GENRE; - total of 25 records
INSERT INTO genre VALUES (26,'Country');
INSERT INTO genre VALUES (27,'Musical Theater');

INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, address, city, state, country, postalcode, phone, fax, email) 
VALUES (9, 'Rozenblum', 'Ella', 'IT Staff', 6, '100 Washington Ave', 'Boston', 'MA', 'USA', '02114', '(617) 555-5555', '(617) 555-5500', 'ella@chinook.com');
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, address, city, state, country, postalcode, phone, fax, email) 
VALUES (10, 'Doe', 'Jane', 'Sales Support Agent', 2, '123 Nowhere Road', 'Tampa', 'FL', 'USA', '33601', '1 (813) 555-1234', '1 (813) 555-1000', 'jane@chinook.com');

--checking Customer records SELECT * FROM customer; -- total of 59 customers/records
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
VALUES(60, 'Eric', 'Smith', 'ME Inc', '100 USA Ave', 'Boston', 'MA', 'USA', '02114', '+1 (617) 555-1213', '+1 (617) 555-3300', 'eric@mande.com', 3);
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
VALUES(61, 'Alyssa','Von Schnitzel', 'Musicals Corp', '100 Massachusetts Ave', 'Boston', 'MA', 'USA', '02107', '+1 (617) 555-8888', '+1 (617) 555-2700', 'alyssa@broadwayinc.com', 4);

--2.4 UPDATE
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE (firstname = 'Aaron' AND lastname = 'Mitchell');
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%'

--2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('06/01/2003', 'mm/dd/yyyy') AND TO_DATE('03/01/2004', 'mm/dd/yyyy');

--2.7 DELETE
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid) REFERENCES customer (customerid)
    ON DELETE CASCADE;
    
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid)
    ON DELETE CASCADE;
    
DELETE FROM customer WHERE (firstname = 'Robert' AND lastname = 'Walter');

SELECT * FROM customer;

--3.1 System Defined Functions
SELECT CURRENT_TIMESTAMP FROM 
dual;

--SELECT * FROM TRACK;
SELECT Milliseconds 
    FROM TRACK;

--3.2 System Defined Aggregate Functions
--SELECT * FROM INVOICE;
SELECT AVG(TOTAL)
FROM INVOICE;

--SELECT * FROM TRACK;
SELECT MAX(UNITPRICE)
FROM TRACK;

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION avgprice
RETURN NUMBER IS
    priced NUMBER(10,2);
BEGIN
    SELECT AVG(unitprice) INTO priced FROM invoiceline;
    RETURN priced;
END avgprice;
/
DECLARE
avgpriced NUMBER := avgprice();
BEGIN
    DBMS_OUTPUT.PUT_LINE('The average price for an invoiceline items is ' || avgpriced);
END;
/
--3.4 User Defined Table Valued Functions
--SELECT * FROM employee WHERE birthdate >= TO_DATE('01/01/1969','MM/DD/YYYY');
--Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE FUNCTION get_names(names IN SYS_REFCURSOR)
RETURN NUMBER IS
employeeid employee.employeeid%TYPE;
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;
BEGIN
    LOOP
    FETCH names INTO employeeid,firstname,lastname;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(employeeid || ' ' || firstname || ' ' || lastname);
    END LOOP;
    CLOSE names;
    RETURN 1;
END get_names;
/
DECLARE
    names SYS_REFCURSOR;
    returned NUMBER;    
BEGIN
   OPEN names FOR SELECT employeeid ,firstname, lastname FROM employee
        WHERE birthdate >= TO_DATE('01/01/1969','MM/DD/YYYY');
    
    SELECT get_names(names) INTO returned FROM DUAL;
END;
/
--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE fl_emp
(
 emp_id IN NUMBER,
 firstname_emp OUT VARCHAR2, 
 lastname_emp OUT VARCHAR2
)
IS
BEGIN
    SELECT firstname, lastname INTO firstname_emp, lastname_emp      
    FROM employee WHERE employeeid = emp_id;
END;
/
--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE personal_info
(pi_employeeid NUMBER, pi_lastname VARCHAR2, pi_firstname VARCHAR2, 
pi_address VARCHAR2, pi_city VARCHAR2,
pi_state VARCHAR2, pi_country VARCHAR2, pi_postalcode VARCHAR2, 
pi_phone VARCHAR2, pi_fax VARCHAR2, pi_email VARCHAR2)
IS
BEGIN
    UPDATE employee 
    SET employee.lastname = pi_lastname,
    employee.firstname = pi_firstname,
    employee.address = pi_address,
    employee.city = pi_city,
    employee.state =pi_state,
    employee.country = pi_country,
    employee.postalcode = pi_postalcode,
    employee.phone = pi_phone,
    employee.fax = pi_fax,
    employee.email = pi_email
    WHERE employee.employeeid = pi_employeeid;
END personal_info;
/     

CREATE OR REPLACE PROCEDURE update_employee 
(
  the_employeeid IN NUMBER,  
  new_firstname IN VARCHAR2,
  new_lastname IN VARCHAR2,
  new_titile IN VARCHAR2,
  new_reportsto IN NUMBER,
  new_birthdate IN DATE,
  new_hiredate IN DATE,
  new_address IN VARCHAR2,
  new_city IN VARCHAR2,
  new_state IN VARCHAR2,
  new_country VARCHAR2,
  new_postalcode VARCHAR2,
  new_phone VARCHAR2,
  new_fax VARCHAR2,
  new_email VARCHAR2
)
AS 
BEGIN
  UPDATE employee
  SET lastname = 
        CASE WHEN new_lastname IS NULL
        THEN lastname
        ELSE new_lastname
        END,
      firstname =
        CASE WHEN new_firstname IS NULL
        THEN firstname
        ELSE new_firstname
        END,
      title = new_titile,
      reportsto = new_reportsto,
      birthdate = new_birthdate,
      hiredate = new_hiredate,
      address = new_address,
      city = new_city,
      state = new_state,
      country = new_country,
      postalcode = new_postalcode,
      phone = new_phone,
      fax = new_fax,
      email = new_email
    WHERE employeeid = the_employeeid;
END update_employee;

CREATE OR REPLACE PROCEDURE get_managers(manager SYS_REFCURSOR)
IS
managerid employee.employeeid%TYPE;
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;
BEGIN
    LOOP
    FETCH manager INTO managerid,firstname,lastname;
    EXIT WHEN manager%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(managerid || ' ' || firstname || ' ' || lastname);
    END LOOP;
    CLOSE manager;
END get_managers;
/
DECLARE 
    manager SYS_REFCURSOR;
    pro_employeeid NUMBER := 7;
BEGIN
    OPEN manager FOR 
        SELECT employeeid ,firstname, lastname FROM employee WHERE employeeid = (
            SELECT reportsto from employee WHERE employeeid = pro_employeeid);
    get_managers(manager);
END;
/

CREATE OR REPLACE PROCEDURE mgr_emp
(
  the_employeeid IN NUMBER
)
AS 
  tmp VARCHAR2(20);
  tmp2 VARCHAR2(20);
  tmp3 VARCHAR2(20);
  tmp4 VARCHAR2(20);
BEGIN
  SELECT mgr.firstname, mgr.lastname, emp.firstname, emp.lastname INTO tmp, tmp2, tmp3, tmp4
  FROM employee emp
  LEFT OUTER JOIN employee mgr 
  ON mgr.employeeid = emp.reportsto
  WHERE emp.employeeid = the_employeeid AND mgr.reportsto = mgr.employeeid;
  DBMS_OUTPUT.PUT_LINE(tmp || ' ' || tmp2 || ' IS THE MANAGER OF ' || tmp3 || ' ' || tmp4);
END mgr_emp;

--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE get_customers(pro_customer SYS_REFCURSOR)
IS
firstname customer.firstname%TYPE;
lastname customer.lastname%TYPE;
company customer.company%TYPE;
BEGIN
    LOOP
    FETCH pro_customer INTO firstname,lastname,company;
    EXIT WHEN pro_customer%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname || ' ' || company);
    END LOOP;
    CLOSE pro_customer;
END get_customers;
/
DECLARE 
    pro_customer SYS_REFCURSOR;
    pro_customerid NUMBER := 1;
BEGIN
    OPEN pro_customer FOR 
        SELECT firstname, lastname, company FROM customer WHERE customerid = pro_customerid;
    get_customers(pro_customer);
END;
/

--5.0 Transactions
--THE FK OF INVOICEID HAS ALREADY BEEN ALTERED TO CASCADE ON DELETE
CREATE OR REPLACE PROCEDURE delete_invoice
    pro_id NUMBER;
BEGIN
    SELECT invoiceid INTO pro_id FROM invoiceline WHERE invoicelineid = 110;
    DELETE FROM invoice WHERE invoiceid = pro_id;
END;
/

--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER insert_employee AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have inserted an employee.');
END insert_employee;

CREATE OR REPLACE TRIGGER update_album AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have updated an album.');
END update_album;

CREATE OR REPLACE TRIGGER delete_customer AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have deleted a customer.');
END delete_customer;

--7.1 INNER
SELECT customer.firstname, customer.lastname,invoice.invoiceid
FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2 OUTER
SELECT customer.customerid,customer.firstname, customer.lastname,invoice.invoiceid,invoice.total
FROM customer FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3 RIGHT
SELECT artist.name, album.title
FROM album RIGHT OUTER JOIN artist
ON album.artistid = artist.artistid;

--7.4 CROSS
SELECT title, name
FROM album CROSS JOIN artist
ORDER BY name ASC;

--7.5 SELF
SELECT e1.lastname "Worker", e2.lastname "Manager"
FROM employee e1 JOIN employee e2
ON e1.reportsto = e2.employeeid;