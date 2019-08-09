SELECT * FROM Employee;--select all from employee

SELECT * FROM Employee WHERE lastname = 'King';--select King

SELECT * FROM Employee WHERE firstname = 'Andrew' AND REPORTSTO IS NULL;--select Andrew who reports to nobody

SELECT * FROM Album ORDER BY title DESC;--sort album

SELECT * FROM Customer ORDER BY city;--order by the city name

--for personal use
SELECT * FROM Genre;

--add two genres. and yes, they're a thing.
INSERT INTO Genre VALUES(26, 'Celtic Metal');
INSERT INTO Genre VALUES(27, 'Viking Metal');


--add some employees (would reccoment minimising interraction)
INSERT INTO Employee(EmployeeID, LastName, FirstName, Title) VALUES(9, 'The Crawling Chaos', 'Nyarlathotep', 'The Crawling Chaos');
INSERT INTO Employee(EmployeeID, LastName, FirstName, ReportsTo) VALUES(10, 'The Dreamer', 'Cthulhu',9);

--for personal use
SELECT * FROM Customer ORDER BY FirstName;

--insert new customers
INSERT INTO Customer(CustomerId, FirstName, LastName, Email) VALUES(60, 'Wilbur', 'Whately', 'gimmethenecronomicon@hotmail.com');
INSERT INTO Customer(CustomerId, FirstName, LastName, Email) VALUES(61, 'Abdul', 'Alhazred', 'atthegates@gmail.com');


--replace Aaron with Robert
UPDATE Customer SET FirstName = 'Robert', LastName='Walter' WHERE FirstName = 'Aaron' AND LastName='Mitchell';


--abbreviate CCR. (I ain't no fortunate son)
UPDATE Artist SET name ='CCR' WHERE name='Creedence Clearwater Revival';

--find the billing adresses that start with T
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--find the invoices between 15 and 50
SELECT * FROM Invoice WHERE total BETWEEN 15 AND 50;

--get anyone hired between those dates
SELECT * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

--personal use
SELECT * FROM Invoice;

--remove anything in my way
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerID;
ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceID;

--redefine the constraints as I see fit
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId_Cascade
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;

ALTER TABLE InvoiceLine ADD CONSTRAINT FK_Cascade
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
    
--Bye-bye robert
DELETE FROM Customer WHERE FirstName ='Robert' AND LastName ='Walter';

-- output time
BEGIN
    DBMS_OUTPUT.PUT_LINE(CURRENT_TIMESTAMP);
END;
/

--personal use
SELECT * FROM MediaType;
SELECT * FROM Track ORDER BY UnitPrice DESC;

--create a fuction to take in the id, and return the length of the name
CREATE OR REPLACE FUNCTION lenth(type_id NUMBER)
RETURN NUMBER
IS
id_length NUMBER;
BEGIN
--given there were many, decided to return the longest length
    SELECT MAX(Milliseconds) INTO id_length FROM Track WHERE MediaTypeID = type_id; 
    RETURN id_length;
END;
/

--print out the result
DECLARE type_length NUMBER;
BEGIN
--converted to seconds
    type_length:= (lenth(1)/1000);
    DBMS_OUTPUT.PUT_LINE('Length of the type name: '||type_length||' seconds');
END;
/

--avarage invoice
SELECT AVG(Total) FROM Invoice;

--most expensive track
SELECT Name FROM Track WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM Track);


--create a type matching the employee records
CREATE OR REPLACE TYPE EMP_RECORD AS OBJECT
(
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/

--create a table for it
CREATE OR REPLACE TYPE EMP_TABLE IS TABLE OF EMP_RECORD;
/


CREATE OR REPLACE FUNCTION born
RETURN EMP_TABLE
IS
tmp EMP_TABLE;
BEGIN
--populate it
    SELECT EMP_RECORD(EmployeeId, LastName, FirstName,Title,ReportsTo,BirthDate,HireDate,Address,City,State,Country,PostalCode,Phone,Fax,Email)
    BULK COLLECT INTO tmp FROM Employee WHERE BirthDate >= TO_DATE('1969-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN tmp;
END;
/

--print
SELECT * FROM TABLE(born);

--prints out the first and last names of the employees
CREATE OR REPLACE PROCEDURE firla
IS
BEGIN
  FOR indx in (SELECT * FROM Employee)
    LOOP
     DBMS_OUTPUT.PUT_LINE(indx.FirstName||' ' ||indx.LastName);
    END LOOP;    
END;
/

--run it
EXECUTE firla;

--no specification of WHAT data I was to update, so changing the email address
CREATE OR REPLACE PROCEDURE new_email(id_num IN NUMBER, new_mail IN VARCHAR2)
IS
BEGIN
    UPDATE Employee SET Email=new_mail WHERE EmployeeID = id_num;
END;
/

--personal use
SELECT * FROM Employee ORDER BY EmployeeID DESC;

--run it
EXECUTE new_email(7,'theKING@gmail.com');

--prints the first and last name
CREATE OR REPLACE PROCEDURE boss(id_num IN NUMBER)
IS 
repor NUMBER;
fir VARCHAR2(20);
la VARCHAR2(20);
BEGIN
    SELECT ReportsTO INTO repor FROM Employee WHERE EmployeeID = id_num;
    SELECT FirstName INTO fir FROM Employee WHERE EmployeeID = repor;
    SELECT LastName INTO la FROM Employee WHERE EmployeeID = repor;
    DBMS_OUTPUT.PUT_LINE(fir||' '||la);
END;
/

--run
EXECUTE boss(2);

--procedure to return the company and name of the customer
CREATE OR REPLACE PROCEDURE who_are_you(id_num IN NUMBER, firna OUT VARCHAR2, lana OUT VARCHAR2, co OUT VARCHAR2)
IS
BEGIN
    SELECT FirstName INTO firna FROM Customer WHERE CustomerID = id_num;
    SELECT LastName INTO lana FROM Customer WHERE CustomerID = id_num;
    SELECT Company INTO co FROM Customer WHERE CustomerID = id_num;
END;
/


--a printer to chech it and "order" the output
CREATE OR REPLACE PROCEDURE printer(id_num NUMBER)
IS
fir VARCHAR2(40);
la VARCHAR2(20);
compan VARCHAR2(80);
BEGIN   
    who_are_you(id_num, fir, la, compan);
    DBMS_OUTPUT.PUT_LINE('NAME: '||fir||' '||la||'    Company: '||compan);
END;
/

--finally run it    
EXECUTE printer(5);

--given I'd already changed the conditions above, its a simple matter to delete
DELETE FROM Invoice WHERE InvoiceID=5;

--stored procedure to add a new customer
CREATE OR REPLACE PROCEDURE add_customer(id_num IN NUMBER, fir IN VARCHAR2, la IN VARCHAR, mai IN VARCHAR2)
IS
BEGIN
    INSERT INTO Customer(CustomerID, FirstName, LastName, Email) VALUES (id_num,fir,la,mai);
END;
/

--run it
EXECUTE add_customer(68, 'Devon','Virden','devonvirden@hotmail.com');

--check it
SELECT * FROM CUSTOMER WHERE CustomerID =68;

--create a after insert trigger on employee
CREATE TRIGGER empain
AFTER INSERT ON Employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('Row Added to Employee');
END;
/

INSERT INTO Employee(EmployeeID, FirstName, LastName) VALUES (68,'Devon','Virden');

--create an after update trigger on album
CREATE TRIGGER albup
AFTER UPDATE ON Album 
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album updated');
END;
/

--making someting to modify
INSERT INTO Artist(ArtistID, Name) VALUES (276,'Eluveitie');
INSERT INTO Album(AlbumID, Title, ArtistID) VALUES (348,'Helvetios',276);

--Updating
UPDATE Album SET Title = 'Ategnatos' WHERE AlbumID = 348;

--creating the after delete trigger
CREATE TRIGGER custdl
AFTER DELETE ON Customer 
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer removed');
END;
/

--Delete
DELETE Customer WHERE CUSTOMERID = 12;

--inner join
SELECT FirstName,LastName,InvoiceID 
FROM Customer
INNER JOIN Invoice
ON Customer.CustomerID=Invoice.CustomerID;

--outer join
SELECT Customer.CustomerID, FirstName, LastName, InvoiceID, Total
FROM Customer
FULL OUTER JOIN Invoice
ON Customer.CustomerID=Invoice.CustomerID;

--right outer
SELECT Name, Title
FROM Artist
RIGHT OUTER JOIN Album
ON Artist.ArtistID=Album.ArtistID;

--cross join
SELECT *
FROM Artist
CROSS JOIN Album
WHERE Artist.ArtistID=Album.ArtistID
ORDER BY Name ASC;

--self join
SELECT *
FROM Employee E
LEFT OUTER JOIN Employee M
ON E.ReportsTo=M.EmployeeID
ORDER BY E.EmployeeID ASC;