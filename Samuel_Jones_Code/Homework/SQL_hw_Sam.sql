conn chinook/p4ssw0rd
SELECT *
FROM employee;
SELECT *
FROM Employee
WHERE LastName='King';

SELECT * 
FROM employee
WHERE FirstName='Andrew' AND REPORTSTO IS null;

SELECT *
FROM Album
ORDER BY Title desc;

SELECT FirstName FROM customer ORDER BY city asc;

INSERT INTO genre VALUES(500,'Vegan metal');
INSERT INTO genre VALUES(800, 'Donut ska');

INSERT INTO employee VALUES (10000, 'Burrito', 'Slayer', 'Burrito Slayer', 10, TO_DATE('1993/01/03'),TO_DATE('1993/01/03'), 'Washington Ave','Chicago','IL', 'USA', '32765', '4072371827', '4072371827', 'b@g.com');

INSERT INTO employee (EmployeeId, LastName, FirstName) VALUES (10000, 'Slayer', 'Burrito');
INSERT INTO employee (EmployeeId, LastName, FirstName) VALUES (10001, 'Hunter', 'Burrito');

INSERT INTO customer (CustomerId, FirstName, LastName, Email) VALUES (20000, 'Hummus', 'Hunter', 'hummush@g.com');
INSERT INTO customer (CustomerId, FirstName, LastName, Email) VALUES (20001, 'Hummus', 'Habanero', 'hummusa@g.com');

-- 2.4
UPDATE customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell'; 

UPDATE artist SET title = 'CCR' WHERE  title = 'Creedence Clearwater Revival';

-- 2.5
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- 2.6
SELECT * FROM invoice WHERE total > 15 AND total <20;
SELECT * FROM employee WHERE hiredate > '01-JUN-2003' AND hiredate < '01-MAR-2004'; 

-- 2.7 to resolve the constraints, first delete the foreign key row, then delete the row from the customer table
-- caveman style
DELETE FROM invoiceline WHERE invoiceid = 342;
DELETE FROM invoiceline WHERE invoiceid = 50;
DELETE FROM invoiceline WHERE invoiceid = 61;
DELETE FROM invoiceline WHERE invoiceid = 116;
DELETE FROM invoiceline WHERE invoiceid = 245;
DELETE FROM invoiceline WHERE invoiceid = 268;
DELETE FROM invoiceline WHERE invoiceid = 290;
DELETE FROM invoice WHERE customerid=32;
DELETE FROM customer WHERE customerid=32;

-- or more elegantly, 
-- drop the foreign keys, and add them again but with ON CASCADE DELETE enabled
ALTER TABLE invoice 
drop CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice
add CONSTRAINT fk_invoicecustomerid;
FOREIGN KEY REFERENCES customer (customerid) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
add CONSTRAINT fk_invoicelineinvoiceid
FOREIGN KEY (invoiceid) ON DELETE CASCADE ON UPDATE CASCADE;

DELETE FROM customer WHERE firstname='Robert' AND lastname='Walker';


-- 3.0n
-- current time function
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
-- media length
CREATE OR REPLACE FUNCTION get_mediaLength
RETURN VARCHAR2
IS 
    med_len VARCHAR2(10);
BEGIN
    SELECT MAX(VSIZE(NAME)) INTO med_len FROM mediatype;
    return med_len;
END;

DECLARE med_len VARCHAR2(10);
BEGIN
    med_len := get_mediaLength;
    DBMS_OUTPUT.PUT_LINE('Length: ' || med_len);
END;

-- 2.2
CREATE OR REPLACE FUNCTION get_AVG
RETURN NUMBER
IS 
   average NUMBER(10);
BEGIN
    SELECT AVG(invoiceid) INTO average FROM invoice;
    return average;
END;

DECLARE average NUMBER(10);
BEGIN
    average := get_AVG;
    DBMS_OUTPUT.PUT_LINE('Average: ' || average);
END;

--
CREATE OR REPLACE FUNCTION get_MAX
RETURN NUMBER
IS 
   max_price NUMBER(10);
BEGIN
    SELECT MAX(unitprice) INTO max_price FROM track;
    return max_price;
END;

DECLARE max_price NUMBER(10);
BEGIN
    max_price := get_MAX;
    DBMS_OUTPUT.PUT_LINE('Max unit price: ' || max_price);
END;
--
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

-- 3.4 not working atm
-- CREATE OR REPLACE TYPE t_record as object (
--     i number,
--     n varchar2(30)
--     );
-- create or replace type t_table as table

-- CREATE OR REPLACE FUNCTION getEmps
-- RETURN SETOF employee as $$
-- BEGIN
--    return query (SELECT * FROM employee WHERE birthdate > '01-jan-1968');
-- --    DBMS_OUTPUT.PUT_LINE('AVG unit price: ' || avg_unit);
-- END;

-- DECLARE avg_unit NUMBER(10);
-- BEGIN
--    avg_unit := get_AVG;
--     DBMS_OUTPUT.PUT_LINE('AVG unit price: ' || avg_unit);
-- END;
-- attempt at procedures
-- create or replace type t_table as table of t_record;

-- CREATE OR REPLACE PROCEDURE workers_details (
-- --   p_employeeid IN employee.employeeid%TYPE,
--    o_firstname OUT employee.firstname%TYPE,
--    o_lastname OUT employee.lastname%TYPE)
-- IS
-- BEGIN
--    SELECT firstname, lastname
--    INTO t_table
--    FROM employee;
-- --   WHERE employeeid = p_employeeid;
-- END;
-- /
-- DECLARE 
-- o_firstname VARCHAR2(300);  o_lastname VARCHAR2(300);
-- BEGIN 
-- --    o_firstname := workers_details(firstname,lastname);  
--     workers_details(o_firstname,o_lastname);
--     DBMS_OUTPUT.PUT_LINE(o_firstname);
-- END;
-- SELECT * FROM employee;

-- 4.2
-- CREATE 

-- 5.0

-- BEGIN 
	

-- 6.1 this works
CREATE TRIGGER emp_trigger1
BEFORE INSERT ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('New employee added');
end;
INSERT INTO employee (employeeid, firstname,lastname) VALUES(1337,'Sam','Jones');

-- 6.1 delete trigger
CREATE or replace TRIGGER emp_trigger2
BEFORE DELETE ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('Employee deleted');
end;
DELETE FROM employee where employeeid=1337;


CREATE or replace TRIGGER emp_trigger3
BEFORE UPDATE ON employee 
FOR EACH ROW
BEGIN 
    DBMS_output.put_line('Employee UPDATED');
end;
INSERT INTO employee (employeeid, firstname,lastname) VALUES(1337,'Sam','Jones');
UPDATE employee SET FirstName='Ilia' WHERE employeeid = 1337;

-- 7.0

-- inner join
SELECT customer.firstname, customer.lastname, invoice.invoiceid FROM customer INNER JOIN invoice ON customer.customerid = invoice.invoiceid;

--outer - both work
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer, invoice WHERE customer.customerid=invoice.customerid(+);
-- RIGHT
SELECT artist.name, album.title FROM artist RIGHT JOIN album ON artist.ARTISTID = album.artistid;

-- cross - 
SELECT artist.name FROM artist CROSS JOIN album ORDER BY artist.name asc;

-- self join
SELECT * FROM employee e1, employee e2 WHERE e1.reportsto=e2.reportsto;