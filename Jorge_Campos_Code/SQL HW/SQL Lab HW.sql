--SQL Lab HW by Jorge Campos
--conn chinook/p4ssw0rd

--2.1 Select
SELECT * FROM Employee;

SELECT * FROM Employee WHERE LASTNAME = 'King';

SELECT * FROM Employee WHERE Firstname = 'Andrew' and REPORTSTO IS NULL;

--2.2 Order By
SELECT * FROM Album ORDER BY Title DESC;

SELECT Firstname FROM Customer ORDER BY city;

--2.3 Insert Into
SELECT * FROM GENRE;
INSERT INTO Genre VALUES (26,'SuperHero'); 
INSERT INTO Genre VALUES(27,'Mystery');

--2.4 Update
UPDATE Customer SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
--Used to check-- SELECT Firstname, Lastname FROM Customer WHERE FIRSTNAME = 'Robert' and LASTNAME = 'Walter';

UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
--Used to check-- select name from artist where name = 'CCR';

--2.5 Like
SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

--2.6 Between
SELECT * FROM Invoice WHERE total BETWEEN 15 and 50;

Select * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') 
    AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 Delete(NOT FINISHED)
DELETE FROM Customer WHERE firstname = 'Robert'and lastname = 'Walter';

SELECT * FROM Customer WHERE firstname = 'Robert'and lastname = 'Walter';

SELECT * FROM INVOICE WHERE CUSTOMERID = 32;


--3.1 System Defined Functions

CREATE OR REPLACE FUNCTION get_time 
    Return VARCHAR2 
IS
    current_time VARCHAR(9);
BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS') INTO current_time FROM DUAL;
return current_time;
END;
/

BEGIN    --used to check time function
    DBMS_OUTPUT.PUT_LINE('Current Time: ' || get_time() );
END;
/

SELECT * FROM MEDIATYPE;
SELECT * FROM TRACK;
CREATE OR REPLACE FUNCTION get_length(a in NUMBER) 
    Return NUMBER 
IS
    length_of_time NUMBER(9);
BEGIN
    SELECT milliseconds INTO length_of_time FROM track WHERE TrackID = a;
return length_of_time;
END;
/

BEGIN    --used to check length function
    DBMS_OUTPUT.PUT_LINE('Length of media(ms): ' || get_length(2) );
END;
/

--3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION get_total_avg
    Return NUMBER 
IS
    total_avg NUMBER(9);
BEGIN
    SELECT AVG(TOTAL) INTO total_avg FROM Invoice;
return total_avg;
END;
/

BEGIN    --used to check total avg function
    DBMS_OUTPUT.PUT_LINE('Total AVG: ' || get_total_avg() );
END;
/

CREATE OR REPLACE FUNCTION most_expensive 
  RETURN NUMBER
IS
    max_track NUMBER(6); --define parameter
BEGIN
    SELECT MAX(UnitPrice) INTO max_track FROM Track;
    RETURN max_track;
END;
/

BEGIN    --used to check total avg function
    DBMS_OUTPUT.PUT_LINE('Max Track: ' || most_expensive() );
END;
/

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION avg_invoiceline_price 
  RETURN NUMBER
IS
    avg_price NUMBER(6); --define parameter
BEGIN
    SELECT AVG(UnitPrice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/

BEGIN    --used to check total avg function
    DBMS_OUTPUT.PUT_LINE('AVG Invoiceline Price: ' || avg_invoiceline_price() );
END;
/

--3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION employees_after_1968 
  RETURN  employee%rowtype 
IS
    emp employee%rowtype;
BEGIN    

    SELECT * INTO emp FROM employee  WHERE BirthDate > TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN emp;
END;
/


BEGIN    --used to check employees_after_1968 function
    DBMS_OUTPUT.PUT_LINE('employees_after_1968: ' || employees_after_1968() );
    --SELECT * FROM table(employees_after_1968());
END;
/
--4.1 Basic Stored Procedure
create type my_tab_type is object
(last_name varchar2(15), first_name varchar2(15))
/

create type my_tab_type_coll is table of my_tab_type;
/

Create or replace function first_and_last_names_procedure(p_val in number) 
return my_tab_type_coll pipelined is
begin
  FOR i in (select lastname, firstname from employee) loop
    pipe row(my_tab_type(i.lastname,i.firstname));
  end loop;
  return;
end;
/

SELECT * FROM table(first_and_last_names_procedure(3));


--4.2 Stored Procedure Input Parameters


CREATE OR REPLACE PROCEDURE get_manager(emp_id IN NUMBER, emp_name OUT VARCHAR2)
IS man_id NUMBER;
BEGIN
    SELECT employeeID INTO man_ID FROM employee WHERE employeeID = emp_id;
    SELECT CONCAT(CONCAT(Firstname,' '), Lastname) Into emp_name FROM employee WHERE employeeID = man_id;
END;
/

DECLARE result VARCHAR2(20);
BEGIN
    get_manager(2,result);
    DBMS_OUTPUT.PUT_LINE('Manager of employeeID 2: ' || result);
END;
/
--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE get_name_and_company(cust_id in NUMBER, fName OUT  VARCHAR2, lName OUT  VARCHAR2, cName OUT  VARCHAR2)
IS
BEGIN
    --SELECT firstname, lastname, company INTO fName, lName, cName FROM customer WHERE customerid = cust_id;
    SELECT firstname INTO fName FROM customer WHERE customerid = cust_id;
    SELECT lastname INTO lName FROM customer WHERE customerid = cust_id;
    SELECT company INTO cName FROM customer WHERE customerid = cust_id;
END;
/

DECLARE fName VARCHAR2(30); lName VARCHAR2(30); cName VARCHAR2(30);
BEGIN
    get_name_and_company(11,fName,lName,cName);
    DBMS_OUTPUT.PUT_LINE('Name and company: ' ||' '|| fName ||' '||lname ||': '||cName );    
END;
/

--5.0 Transactions







--6.1 After/For
--INSERT INTO employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Johnson', 'Patrick', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
--SELECT * FROM EMPLOYEE;
--DELETE FROM EMPLOYEE WHERE EmployeeID = 9;
--UPDATE employee set lastname = 'Star' where EmployeeID = 9;

CREATE TRIGGER emp_insert_trigger --naming the trigger
AFTER INSERT ON employee -- when and what action happens 'AFTER'
FOR EACH ROW
BEGIN --signifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('In Insert Trigger');
END;
/

CREATE TRIGGER emp_update_trigger --naming the trigger
AFTER UPDATE ON employee -- when and what action happens 'AFTER'
FOR EACH ROW
BEGIN --signifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('In Update Trigger');
END;
/

CREATE TRIGGER emp_delete_trigger --naming the trigger
AFTER DELETE ON employee -- when and what action happens 'AFTER'
FOR EACH ROW
BEGIN --signifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('In Delete Trigger');
END;
/

--7.1 Inner
SELECT * From customer INNER JOIN invoice USING(customerID);

--7.2 Outer
SELECT customerID,firstname,lastname,invoiceID,total From customer OUTER JOIN invoice USING(customerID);

--7.3 Right
SELECT name, title FROM album RIGHT JOIN artist USING(artistid);

--7.4 Cross
SELECT * FROM album CROSS JOIN artist ORDER BY name;

--7.5 Self
SELECT a.*,b.lastname,b.firstname FROM employee a, employee b WHERE a.reportsTo = b.employeeID;



