2.1 SELECT
Task – Select all records from the Employee table.
conn chinook/p4ssw0rd
SELECT *
FROM EMPLOYEE;

Task – Select all records from the Employee table where last name is King.
conn chinook/p4ssw0rd
SELECT *
FROM EMPLOYEE
WHERE Lastname = 'King';

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
conn chinook/p4ssw0rd
SELECT *
FROM EMPLOYEE
WHERE Firstname = 'Andrew'
AND Reportsto IS NULL;

2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
conn chinook/p4ssw0rd
SELECT *
FROM ALBUM
ORDER BY title DESC;

Task – Select first name from Customer and sort result set in ascending order by city
conn chinook/p4ssw0rd
SELECT Firstname
FROM Customer
ORDER BY City;

2.3 INSERT INTO
Task – Insert two new records into Genre table
conn chinook/p4ssw0rd
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Techno');

INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Blues');

Task – Insert two new records into Employee table
conn chinook/p4ssw0rd
INSERT INTO EMPLOYEE(employeeid,lastname,firstname) values(9,'Lucnel','Nordelus');

INSERT INTO EMPLOYEE(employeeid,lastname,firstname) values(10,'Jake','Morty');

Task – Insert two new records into Customer table
conn chinook/p4ssw0rd
INSERT INTO CUSTOMER(customerid,firstname,lastname,email,supportrepid) values(60,'Rick','Sanchez','RickandRick@live',2);

INSERT INTO CUSTOMER(customerid,firstname,lastname,email,supportrepid) values(61,'Bob','Builder','Buildme@qol.com',3);

2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
conn chinook/p4ssw0rd
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid
   FOREIGN KEY (customerid) REFERENCES customer (customerid)
   ON DELETE CASCADE;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
   FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid)
   ON DELETE CASCADE;
DELETE FROM customer WHERE (firstname = 'Robert' AND lastname = 'Walter');
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname='Aaron' and lastname = 'Mitchell';

Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
conn chinook/p4ssw0rd
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

2.5 LIKE
Task – Select all invoices with a billing address like “T%”
conn chinook/p4ssw0rd
SELECT * 
FROM invoice
WHERE billingaddress LIKE 'T%';

2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
conn chinook/p4ssw0rd
SELECT * 
FROM invoice 
WHERE total between 15 and 50;

Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
conn chinook/p4ssw0rd
SELECT * 
FROM employee 
WHERE hiredate between '01-JUN-03' and '01-MAR-04';

2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
conn chinook/p4ssw0rd
SELECT *
FROM customer
WHERE FirstName = 'Robert' AND LastName ='Walter';


3.1 System Defined Functions
Task – Create a function that returns the current time.
conn chinook/p4ssw0rd
SELECT
CURRENT_TIMESTAMP
FROM
dual;

Task – Create a function that returns the length of a mediatype from the mediatype table
conn chinook/p4ssw0rd
SELECT
GET LENGTH(mediatype)
FROM Mediatype;




3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
conn chinook/p4ssw0rd
SELECT*
FROM Invoice;

conn chinook/p4ssw0rd
SELECT AVG(total)
FROM invoice;

Task – Create a function that returns the most expensive track
conn chinook/p4ssw0rd
SELECT*
FROM TRACK;

conn chinook/p4ssw0rd
SELECT MAX(unitprice) 
FROM track;

3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
conn chinook/p4ssw0rd
SELECT*
FROM invoiceline

conn chinook/p4ssw0rd
SELECT AVG(unitprice)
FROM invoiceline;

3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
conn chinook/p4ssw0rd
create or replace function bornAfter68()
returns setof employee as $$
begin
    return query (select * from employee where birthdate > '1968-12-31');
end;
$$ language plpgsql;

select bornAfter68();

4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
conn chinook/p4ssw0rd
create or replace function firstAndLastNames()
returns table (fname varchar, lname varchar) as $$
begin
    return query select firstname, lastname from employee;
end;
$$ language plpgsql;
select * from firstAndLastNames();


4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
conn chinook/p4ssw0rd
create or replace function updateEmployee(e_id int, firstnameinput varchar, lastnameinput varchar, titleinput varchar, reportstoinput int, birthdateinput timestamp, hiredateinput timestamp, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar)
returns void as $$
begin
    update employee set firstname = firstnameinput, lastname = lastnameinput, title = titleinput, reportsto = reportstoinput, birthdate = birthdateinput, hiredate = hiredateinput, address = addressinput, city = cityinput, state = stateinput, country = countryinput, postalcode = postalcodeinput, phone = phoneinput, fax = faxinput, email = emailinput
        where employeeid = e_id;
end;
$$ language plpgsql;

select updateEmployee(10, 'Harris'::varchar, 'Tina'::varchar, 'Trainee'::varchar, 2, '1982-05-14'::timestamp, '2019-01-28'::timestamp, '17 Maple St'::varchar, 'Miami'::varchar, 'FL'::varchar, 'CAN'::varchar, '42934'::varchar, '+1 425-2348'::varchar, '+1 712-3812'::varchar, 'tina@chinookcorp.com'::varchar);



Task – Create a stored procedure that returns the managers of an employee.
conn chinook/p4ssw0rd
create or replace function employeeManager(e_id int)
returns text as $$
begin
    return (select lastname from employee where employeeid = (
                select reportsto from employee where employeeid = e_id
            ));
end;
$$ language plpgsql;

select employeeManager(7);


4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
conn chinook/p4ssw0rd
create or replace function customerSearch(c_id int)
returns table (customer_fname varchar, customer_lname varchar, customer_company varchar) as $$
begin
	return query (select firstname, lastname, company from customer where customerid = c_id);
end;
$$ language plpgsql;

select * from customerSearch(10);


5.0 Transactions
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
conn chinook/p4ssw0rd
create or replace function deleteInvoice(invoice_id_input int)
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

select deleteInvoice(407);


Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
conn chinook/p4ssw0rd
create or replace function insertCustomer(customeridinput int, firstnameinput varchar, lastnameinput varchar, companyinput varchar, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar, supportrepidinput int)
returns void as $$
begin
    insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
        values (customeridinput, firstnameinput, lastnameinput, companyinput, addressinput, cityinput, stateinput, countryinput, postalcodeinput, phoneinput, faxinput, emailinput, supportrepidinput);
end;
$$ language plpgsql;

select insertCustomer(63, 'Yost'::varchar, 'Steph'::varchar, 'Nappins'::varchar, '384 5th Ave'::varchar, 'Tampa'::varchar, 'FL'::varchar, 'USA'::varchar, '61234'::varchar, '+1 382-29238'::varchar, '+1 382-9182'::varchar, 'steph@gmail.com'::varchar, 3);



6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
conn chinook/p4ssw0rd
create trigger employee_insert
    after insert on employee
    for each row
    execute procedure example_function();


Task – Create an after update trigger on the album table that fires after a row is inserted in the table
conn chinook/p4ssw0rd
create trigger customer_update
    after update on customer
    for each row
    execute procedure example_function();


Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
conn chinook/p4ssw0rd
CREATE TRIGGER customer_delete
    AFTER DELETE ON customer
    FOR EACH ROW 
    EXECUTE PROCEDURE example_function();



7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
conn chinook/p4ssw0rd
SELECT firstname, lastname, invoiceid 
FROM customer 
INNER JOIN invoice on customer.customerid = invoice.customerid;


7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
conn chinook/p4ssw0rd
SELECT customer.customerid, firstname, lastname, invoiceid, total 
FROM customer 
FULL OUTER JOIN invoice on customer.customerid = invoice.customerid;



7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
conn chinook/p4ssw0rd
SELECT name, title 
FROM album 
RIGHT JOIN artist on album.artistid = artist.artistid;

7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
conn chinook/p4ssw0rd
SELECT name as artist, title as album 
FROM artist 
CROSS JOIN album 
WHERE artist.artistid = album.artistid 
ORDER BY artist.name asc;

7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
conn chinook/p4ssw0rd
SELECT A.firstname as firstname, A.lastname as lastname, A.title, B.lastname as reportsto 
FROM employee A, employee B 
WHERE A.reportsto = B.employeeid;

