CONN chinook/p4ssw0rd

-- 2.1 SELECT
--Task – Select all records from the Employee table.
--Select * from Employee;
--Task – Select all records from the Employee table where last name is King.
--select LASTNAME, FIRSTNAME from Employee where LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
--Select * from Employee where firstname = 'Andrew' and reportsto is NULL;

--2.2 ORDER BY

--Task – Select all albums in Album table and sort result set in descending order by title.
--select * from Album order by TITLE desc;
--Task – Select first name from Customer and sort result set in ascending order by city
--select FIRSTNAME, CITY from Customer order by CITY asc;

--2.3 INSERT INTO

--Task – Insert two new records into Genre table
--insert into genre VALUES (29,50);
--insert into genre VALUES (30,51);
--Task – Insert two new records into Employee table
--insert into Employee(EMPLOYEEID, LASTNAME, FIRSTNAME,TITLE, REPORTSTO, BIRTHDATE,HIREDATE, ADDRESS, CITY) values (9, 'Lee', 'James', 'Sales Support Agent', 2, '21-JUN-80', '11-AUG-11', '948 Leigh Avenue SE', 'Toronto');
--insert into Employee(EMPLOYEEID, LASTNAME, FIRSTNAME,TITLE, REPORTSTO, BIRTHDATE,HIREDATE, ADDRESS, CITY) values (10, 'Rowland', 'Zacharias', 'Sales Support Agent', 2, '12-Feb-71', '01-DEC-08', '71 Sunrise Boulevard E', 'Toronto');
--Task – Insert two new records into Customer table
--insert into customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) values (60, 'Johan', 'Schmidt', 'Amazon', 'Ordynacka 10', 'Somewhere in Russia', 'A state', 'Russia', 1203493, 4045559090, 123431, 'anemail@bellsouth.com', 7);
--insert into customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) values (61, 'Steve', 'Rogers', 'Google', 'Ordynacka 10', 'Somewhere in North America', 'A state', 'United States', 493321, 7045559090, 123431, 'anemail@aol.com', 6);

--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
--update customer set FIRSTNAME = 'Robert', LASTNAME = 'Walter' where FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell'; 
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5 LIKE

--Task – Select all invoices with a billing address like “T%”
--SELECT * FROM invoice where billingaddress like 'T%'

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--select * from invoice where total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
--select * from employee where hiredate between '01-JUN-03' and '01-MAR-04'

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).delete from customer
--where firstname = 'Robert' and lastname = 'Walter'

--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--SELECT TO_CHAR(SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW" FROM DUAL; 
--Task – Create a function that returns the length of a mediatype from the mediatype table
--select * from mediatype;
--SELECT LENGTH('MPEG audio file') "Length in characters" FROM DUAL;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--select avg(total) from invoice;
--Task – Create a function that returns the most expensive track
--select max(total) from invoice;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--create or replace function get_invoiceline_average
--return number
--is 
--average number(5);
--begin
--    select avg(unitprice) into average from invoiceline;
--   return average;
--end;
--/
--begin
--DBMS_OUTPUT.PUT_LINE(get_invoiceline_average());
--end;
--/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

--create or replace employees_after_1968 
--  RETURN  employee%rowtype 
--IS
--    emp employee%rowtype;
--BEGIN    
--
--    SELECT * INTO emp FROM employee  WHERE BirthDate > TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss');
--    RETURN emp;
--END;
--/
--BEGIN    --used to check employees_after_1968 function
--    DBMS_OUTPUT.PUT_LINE('employees_after_1968: ' || employees_after_1968() );
--    --SELECT * FROM table(employees_after_1968());
--END;
--/

----4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--create type my_tab_type is object
--(last_name varchar2(15), first_name varchar2(15))
--/
--create type my_tab_type_coll is table of my_tab_type;
--/
--Create or replace function first_and_last_names_procedure(p_val in number) 
--return my_tab_type_coll pipelined is
--begin
--  FOR i in (select lastname, firstname from employee) loop
--    pipe row(my_tab_type(i.lastname,i.firstname));
--  end loop;
--  return;
--end;
--/
--
--SELECT * FROM table(first_and_last_names_procedure(3));

----4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

--CREATE OR REPLACE PROCEDURE get_manager(emp_id IN NUMBER, emp_name OUT VARCHAR2)
--IS man_id NUMBER;
--BEGIN
--    SELECT employeeID INTO man_ID FROM employee WHERE employeeID = emp_id;
--    SELECT CONCAT(CONCAT(Firstname,' '), Lastname) Into emp_name FROM employee WHERE employeeID = man_id;
--END;
--/

--Task – Create a stored procedure that returns the managers of an employee.
--DECLARE result VARCHAR2(20);
--BEGIN
--    get_manager(2,result);
--    DBMS_OUTPUT.PUT_LINE('Manager of employeeID 2: ' || result);
--END;
--/
----4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--create or replace procedure get_name_and_company(cust_id in NUMBER, fName OUT  VARCHAR2, lName OUT  VARCHAR2, cName OUT  VARCHAR2)
--IS
--BEGIN
--    SELECT firstname INTO fName FROM customer WHERE customerid = cust_id;
--    SELECT lastname INTO lName FROM customer WHERE customerid = cust_id;
--    SELECT company INTO cName FROM customer WHERE customerid = cust_id;
--END;
--/
--DECLARE fName VARCHAR2(30); lName VARCHAR2(30); cName VARCHAR2(30);
--BEGIN
--    get_name_and_company(11,fName,lName,cName);
--    DBMS_OUTPUT.PUT_LINE('Name and company: ' ||' '|| fName ||' '||lname ||': '||cName );    
--END;
--/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--7.0 JOINS
--In this section you will be working with combining various tab    les through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--select customer.customerid, invoice.customerid from customer inner join orders on invoice.customerid = customer.customerid;
--select * from invoice;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--SELECT Customers.FirstName, Orders.OrderID FROM Customers FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID ORDER BY Customers.FirstName;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--SELECT ALBUM.TITLE, ARTIST.NAME FROM ALBUM RIGHT OUTER JOIN ARTIST ON ALBUM.TITLE = ARTIST.ARTISTID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
