--2.1 SELECT
--Select all records from the Employee table.
SELECT * FROM employee;

--Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname='King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname='Andrew' AND REPORTSTO IS NULL;


--2.2 ORDER BY
--Select all albums in Album table and sort result set in descending order by title.
Select * from album ORDER BY TITLE;

--Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO GENRE VALUES (26,'Melody');
INSERT INTO GENRE VALUES (27,'Classic');

--Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(9,'Linganthan','Niroj','Software Developer',5,'12-DEC-85','4-FEB-2001','Grand Prairie','Dallas','TX','USA','554445','4552552','6763737','niroj1285@gmail.com');
INSERT INTO EMPLOYEE VALUES(10,'Kumaran','Ram','Engineer',4,'12-DEC-85','16-Aug-2001','Grand Prairie','Dallas','TX','USA','554445','4552552','6763737','niroj1285@gmail.com');

--Insert two new records into Customer table
INSERT INTO customer VALUES(60,'Niroj','Linganathan','Revature','East Fowler rd','Tampa','FL','USA','133242','+163773727','45551552','niroj@gmail.com',4);
INSERT INTO customer VALUES(61,'Kumaran','Murugan','Revature','East way rd','Phoneix','AR','USA','133242','+163773727','45551552','Murugan@gmail.com',4);

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname='Robert' , lastname='Walter' WHERE customerid=32;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

--2.5 LIKE
--Select all invoices with a billing address like “T%”
SELECT * FROM invoice  WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
-– Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
 SELECT *
FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice
ADD CONSTRAINT fk_invoicecustomerid
FOREIGN KEY (customerid) REFERENCES customer (customerid) ON DELETE CASCADE;
ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE;
DELETE
FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
--3.1 System Defined Functions
--Create a function that returns the current time.	
select CURRENT_TIMESTAMP
from dual;
--Create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH (name)FROM mediatype;

--System Defined Aggregate Functions
--Create a function that returns the average total of all invoices
SELECT AVG(total) FROM INVOICE;
--Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;

--User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price
RETURN NUMBER
IS
    average_price NUMBER(6); 
BEGIN
    SELECT AVG(unitprice) INTO average_price FROM invoiceline;
    RETURN average_price;
END;
/

DECLARE average_price NUMBER;
BEGIN
    average_price := avg_price();
    DBMS_OUTPUT.PUT_LINE('Average Price Of Invoiceline ' || avg_price);
END;
/

--User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION BirthYear (
    birthyear INT
)
RETURN TABLE 
AS
RETURN
    SELECT * FROM employee  WHERE birthday>'31-DEC-1968';
    END;
       
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE empprocedure
IS
BEGIN
    SELECT firstname,lastname FROM employee;
    
END;
/

EXEC empprocedure;

--4.2 Stored Procedure Input Parameters
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmp(
    eid IN employee.employeeid%TYPE,
	  lname IN employee.lastname%TYPE,
	   fname IN employee.firstname%TYPE)
IS
BEGIN

  UPDATE employee SET firstname = fname, lastname=lname where employeeid=eid;

END;
/

BEGIN
   updateemp(10,'rajan','Murugan');
END;
--Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager(
eid IN employee.employeeid%TYPE)
   IS
   manager NUMBER(6);
   managername VARCHAR2();
   BEGIN
   SELECT reportsto INTO manager FROM employee where employeeid=eid;
   DBMS_OUTPUT.PUT_LINE(manager);
   END;
   /
--4.3Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE returnNameCompany (inp_custid IN customer.customerid % TYPE,
   custfirstN OUT customer.firstname % TYPE, custlastN OUT customer.lastname%TYPE,
   custCO OUT customer.company % TYPE) AS
BEGIN
   SELECT firstname, lastname, company
   INTO custfirstN, custLastN, custCO
   FROM customer
   WHERE customerid = inputCustid;
END;
/
DECLARE
   custFirstN customer.firstname % TYPE;
   custLastN customer.lastname % TYPE;
   custCO customer.company % TYPE;
BEGIN
   returnNameCompany(4, custFirstN, custLastN, custCO);
   DBMS_OUTPUT.PUT_LINE('First name: ' || custFirstN || ', Last name: ' || custLastN || 'Company: ' || custCO);
END;
/
--Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace function deleteInvo(invoice_id_input int)

returns void as $$

begin

	delete from invoice where invoiceid = invoice_id_input;

end;

$$ language plpgsql;



alter table invoiceline

drop constraint fk_invoicelineinvoiceid;



alter table invoiceline

add constraint fk_invoicelineinvoiceid

foreign key (invoiceid) references invoice (invoiceid) on delete cascade on update cascade;

select deleteInvoice(390);

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace function newcustomer(customeridinput int, firstnameinput varchar, lastnameinput varchar, companyinput varchar, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar, supportrepidinput int)

returns void as $$

begin

    insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 

        values (customeridinput, firstnameinput, lastnameinput, companyinput, addressinput, cityinput, stateinput, countryinput, postalcodeinput, phoneinput, faxinput, emailinput, supportrepidinput);

end;

$$ language plpgsql;



select newcustomer(26, 'Niroj'::varchar, 'Linganathan'::varchar, 'Yahoo'::varchar, '2424 East Fowler'::varchar, 'Tampa'::varchar, 'FL'::varchar, 'USA'::varchar, '526622'::varchar, '+1 5762766'::varchar, '+1 52176276'::varchar, 'niroj@gmail.com'::varchar, 2);


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

create trigger insertemp

    after insert on employee

    for each row

    execute procedure example_function();
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create trigger updatecus

    after update on customer

    for each row

    execute procedure example_function();
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create trigger deletecus

    after delete on customer

    for each row

    execute procedure example_function();

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname,lastname,invoiceid FROM customer INNER JOIN invoice ON customer.customerid=invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid,firstname,lastname,invoiceid,total FROM customer INNER JOIN invoice ON customer.customerid=invoice.customerid ORDER BY customer.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name ,title FROM album RIGHT JOIN artist ON album.artistid=artist.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select name as artist, title as album from artist 
cross join album where artist.artistid = album.artistid 
order by artist.name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e1, employee e2
WHERE e1.reportsto=e2.reportsto;

