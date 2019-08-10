--2.1 Task – Select all records from the Employee table.
SELECT * FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew';

--SELECT * FROM employee WHERE firstName = 'Andrew' AND reportsto = NULL;

--2.2 Task – Select all records from the Employee table where last name is King.
SELECT * FROM album ORDER BY title DESC;

SELECT firstname, city FROM customer ORDER BY city ASC;

--2.3 Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM genre;
INSERT INTO genre VALUES (26, 'DannyRock');
INSERT INTO genre VALUES (27, 'AmonRock');

--Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'Wayne', 'Bruce', 'Batman', null, '01-FEB-88', '01-SEP-89', '11100 Wayne Manor, Ave', 'Gotham', 'TX', 'USA', 77543, '+1 (333) 384-8483', '+1 (333) 384-2223', 'batman@night,com');
INSERT INTO employee VALUES (10, 'Wayne', 'John', 'Cowboy', 9, '03-FEB-88', '11-SEP-89', '11199 Bebop Dr', 'Austin', 'TX', 'USA', 77999, '+1 (000) 384-0983', '+1 (003) 384-2203', 'steakdinner@cowboys.com');

--Task – Insert two new records into Customer table
SELECT * FROM customer;
INSERT INTO customer VALUES (60, 'Bobby', 'Jones', null, '100 99 Apples', 'Apple City', 'TX', 'USA', '83930', '999 88 84 33 99', null, 'bobbyjones@applepie.com', 3); 
INSERT INTO customer VALUES (61, 'Cherry', 'Pie', null, '99 Angels Lane', 'Pie City', 'CA', 'USA', '22930', '999 88 84 44 99', null, 'cherrypie@blueberry.com', 4); 

--2.4 Task – Update Aaron Mitchell in Customer table to Robert Walter
--SELECT * FROM customer WHERE firstname = 'Aaron';
--SELECT * FROM customer WHERE customerid = 32;
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'  WHERE customerid = 32;
--ROLLBACK;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT * FROM artist WHERE name = 'Creedence Clearwater Revival';
UPDATE artist SET name = 'CCR' WHERE artistid = 76;
SELECT * FROM artist WHERE artistid = 76;

--2.5 Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--2.7 Task – Select all employees hired between 1s​ t​ of June 2003 and 1s​ t​ of March 2004
/*SELECT * FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
ROLLBACK;
SELECT * FROM customer WHERE customerid = 32;
*/
DELETE FROM customer WHERE customerid = 32;
--BEGIN;
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoiceLine DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerID_Cascade
FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;

--3.1 Task – Create a function that returns the current time.
SELECT
 CURRENT_TIMESTAMP
FROM
 dual;
 
--3.1 Task – Create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;
    
--3.2 Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;

--3.2 Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;

--3.3 Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_r
RETURN NUMBER IS avg_number NUMBER(6);
BEGIN
SELECT ROUND(AVG(unitprice), 0) INTO avg_number FROM invoiceline;
RETURN avg_number;
END;
/

--3.4 Task – Create a user function that returns all employees who are born after 1968.
SELECT * FROM employee WHERE birthdate >= DATE '1969-01-01';


--4.1 Task – Create a stored procedure that selects the first and last names of all the employees.
/*CREATE OR REPLACE PROCEDURE find_first_last_name
IS
BEGIN
    SELECT firstname, lastname FROM employee;
END;

CREATE OR REPLACE PROCEDURE 
*/

CREATE OR REPLACE PROCEDURE get_employees(names IN SYS_REFCURSOR)
IS
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;
BEGIN
    LOOP
    FETCH names INTO firstname,lastname;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    END LOOP;
    CLOSE names;
END get_employees;
/
DECLARE
    names SYS_REFCURSOR;    
BEGIN
   OPEN names FOR SELECT firstname, lastname FROM employee;
    
    get_employees(names);
END;
/

--4.2 Task – Create a stored procedure that updates the personal information of an employee.
--SELECT * FROM employee WHERE firstname = 'Andrew';

/*CREATE OR REPLACE PROCEDURE update_title
IS BEGIN
UPDATE employee SET city = 'dude' WHERE employeeid = 1;
END;
*/

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

--4.3 Task – Create a stored procedure that returns the managers of an employee.
/*
SELECT * FROM employee WHERE reportsto = 1; 
*/

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

--5.0 Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.1 Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_employee AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have inserted an employee.');
END insert_employee;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER update_album AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have updated an album.');
END update_album;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER delete_customer AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have deleted a customer.');
END delete_customer;

--7.1 Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT invoice.invoiceid, customer.firstname, customer.lastname
FROM invoice
INNER JOIN customer ON invoice.customerid = customer.customerid;

--7.2 Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3 Task – Create a right join that joins album and artist specifying artist name and title.
SELECT album.title, artist.name
FROM album
RIGHT JOIN artist ON album.artistid = artist.artistid;

--7.4 Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT A.lastname AS lastname1, B.lastname AS lastname2, A.reportsto
FROM employee A, employee B
WHERE A.employeeid <> B.employeeid
AND A.reportsto = B.reportsto;

--7.5 Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.lastname "Worker", e2.lastname "Manager"
FROM employee e1 JOIN employee e2
ON e1.reportsto = e2.employeeid;