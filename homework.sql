conn chinook/p4ssw0rd


--2.1 SELECT

SELECT * FROM Employee;
SELECT * FROM Employee WHERE Lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' AND Reportsto is null;

--2.2 ORDER BY

SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer order by city ASC;

--2.3 INSERT INTO

SELECT * FROM genre;
INSERT INTO genre VALUES(26, 'Rap Music');
INSERT INTO genre VALUES(27, 'Afro Beats');
INSERT INTO employee VALUES(9, 'Ngouana', 'Gael', 'CEO', null, '4-APR-1988', '1-JAN-2019', '213 West Bel-air Ave', 'Tampa', 'FL', 'USA', 'BP 15444', '+1 (312) 292-0303', '+1 (712) 954-4567', 'gaelg@gmail.com');
INSERT INTO employee VALUES(10, 'Wass', 'Bob', 'Assistant', 9, '4-APR-1980', '1-JAN-2019', '214 West Bel-air Ave', 'Tampa', 'FL', 'USA', 'BP 15445', '+1 (312) 252-0303', '+1 (712) 984-4567', 'bobwass@gmail.com');
SELECT * FROM customer;
INSERT INTO customer (customerId, firstname, lastname, address, city, country, postalcode, phone, email, supportrepid) 
VALUES(60, 'John', 'Snow', '290 voila street', 'Disneyland', 'Germany', 3456, '+34 (0) 45 6985 9594', 'hahaha@gmail.com', 4);
VALUES(61, 'Bob', 'lezar', '291 aurevoir street', 'Rack City', 'South Africa', 3226, '+35 (0) 45 6966 9594', 'hahaha07@gmail.com', 4);

--2.4 UPDATE
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' and lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total > 15 AND total < 50; 
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-2003' and '01-MAR-2004';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

alter table invoice drop constraint FK_INVOICECUSTOMERID;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
on delete cascade;
ALTER TABLE invoiceline drop constraint FK_INVOICELINEINVOICEID;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
FOREIGN KEY (InvoiceId) 
REFERENCES Invoice (InvoiceId) on delete cascade;
delete from customer where FIRSTNAME = 'Robert' and LASTNAME = 'WALTER';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.


create or replace Function getTime return timestamp is
begin return sysdate; end;/
declare
    today timestamp;
begin
    today := getTime;
    dbms_output.put_line(today);
end;
/

--Task – Create a function that returns the length of a mediatype from the mediatype table
/
create or replace function getlength(x in varchar2) 
return integer as z varchar(200);
begin 
    z := length(x);
    return z;
end;
/
select getlength(name) from mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

create or replace function myavg
return number as z number;
begin 
    select avg(total) into z from invoice;
    return z;
end;
/
select myavg from dual;

--Task – Create a function that returns the most expensive track

create or replace function mymax
return number as z number (10, 2);
begin 
    select max(unitprice) into z from track;
    return z;
end;
/
select mymax from dual;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

create or replace function myavg20
return number as x number;
begin 
    select avg(unitprice) into x from invoiceline;
    return x;
end;
/
select myavg20 from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

create or replace function bornafter(x date)
return sys_refcursor is refcur sys_refcursor;
begin
    open refcur for 'select firstname, lastname from employee 
    where birthdate >= :x' using x;
    return refcur;
end;
/

declare 
x date;
fn employee.firstname%type;
ln employee.lastname%type;
returncur sys_refcursor;
begin
x := to_date('1968', 'yyyy');
select bornafter(x) into returncur from dual;
dbms_output.put_line('here');
    Loop
        fetch returncur into fn, ln;
        exit when returncur%notfound;
        DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
    end loop;
end;
/


--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure getemployeename(s out sys_refcursor)
as begin
 open s for select firstname, lastname from employee;
end;
/
declare
    s sys_refcursor;
    fn employee.firstname%type;
    ln employee.lastname%type;
begin 
    getemployeename(s);
    loop 
        fetch s into fn, ln;
        exit when s%notfound;
        dbms_output.put_line(fn || ', ' || ln);
    end loop;
    close s;
end;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

create or replace procedure updatepersonalemployee(newemail in varchar2, employeeid in number)
as begin
    update employee set email = newemail where employeeid = employee.employeeid;
    commit;
end;
/
select firstname, lastname, email from employee where employeeid = 7;
begin
    updatepersonalemployee('newemail@email.com', 7);
end;
/

--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure managedby(s out sys_refcursor, inemployeeid in number)
as begin 
    open s for select emp.employeeid, emp.firstname, emp.lastname 
    from employee e join employee emp on e.reportsto = emp.employeeid 
    where e.employeeid = inemployeeid; 
end;
/
declare
    s sys_refcursor;
    fn employee.firstname%type;
    ln employee.lastname%type;
    employeeid employee.employeeid%type;
    inemployeeid number;
begin 
    inemployeeid := 2;
    managedby(s, inemployeeid);
    loop 
        fetch s into employeeid, fn, ln;
        exit when s%notfound;
        dbms_output.put_line(employeeid || ', ' || fn || ', ' || ln);
    end loop;
    close s;
end;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure getcompname(compname out varchar2, fn out varchar2, ln out varchar2, cid in number)
as begin
    select company into compname from customer where customerid = cid;
    select firstname into fn from customer where customerid = cid;
    select lastname into ln from customer where customerid = cid;
end;
/
declare
    cname varchar2(200);
    nf varchar2(200);
    nl varchar2(200);
    cid number;
begin
    cid := 5;
    getcompname(cname, nf, nl, cid);
    dbms_output.put_line(cname || ' ' || nf || ' ' || nl);
end;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

begin
    delete from INVOICELine where invoiceid = 21;
    delete from invoice where invoiceid = 21;
    commit;
end;
/
select * from invoice;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

create or replace procedure insertcust(cid in number, fn in varchar2, ln in varchar2, email in varchar2)
as begin
    insert into customer (customerid, firstname, lastname, email) 
        values(cid, fn, ln, email);
    commit;
end;
/
begin
insertcust(63, 'jack', 'reidy', 'myemail@gmail.com');
end;
/
select * from customer where customerid = 63;

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger triggertest
after insert on employee
begin
    DBMS_OUTPUT.PUT_LINE('triggered');
end;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

create or replace trigger trigger2
after update on album 
begin
    DBMS_output.put_line('this isnt an insert but it is an update');
end;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

create or replace trigger trigger3
after delete on customer 
begin
    DBMS_output.put_line('hey im done');
--end;

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname, invoiceid from customer inner join invoice on customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, firstname, lastname, invoiceid, total from customer full outer join invoice on customer.customerid = invoice.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

select name, title from album right join artist on album.artistid = artist.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select name as artist, title as album from artist 
cross join album where artist.artistid = album.artistid 
order by artist.name asc;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select A.firstname as firstname, A.lastname as lastname, A.title, B.lastname as reportsto from employee A, employee B where A.reportsto = B.employeeid;











