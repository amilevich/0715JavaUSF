--2.1 SELECT
SELECT *
FROM Employee;

SELECT *
FROM Employee
WHERE LastName = 'King';

SELECT *
FROM Employee
WHERE FirstName = 'Andrew' AND ReportsTo IS NULL;

--2.2 ORDER BY
SELECT *
FROM Album
ORDER BY title DESC;

SELECT FirstName, city
FROM Customer
ORDER BY city ASC;

--2.3 INSERT INTO
INSERT INTO genre VALUES (26, 'SuperNewGenre');
INSERT INTO genre VALUES (27, 'GameChanger');

INSERT INTO employee VALUES (9, 'Doe', 'John', 'Senior Developer', 6, TO_DATE('1980-3-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-03-17 00:00:00','yyyy-mm-dd hh24:mi:ss'), '4564 E Elm St', 'Lethbridge', 'AB', 'Canada', 'T1H 1R4', '+1 (403) 235-5854', '+1 (403) 323-2222', 'johndoe@mail.com');
INSERT INTO employee VALUES (10, 'Smith', 'Lilly', 'Developer', 6, TO_DATE('1990-4-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-03-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), '9383 S Roe Ave', 'Lethbridge', 'AB', 'Canada', 'T1H 1E4', '+1 (403) 235-5854', '+1 (403) 323-2222', 'johndoe@mail.com');

INSERT INTO customer VALUES (60, 'Teddy', 'Suarez', null, '4444 S Dee Pl', 'Montreal', 'QC', 'Canada', 'H2G 1B7', '+1 (514) 721-4901', null, 'tsuarez@gmail.com', 4);
INSERT INTO customer VALUES (61, 'Dave', 'Kane', null, '8398 N Trench Ave', 'Montreal', 'QC', 'Canada', 'H2F 1B7', '+1 (514) 555-4901', null, 'davekane@gmail.com', 3);

--2.4 UPDATE
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter'
WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

UPDATE Artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT*
FROM employee
WHERE hiredate BETWEEN TO_DATE ('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE
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
SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;

--Task – Create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION getMedialength(INPUT IN VARCHAR2) 
RETURN INTEGER AS finalAns VARCHAR2(50);
BEGIN
    finalAns := LENGTH(INPUT);
    RETURN finalAns;
END;
/

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION averageInvoice
RETURN NUMBER AS averageAns NUMBER; 
BEGIN
        SELECT SUM(x.total)/COUNT(x.total)
        INTO averageAns
        FROM invoice x;   
    RETURN averageAns;
END;
/

select averageInvoice
from invoice
group by averageInvoice;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION mostExpensiveTrack
RETURN track.NAME%TYPE AS trackName track.NAME%TYPE;
BEGIN
    SELECT track.NAME
    INTO trackName
    FROM track
    WHERE unitprice = (SELECT MAX(unitprice)
                        FROM track)
    AND rownum = 1;
    RETURN trackName;
END;
/
SELECT mostExpensiveTrack
FROM track
GROUP BY mostExpensiveTrack;


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avgInvoicePrice
RETURN NUMBER AS average NUMBER;
    counter NUMBER := 0; total NUMBER := 0;
BEGIN
    FOR iterThrough IN (SELECT * FROM invoiceline)
    LOOP
        counter := counter + 1;
        total := total + iterThrough.unitprice;
    END LOOP;
    average := total/counter;
    RETURN average;
END;
/
SELECT avgInvoicePrice
FROM invoiceline
GROUP BY avgInvoicePrice;

--3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION BornAfter1968
RETURN employee%rowtype is ba_emp employee%rowtype ;
BEGIN
 SELECT e.* INTO ba_emp
   FROM employee e WHERE e.birthdate > '01-jan-1968';
 RETURN ba_emp;
END;
/
DECLARE ba_emp TYPE;
BEGIN
    ba_emp := BornAfter1968();
    DBMS_OUTPUT.PUT_LINE('People born after 1968 are:' || ba_emp);
END;
/

--4.1 Basic Stored Procedure
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
/
--4.2 Stored Procedure Input Parameters
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

--4.3 Stored Procedure Output Parameters
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

--5.0 Transactions
CREATE OR REPLACE PROCEDURE deleteInvoice (input_invoiceid IN invoice.invoiceid % TYPE) 
AS
BEGIN
    SAVEPOINT LastSave;
    DELETE FROM invoiceline WHERE invoiceid = input_invoiceid;
    DELETE FROM invoice WHERE invoiceid = input_invoiceid;
    COMMIT;
    
    EXCEPTION WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Delete unsuccessful');
        ROLLBACK TO LastSave;
END;
/

DECLARE
    randomInput invoice.invoiceid%TYPE;
BEGIN
    deleteInvoice(random_input);
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE addCustomer(custid IN NUMBER, firstN IN VARCHAR2, lastN IN VARCHAR2,
email IN VARCHAR2)
AS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email) 
    VALUES(custid, firstN, lastN, email);
    COMMIT;
END;
/

BEGIN
addCustomer(117, 'Lopez', 'Rue', 'Loper@mail.com');
END;
/
SELECT * 
FROM customer 
WHERE customerid = 117;



--6.1 AFTER/FOR
CREATE TRIGGER afterInsertTrigg
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee record inserted');
END;
/


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TRIGGER afterUpdateTrigg
AFTER UPDATE ON album
BEGIN
    DBMS_output.put_line('The Album table was updated');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE TRIGGER afterDeleteTrigg
AFTER DELETE ON customer
BEGIN
   DBMS_output.put_line('A Customer record was deleted');
END;
/

--7.1 INNER
SELECT firstname, lastname, invoiceid 
FROM customer 
INNER JOIN invoice ON customer.customerid = invoice.customerid;

--7.2 OUTER
SELECT customer.customerid, firstname, lastname, invoiceid, total 
FROM customer 
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3 RIGHT
SELECT name, title 
FROM album 
RIGHT JOIN artist ON album.artistid = artist.artistid;

--7.4 CROSS
SELECT NAME AS artist, title AS album 
FROM artist 
CROSS JOIN album 
WHERE artist.artistid = album.artistid 
ORDER BY artist.name ASC;

--7.5 SELF
SELECT A.firstname AS firstname, A.lastname AS lastname, A.title, B.lastname AS reportsto 
FROM employee A, employee B 
WHERE A.reportsto = B.employeeid;
