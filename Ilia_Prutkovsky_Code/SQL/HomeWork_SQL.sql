/*2.1 SELECT
    Task – Select all records from the Employee table.
    Task – Select all records from the Employee table where last name is King.
    Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
 SELECT * FROM employee;
 SELECT * FROM employee WHERE LastName = 'King';
 SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto = 'NULL';
 
 /* 2.2 ORDER BY
    Task – Select all albums in Album table and sort result set in descending order by title.
    Task – Select first name from Customer and sort result set in ascending order by city
*/

SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;

/* 2.3 INSERT INTO
    Task – Insert two new records into Genre table
    Task – Insert two new records into Employee table
    Task – Insert two new records into Customer table
*/

INSERT INTO genre VALUES (26, 'cool');
INSERT INTO genre VALUES (27, 'Classic Trance');

/* 2.4 UPDATE
    Task – Update Aaron Mitchell in Customer table to Robert Walter
    Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE customerid = 32;
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

/* 2.5 LIKE
    Task – Select all invoices with a billing address like “T%”
*/

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

/* 2.6 BETWEEN
    Task – Select all invoices that have a total between 15 and 50
    Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE ('01-JUN-2003') AND ('01-MAR-2004');

/* 2.7 DELETE
    Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/

DELETE customer WHERE firstname = 'Robert' AND lastname = 'Walter';

/* 3.1 System Defined Functions
    Task – Create a function that returns the current time.
    Task – Create a function that returns the length of a mediatype from the mediatype table
*/
CREATE OR REPLACE FUNCTION currTime
RETURN VARCHAR2
IS
   cur_time VARCHAR2(10);
BEGIN
   SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS') INTO cur_time FROM DUAL;
   return cur_time;
END;

DECLARE cur_time VARCHAR2(10);
BEGIN
   cur_time := currTime();
   DBMS_OUTPUT.PUT_LINE('Current time: ' || cur_time);
END;
---

CREATE OR REPLACE FUNCTION medlength
RETURN VARCHAR2
IS
   med_len VARCHAR2(10);
BEGIN
   SELECT MAX(VSIZE(NAME)) INTO med_len FROM mediatype;
   return med_len;
END;

DECLARE med_len VARCHAR2(10);
BEGIN
   med_len := medlength;
   DBMS_OUTPUT.PUT_LINE('Length: ' || med_len);
END;
/* 3.2 System Defined Aggregate Functions
    Task – Create a function that returns the average total of all invoices
    Task – Create a function that returns the most expensive track
*/

CREATE OR REPLACE FUNCTION avglen
RETURN NUMBER
IS
  average NUMBER(10);
BEGIN
   SELECT AVG(invoiceid) INTO average FROM invoice;
   return average;
END;

DECLARE average NUMBER(10);
BEGIN
   average := avglen;
   DBMS_OUTPUT.PUT_LINE('Average: ' || average);
END;

SELECT AVG(invoiceid) FROM invoice;

CREATE OR REPLACE FUNCTION maxprice
RETURN NUMBER
IS
  max_price NUMBER(10);
BEGIN
   SELECT MAX(unitprice) INTO max_price FROM track;
   return max_price;
END;

DECLARE max_price NUMBER(10);
BEGIN
   max_price := maxprice;
   DBMS_OUTPUT.PUT_LINE('Max unit price: ' || max_price);
END;

SELECT MAX(unitprice) FROM track;

/* 3.3 User Defined Scalar Functions
    Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION get_AVG
RETURN NUMBER
IS 
   avg_unit NUMBER(10);
BEGIN
    SELECT AVG(unitprice) INTO avg_unit FROM invoiceline;
    return avg_unit;
END;

DECLARE avg_unit NUMBER(10);
BEGIN
   avg_unit := get_AVG;
    DBMS_OUTPUT.PUT_LINE('AVG unit price: ' || avg_unit);
END;

SELECT AVG(unitprice) FROM invoiceline;

/* 3.4 User Defined Table Valued Functions
    Task – Create a function that returns all employees who are born after 1968
*/
   
SELECT * FROM employee WHERE birthdate > '01-jan-1968';

/* 4.1 Basic Stored Procedure
    Task – Create a stored procedure that selects the first and last names of all the employees
*/

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

/* 4.2 Stored Procedure Input Parameters
    Task – Create a stored procedure that updates the personal information of an employee.
    Task – Create a stored procedure that returns the managers of an employee.
*/

--Task – Create a stored procedure that updates the personal information of an employee.

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

-- Task – Create a stored procedure that returns the managers of an employee.

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

/* 5.0 Transactions
    In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
    Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, 
    find out how to resolve them).
    Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

--
/* 6.1 AFTER/FOR
    Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
    Task – Create an after update trigger on the album table that fires after a row is inserted in the table
    Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE TRIGGER emp_trigger1
BEFORE INSERT ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('New employee added');
end;
INSERT INTO employee (employeeid, firstname,lastname) VALUES(1337,'John','Jones');

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE or REPLACE TRIGGER emp_trigger3
BEFORE UPDATE ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('Employee UPDATED');
END;

UPDATE employee SET FirstName='John' WHERE employeeid = 1337;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE or REPLACE TRIGGER emp_trigger2
BEFORE DELETE ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('Employee deleted');
end;
DELETE FROM employee where employeeid=1337;

-----

/* 7.1 INNER
    Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT customer.firstname, customer.lastname, invoice.invoiceid FROM customer INNER JOIN invoice 
ON customer.customerid = invoice.invoiceid;

/* 7.2 OUTER
    Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, 
    invoiceId, and total.
*/

SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer 
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

/* 7.3 RIGHT
    Task – Create a right join that joins album and artist specifying artist name and title.
*/

SELECT artist.name, album.title FROM artist RIGHT JOIN album ON artist.ARTISTID = album.artistid;

/* 7.4 CROSS
    Task – Create a cross join that joins album and artist and sorts by artist name in ascending order
*/

SELECT artist.name FROM artist CROSS JOIN album ORDER BY artist.name asc;

/* 7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/

SELECT * FROM employee e1, employee e2 WHERE e1.reportsto = e2.reportsto;