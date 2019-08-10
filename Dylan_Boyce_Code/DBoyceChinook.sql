conn chinook/p4ssw0rd

--2.1 SELECT
SELECT * FROM employee;

SELECT * FROM employee WHERE LOWER(lastname) LIKE 'king%';

SELECT * FROM employee 
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
SELECT * FROM album
ORDER BY title DESC;

SELECT firstname FROM customer
ORDER BY CITY;

--2.3 INSERT INTO
SELECT * FROM genre;
INSERT INTO genre VALUES (26,'Ska');
INSERT INTO genre VALUES (27, 'Lo-Fi Jazz-Hop');

SELECT * FROM employee;
INSERT INTO employee(employeeid, lastname, firstname, title) VALUES (9, 'Boyce', 'Dylan', 'Developer');
INSERT INTO employee(employeeid, lastname, firstname) VALUES (10, 'Nico', 'Rivers');

SELECT * FROM customer;
INSERT INTO customer(customerid, firstname, lastname,company,email) VALUES (60,'Sophira', 'Blight', 'Walgreens','some@email.com');
INSERT INTO customer(customerid, firstname, lastname,company,email) VALUES (61,'Dole', 'Tommy', 'Budweiser','dude@email.com');

--2.4 UPDATE
SELECT * FROM customer WHERE LOWER(firstname) LIKE 'a%';
SELECT * FROM customer WHERE LOWER(firstname) LIKE 'r%';

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

SELECT * FROM artist WHERE LOWER(name) LIKE 'creedence%';
SELECT * FROM artist WHERE LOWER(name) LIKE 'cc%';
UPDATE artist SET name = 'CCR'
WHERE artistid = 76;

--2.5 LIKE

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
SELECT*FROM employee;
SELECT * FROM invoice WHERE total BETWEEN 15 and 20;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE   --try deleting references from customer--
SELECT customerid FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter' AND customerid = 32;


--3.0 SQL Functions
--3.1 System Defined Functions

SELECT TO_CHAR (CURRENT_DATE, 'DD-MON-YYY HH:MI:SS') FROM dual;

SELECT LENGTH(name) FROM mediatype WHERE mediatypeid = 1 ;

--3.2 System defined aggregate functions

SELECT AVG(total) FROM invoice;
SELECT * FROM track;  --Missing the 2nd Task     ******NOTICE*****


--3.3 User Defined Scalar Functions
 
SELECT * FROM invoiceline;
SELECT AVG(unitprice) FROM invoiceline;
 
--3.4 User Defined Table Valued Functions

SELECT * FROM employee;

SELECT * FROM employee     --****NOTICE**** This solution is not working
WHERE birthdate > 01-JAN-1968;

--4.0 Stored Procedure
--4.1 Basic Stored Procedures

CREATE OR REPLACE PROCEDURE first_last_procedure  --THis also does not work...WHY?
IS
BEGIN
    SELECT firstname, lastname FROM employee;
END;
/
BEGIN
    first_last_procedure();
END;

EXECUTE first_last_procedure();


--4.2 Stored Procedure Input Parameters

--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE emp_personalinfo_procedure(empid NUMBER, firstName VARCHAR2, lastName VARCHAR2,city VARCHAR2, state VARCHAR2)
IS
BEGIN
    UPDATE employee SET firstname = firstName, lastname = lastName, city = city, state = state
        where employeeid = empid;
        END;
        /
BEGIN
emp_personalinfo_procedure(4, 'Tom' , 'Riddle', 'Cleveland', 'Ohio');
END;

--Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE whos_manager_procedure(empid NUMBER)
IS
BEGIN
    SELECT reportsto FROM employee WHERE empid = employeeid;   --Select statment expects the "INTO" keyword...why?
END;
/
BEGIN
    whos_manager_procedure(6);
End;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE find_Customer(custid NUMBER)
IS
BEGIN
    SELECT firstname, company FROM customer WHERE custid = customerid;  --Same INTO error
END;
/
BEGIN
    find_Customer(8);
END;
/

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).


--6.0 Triggers
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired 
--after a new record is inserted into the table.

CREATE TRIGGER on_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Team Member!');
END;
/
INSERT INTO employee(employeeid, firstname, lastname) VALUES (12, 'Jerhold', 'Rossman');
DELETE FROM employee WHERE employeeid=12;

--Task – Create an after update trigger on the album table that fires
--after a row is inserted in the table
CREATE TRIGGER update_album
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Album Added!');
    END;
    /
UPDATE album SET albumid = 999, title = 'JustAnotherSQL';
DELETE FROM album WHERE albumid=999;

--Task – Create an after delete trigger on the customer table that 
--fires after a row is deleted from the table.
CREATE TRIGGER remove_customer
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer kicked from Store!');
    END;
    /
INSERT INTO customer(customerid, firstname, lastname, email) VALUES (999, 'Leroy', 'Jenkins', 'ivegotchicken@blizzaed.net');
DELETE FROM customer WHERE customerid = 999;

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and 
--specifies the name of the customer and the invoiceId.

SELECT firstname, lastname, invoiceid FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname,
--lastname, invoiceId, and total.

SELECT customer.customerid, firstname, lastname, invoiceid, total FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
--note to Outter joint its written "FULL OUTER JOIN" not "OUTER FULL JOIN"

--7.3 RIGHT
--Task – Create a right join that joins album and artist 
--specifying artist name and title.
SELECT name, title FROM album RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;

--7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts
--by artist name in ascending order.
SELECT * FROM album CROSS JOIN artist ORDER BY artist.name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining
--on the reportsto column.
SELECT * FROM employee a, employee b WHERE a.reportsto = b.reportsto;


