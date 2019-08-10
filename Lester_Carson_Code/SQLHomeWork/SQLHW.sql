--Lester (Barton) Carson
--SQL Homework

--1.0
--conn chinook/p4ssw0rd

--2.0
--2.1
--SELECT * FROM EMPLOYEE;
--SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2
--SELECT * FROM ALBUM ORDER BY TITLE DESC
--SELECT * FROM CUSTOMER ORDER BY CITY ASC

--2.3
--INSERT INTO Genre (GenreId, Name) VALUES(26, 'Classic Rock');
--INSERT INTO Genre (GenreId, Name) VALUES(27, 'Hard Rock');

--INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Bobby', 'Jones', 'General Manager', TO_DATE('1993-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2003-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Vancover', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'billiyb@chinookcorp.com');
--INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Billy', 'Smith', 'Sales Manager', 1, TO_DATE('1968-12-8 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2009-5-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '825 8 Ave SW', 'Whistler', 'AB', 'Canada', 'T2P 2T3', '+1 (403) 262-3443', '+1 (403) 262-3322', 'dope@chinookcorp.com');

--INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Too much', 'brownies', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
--INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Hello', 'Johnny', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);

--2.4
--UPDATE Customer SET LastName = 'Walter' WHERE CustomerId = 32;
--UPDATE Customer SET FirstName = 'Robert' WHERE CustomerId = 32;

--UPDATE Artist SET Name = 'CCR' WHERE ArtistId = 76;

--2.5
--SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6
--SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

--SELECT * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7
--SELECT * FROM Invoice WHERE CustomerId = 32;
--DELETE FROM InvoiceLine WHERE InvoiceId = 50;
--DELETE FROM InvoiceLine WHERE InvoiceId = 61;
--DELETE FROM InvoiceLine WHERE InvoiceId = 116;
--DELETE FROM InvoiceLine WHERE InvoiceId = 245;
--DELETE FROM InvoiceLine WHERE InvoiceId = 268;
--DELETE FROM InvoiceLine WHERE InvoiceId = 290;
--DELETE FROM InvoiceLine WHERE InvoiceId = 342;
--DELETE FROM Invoice WHERE CustomerId = 32;
--DELETE FROM Customer WHERE CustomerId = 32;

--3.0
--3.1
--CREATE OR REPLACE FUNCTION getTime RETURN VARCHAR2 IS BEGIN RETURN SYSDATE; END;

--CREATE OR REPLACE FUNCTION mediatypeLength(mtid NUMBER) RETURN VARCHAR2 IS total NUMBER(3); BEGIN SELECT LENGTH(name) INTO total FROM mediatype WHERE mediatypeid = mtid; RETURN total; END;

--3.2 
SELECT AVG(total) FROM invoice; 
    
SELECT MAX(unitprice) FROM track;

--3.3
/*CREATE OR REPLACE FUNCTION averageInvoicePrice
RETURN NUMBER
IS
    average NUMBER(5);
BEGIN
	SELECT AVG(unitprice) INTO average FROM invoiceline;
    RETURN average;
END;

--3.4
/*CREATE OR REPLACE FUNCTION bornAfter1968
RETURN
IN
BEGIN
    return query (select * from employee where birthdate > '1968-12-31');
END;*/

--4.0
--4.1
CREATE OR REPLACE PROCEDURE firstAndLastNames
IS
    total TABLE;
BEGIN
    SELECT firstname, lastname INTO total FROM employee;
END;

--4.2
CREATE OR REPLACE PROCEDURE updateEmployee
(
    e_id NUMBER(5)
    firstnameinput VARCHAR2(100)
    lastnameinput VARCHAR2(100)
    titleinput VARCHAR2
    reportstoinput NUMBER
    birthdateinput TIMESTAMP
    hiredatinput TIMESTAMP
    addressinput VARCHAR2
    cityinput VARCHAR2
    stateinput VARCHAR2
    countryinput VARCHAR2
    postalcodeinput VARCHAR2
    phoneinput VARCHAR2
    faxinput VARCHAR2
    emailinput VARCHAR2
)
BEGIN
    UPDATE employee SET firstname = firstnameinput, lastname = lastnameinput, title = titleinput, reportsto = reportstoinput, birthdate = birthdateinput, hiredate = hiredateinput, address = addressinput, city = cityinput, state = stateinput, country = countryinput, postalcode = postalcodeinput, phone = phoneinput, fax = faxinput, email = emailinput
        WHERE employeeid = e_id;
END;

CREATE OR REPLACE PROCEDURE employeeManager
(
	e_id NUMBER
)
AS
BEGIN
    RETURN (SELECT lastname FROM employee WHERE employeeid = (
                SELECT reportsto FROM employee WHERE employeeid = e_id
            ));
end;

--4.3
CREATE OR REPLACE PROCEDURE customerSearch
IS
    c_id NUMBER;
BEGIN
	SELECT firstname, lastname, company FROM customer WHERE customerid = c_id;
END;

--5.0
--5.1
CREATE OR REPLACE FUNCTION deleteInvoice
IS
    invoice_id_input NUMBER;
BEGIN
	DELETE FROM invoice WHERE invoiceid = invoice_id_input;
END;

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE OR REPLACE FUNCTION insertCustomer(customeridinput int, firstnameinput varchar, lastnameinput varchar, companyinput varchar, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar, supportrepidinput int)
RETURN VOID
IS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) VALUES (customeridinput, firstnameinput, lastnameinput, companyinput, addressinput, cityinput, stateinput, countryinput, postalcodeinput, phoneinput, faxinput, emailinput, supportrepidinput);
END;

--6.0
--6.1
CREATE TRIGGER employee_insert
    AFTER INSERT ON employee
    FOR EACH ROW
BEGIN
    IF :new.record IS NULL THEN
    SELECT SEQUENCE INTO :new.record FROM dual;
    END IF;
END;

CREATE TRIGGER album_update
    AFTER UPDATE ON album
    FOR EACH ROW
    EXECUTE PROCEDURE example_function();
    
CREATE TRIGGER customer_delete
    AFTER DELETE ON customer
    FOR EACH ROW
    EXECUTE PROCEDURE example_function();


--7.0
--7.1
--SELECT firstname, lastname, invoiceid FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid;

--7.2
--SELECT customer.customerid, firstname, lastname, invoiceid, total FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3
--SELECT name, title FROM album RIGHT JOIN artist ON album.artistid = artist.artistid;

--7.4
--SELECT name AS artist, title AS album FROM artist CROSS JOIN album WHERE artist.artistid = album.artistid ORDER BY artist.name ASC;

--7.5
--SELECT A.firstname AS firstname, A.lastname AS lastname, A.title, B.lastname AS reportsto FROM employee A, employee B WHERE A.reportsto = B.employeeid;