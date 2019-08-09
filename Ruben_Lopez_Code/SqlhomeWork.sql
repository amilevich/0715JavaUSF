conn chinook/p4ssw0rd

SELECT * FROM EMPLOYEE;

/*
Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.





SELECT * FROM EMPLOYEE where LASTNAME = 'King';

SELECT * FROM EMPLOYEE where FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;

SELECT * FROM ALBUM ORDER BY ALBUM.TITLE DESC;

/*
Task – Select first name from Customer and sort result set in ascending order by city

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
*/
/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
/*
SELECT * FROM GENRE; 

INSERT INTO GENRE ( GENREID , NAME) 
VALUES ( 26 , 'DRUM N BASS' );

INSERT INTO GENRE ( GENREID , NAME )
VALUES ( 27 , 'HARD TECHNO');

INSERT INTO EMPLOYEE ( EMPLOYEEID , LASTNAME , FIRSTNAME , TITLE )
VALUES ( 9, 'LOPEZ' , 'RUBEN' , 'IT Staff' );

INSERT INTO EMPLOYEE ( EMPLOYEEID , LASTNAME , FIRSTNAME , TITLE )
VALUES ( 10, 'ESPANOZA' , 'GABRIEL' , 'IT Staff' );
*/
--SELECT * FROM CUSTOMER;
/*
INSERT INTO CUSTOMER ( CUSTOMERID , FIRSTNAME , LASTNAME , ADDRESS , EMAIL ) 
VALUES ( 60 , 'Luis' , 'Cardinaz' , '123real st' , 'Luis@hotmail.com' );

INSERT INTO CUSTOMER ( CUSTOMERID , FIRSTNAME , LASTNAME , ADDRESS , EMAIL ) 
VALUES ( 61 , 'TONY' , 'MADENAZ' , 'linem stone 1234' , 'Tony@hotmail.com' );

2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

--UPDATE CUSTOMER SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter'
--where FIRSTNAME='Aaron' and LASTNAME = 'MITCHELL';

--UPDATE ARTIST SET NAME = 'CCR'
--WHERE NAME = 'Creedence Clearwater Revival';
/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”


SELECT * FROM invoice WHERE billingaddress like 'T%';
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004


SELECT * FROM invoice WHERE total between 15 and 50;

SELECT * FROM employee WHERE HIREDATE between '01-JUN-03' and '01-MAR-04';  

2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
--DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' and LASTNAME = 'Walter';

--SELECT CURRENT_DATE FROM dual;

--SELECT LENGTH('CANDIDE') "Length in characters"
--  FROM DUAL;
/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table

*/
--SELECT AVG(UNITPRICE)
--FROM invoiceline;


/*
Task – Create a function that returns all employees who are born after 1968.*/

--SELECT * FROM EMPLOYEE WHERE BIRTHDATE > to_date('20-FEB-68', 'DD-MON-RR'); 
/*
select firstname,lastname from Employee;
DROP PROCEDURE stpr_first_last_emp;
CREATE PROCEDURE stpr_first_last_emp
AS
  c1 SYS_REFCURSOR;  
BEGIN

  open c1 for
  SELECT firstname, firstname
  FROM Employee
    

  DBMS_SQL.RETURN_RESULT(c1);
END;
/
*/
--EXECUTE stpr_first_last_emp();


--select * from firstAndLastNames();

--CREATE OR REPLACE FUNCTION get_max_id
--RETURN NUMBER
--IS
--    table_id NUMBER(6); --define parameter
--BEGIN
--    SELECT MAX(e_id) INTO max_id FROM employees;
--    RETURN max_id;
--END;

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

--4.1)
/*
Task:

CREATE PROCEDURE spGetEmployeeDetails

AS

    SELECT firstname, lastname FROM Employee;

GO

EXEC spGetEmployeeDetails


 

4.2)

Task:

CREATE PROCEDURE  spUpdate EmployeeData

       @employeeId  INT

  AS

    BEGIN

     UPDATE employee 

     SET status='Y' 

     WHERE employee_Code = @employeeID

    END

Exec spUpdate EmployeeData  employee_Id  

Task:

CREATE PROCEDURE spGetManagers

      @employee_ID INT,

   AS

   BEGIN

Select managers  from employee where employee_id=@ employee_id;

   END


 

4.3)

Task:

CREATE PROCEDURE spNameCompanyOutputParameter

      @employee_id INT,

      @result  varchar(50)  OUTPUT

   AS

   BEGIN

  Set result = Select name,country from customer where employeeID= @employeeID ;

   END

create or replace function deleteInvoice(invoice_id_input int)
return void AS
begin
	delete from invoice where invoiceid = invoice_id_input;
end;
/

alter table invoiceline
drop constraint fk_invoicelineinvoiceid;

alter table invoiceline
add constraint fk_invoicelineinvoiceid
foreign key (invoiceid) references invoice (invoiceid) on delete cascade on update cascade;

select deleteInvoice(407);

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace function insertCustomer(customeridinput int, firstnameinput varchar, lastnameinput varchar, companyinput varchar, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar, supportrepidinput int)
returns void as execute
begin
    insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
        values (customeridinput, firstnameinput, lastnameinput, companyinput, addressinput, cityinput, stateinput, countryinput, postalcodeinput, phoneinput, faxinput, emailinput, supportrepidinput);
end;
/

select insertCustomer(63, 'Yost'::varchar2, 'Steph'::varchar2, 'Nappins'::varchar2, '384 5th Ave'::varchar2, 'Tampa'::varchar2, 'FL'::varchar2, 'USA'::varchar2, '61234'::varchar2, '+1 382-29238'::varchar2, '+1 382-9182'::varchar2, 'steph@gmail.com'::varchar2, 3);

create trigger employee_insert
    after insert on employee
    for each row
    execute procedure example_function();


create trigger customer_update
    after update on customer
    for each row
    execute procedure example_function();


create trigger customer_delete
    after delete on customer
    for each row
    execute procedure example_function();

*/

select firstname, lastname, invoiceid from customer inner join invoice on customer.customerid = invoice.customerid;

select customer.customerid, firstname, lastname, invoiceid, total from customer full outer join invoice on customer.customerid = invoice.customerid;

select name, title from album right join artist on album.artistid = artist.artistid;

select name as artist, title as album from artist 
cross join album where artist.artistid = album.artistid 
order by artist.name asc;

-- 7.5 SELF

select A.firstname as firstname, A.lastname as lastname, A.title, B.lastname as reportsto from employee A, employee B where A.reportsto = B.employeeid;







