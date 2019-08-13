SELECT * FROM   employee;  --SELECTS ALL DATA FORM THE EMPLOYEE TABLE

SELECT * FROM employee WHERE lastname = 'King'; --SELECTS FROM THE EMPLOYEE TABLE THE INFORMATION SPECIFIED 


SELECT * FROM employee WHERE firstname = 'Andrew' and reportsto is null; --SAME AS ABOVE


SELECT * FROM album order by title desc; --SELECT ALL INFO FROM TABLE ALBUM AND ORDER IT BY TITLE DESCRIPTION


SELECT firstname FROM customer order by city; --SELECTS THE FIRST NAMES FROM THE CUSTOMER TABLE IN TH EORDER OF WHICH CITY THEY LIVE IN

SELECT * FROM GENRE; --SELECTS ALL DATA FROM THE TABLE GENRE

INSERT INTO genre (genreid, name) VALUES (28, 'Celtic'); --INSERTS NEW DATA VALUES INTO THE GENRE TABLE
INSERT INTO genre (genreid, name) VALUES (2, 'Wiccan'); -- SAME AS ABOVE BUT VALUES ARE DIFFERENT

SELECT * FROM employee -- SELECTS ALL DATA FROM THE EMPLOYEE TABLE
INSERT INTO TABLE employee(employeeid,lastname,firstname) VALUES(9,'VLAD','TEPES'), --INSERTS NEW VALUES INTO THE TABLE

INSERT INTO TABLE employee(employeeid,lastname,firstname) VALUES(10,'ELIZABETH','BATHORY'); --SAME AS LINE 20


INSERT INTO customer (customerId, firstname, lastname, address, city, country, postalcode, phone, email, supportrepid) --INSERT INTO THE TABLE NEW VALUES
VALUES (60, 'Frank', 'Garrison', '73 1st Ave', 'Tampa', 'USA', '33613', '+1 (234) 231-2482', 'fgarrison@gmail.com', 3);--SAME AS LINE 35
INSERT INTO customer (customerId, firstname, lastname, address, city, country, postalcode, phone, email, supportrepid) --SAME AS LINE 25
VALUES (61, 'Beatrice', 'Brooks', '128 Bay St', 'Tampa', 'USA', '33613', '+1 (639) 753-6962', 'bbrooks@gmail.com', 5);  --SAME AS LINE 25


UPDATE customer set firstname = 'Robert', lastname = 'Walker' where firstname = 'Aaron' and lastname = 'Mitchell'; -- UPDATES FIRSTNAME AND LASTNAME AND CHANGES IT TO
                                                                                                                    --THE CHOSEN VALUES VIA KEYWORD 'WHERE'

UPDATE artist set name = 'CCR' where name = 'Creedence Clearwater Revival'; --SAME AS LINE 31


SELECT * FROM invoice where billingaddress like 'T%'; --SELECTS FROM THE TABLE INVOICE BASED ON DATA THAT IS LIKE THE REQUIRED VALUE


SELECT * FROM invoice where total between 15 and 50;  --SAME AS LINE 37


SELECT * FROM employee   
WHERE hiredate BETWEEN'2002-06-01'AND'2004-03-01';  --SELECTS FROM THE EMPLOYEE TABLE BASED ON SPECIFIED VALUES AND DARWS THAT INFO BASED ON THE COMPARED VALUES CHOSEN


ALTER TABLE invoice --ALLOWS FOR ALTERATION OF THE CHOSEN TABLE
DROP CONSTRAINT fk_invoicecustomerid; --DROPS SELECTIVE CONSTRAINT AS INFLUENCED BY LINE 47

ALTER TABLE invoice     --SAME AS LINE 47
ADD CONSTRAINT fk_invoicecustomerid --ADDS CONSTRIANT AS INFLUENCED BY LINE 50
FOREIGN KEY (customerid) references customer (customerid) on delete cascade on update cascade;--THE GIVEN VALUES FOR THE CREATED CONSTRAINT

ALTER TABLE invoiceline --ALLOWS ALTERATION OF THE THE SELECTED TABLE
DROP CONSTRIANT fk_invoicelineinvoiceid;--REMOVES SELECTED CONSTRAINT AS INFLUENCED BY LINE 54

ALTER TABLE invoiceline --SAME AS LINE 54
ADD CONSTRAINIT fk_invoicelineinvoiceid --ADDS NEW CONSTRAINT AS INFLUENCED BY LINE 57
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) on delete cascade on update cascade; --THE GIVEN VALUES FOR THE CREATED CONSTRAINT

DELETE FROM customer WHERE firstname = 'Robert' and lastname = 'Walker'; --DELETES VALUES FORM SELECTED TABLE BASED ON SELECTED VALUES


CREATE OR REPLACE FUNCTION currentTime() --CREATES A NEW FUNCTION OR REPLACES A CURRENT FUNCTION BASED ON THE SELECTED TABLE
returns text as $$  --RETURNS OUTPUT TEXT FROM LINE 64 AS A MONEY AMOUNT
BEGIN  --TELLS SQL TO BEGIN HERE
    RETURN current_time; --ACTION THAT IS TO BE TAKEN AFTER LINE 66
END; --TELLS THE SQL WHERE IT IS TO END THIS PROCESS


SELECT currentTime(); --TELLS SQL TO SELECT FORM THE CHOSEN TABLE


CREATE OR REPLACE FUNCTION mediatypeLength(idinput int) --SAME AS LINE 74
returns INT AS $$ --SAME AS LINE 65 EXCEPT WE ARE CONVERTING FORM AN INT
BEGIN --SAME AS LINE 66
	RETURN (SELECT LENGTH(name) FROM mediatype WHERE mediatypeid = idinput); --RETURNS SELETED VARIABLE FORM CHOSEN TABLE BASED ON SPECIFIED INPUT
 END; --ENDS THE ABOVE PROCESS
 

SELECT mediatypeLength(1); --SELECT FROM THE SELECTED TABLE 


CREATE OR REPLACE FUNCTION averageTotal() --CREATE NEW FUNCTION OR REPLACE CURRENT ONE WITHIN SELECTED TABLE
returns FLOAT as $$ --RETURNS THE FLOAT VALUE AS A MONETARY VALUE
BEGIN --TELLS SQL TO START THE FOLLOWING PROCESS
	RETURN AVG(total) FROM invoice; --COMMANDS SQL TO RETURN THE VALUE FOF THE SELECTED TABLE BASED ON SPECIFIED VALUES
 END;--TELLS SQL TO END THE CURRENT PROCESS


SELECT averageTotal(); --SELECTS ALL DATA FORM CHOSEN TABLE


CREATE OR REPLACE FUNCTION mostExpensiveTrack()--CREATE NEW UNCTION OR REPLACE CURRENT ONE ON SELECTED TABLE
returns text AS $$ --RETURNS SELECTED VALUES AS A MONATARY OUTPUT VALUE
BEGIN
	RETURN(SELECT NAME FROM track WHERE unitprice = (SELECT MAX(unitprice) FROM track)); --INSTRUCTS SQL TO RETURN THE CHOSEN VALUES. WORKS IN CONJUNCTION WITH LINE 95
 END; --TELLS SQL TO END THE CURRENT PROCESS


SELECT mostExpensiveTrack(); --SELECTS THE CHOSEN TABLE


CREATE OR REPLACE FUNCTION averageInvoicePrice() --CREATE NEW FUNCTION OR REPLACE CURRENT ONE
returns FLOAT AS $$ --TELLS SQL TO CNVERT FLOAT VALUE INTO A MONETARY VALUE
BEGIN --TELLS SQL TO BEGIN THE FOLLOWING PROCESS
	RETURN(SELECT AVG(unitprice) FROM invoiceline); --TELLS SQL TO RETURN THE SELECTED VALUE FROM CHOSEN TABLE
 END; --TELLS SQL TO END CURRENT PROCESS


SELECT averageInvoicePrice(); --SELECTS CHOSEN TABLE FORM DATABASE


CREATE OR REPLACE FUNCTION bornAfter68() --CREATES NEW FUNCTION OR REPLACES CURRENT FUNCTION
returns set of employee as $$ --CONVERTS SET VALUE AS MONETARY VALUE
BEGIN --TELLS SQL WHERE TO BEGIN A PROCESS
    RETURN QUERY (SELECT * FROM employee where birthdate > '1968-12-31'); --RETURNS QUERY BASED ON
END; --TELLS SQL THIS IS WHERE TO STOP THE CURRENT PROCESS


SELECT bornAfter68(); --TELLS SQL TO SELECT THIS VALUE FROM THE TABLE



CREATE OR REPLACE FUNCTION firstAndLastNames() --CREATE A NEW FUNCTION OR REPLACE A CURRENT
returns TABLE (fname VARCHAR, lname VARCHAR) AS $$ -- TELLS SQL TO RETURN THE SELECTED VARIABLES AS A NUMERICAL VALUE
BEGIN -- TELLS SQL TO BEGIN PROCESS THAT FOLLOWS
    RETURN QUERY SELECT firstname, lastname FROM employee; --TELLS SQL TO RETURN THE SELECTED QUERY FROM THE SELECTED TABLE(IN THIS CASE EMPLOYEE)
END; --TELLS SQL TO


SELECT * FROM firstAndLastNames(); --tells sql to select all data based on chosen value


CREATE OR REPLACE FUNCTION updateEmployee(e_id int, firstnameinput VARCHAR, lastnameinput VARCHAR, titleinput VARCHAR, reportstoinput INT, birthdateinput TIMESTAMP, hiredateinput timestamp, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar)
returns VALUE AS $$ --THE NEWLY CREATED OR REPLACED FUNCTION(SEE LINE 135) WILL RETURN A VALUE INTO A NUMERICAL TYPE
BEGIN -- BEGIN THE FOLLOWING PROCESS
    UPDATE employee SET firstname = firstnameinput, lastname = lastnameinput, title = titleinput, reportsto = reportstoinput, birthdate = birthdateinput, hiredate = hiredateinput, address = addressinput, city = cityinput, state = stateinput, country = countryinput, postalcode = postalcodeinput, phone = phoneinput, fax = faxinput, email = emailinput
        WHERE employeeid = e_id; --TELLS SQL TO UPDATE THE SELECTED VALUES 
END; --TELLS SQL TO STOP THE CURRENT PROCESS


SELECT updateEmployee(10, 'Jack'::varchar, 'John'::varchar, 'Jane'::varchar, 2, '1998-10-12'::timestamp, '2011-06-38'::timestamp, '17 Maple St'::varchar, 'Tampa Bay'::varchar, 'FL'::varchar, 'CAN'::varchar, '42934'::varchar, '+1 425-2348'::varchar, '+1 712-3812'::varchar, 'tina@chinookcorp.com'::varchar);


CREATE OR REPLACE FUNCTION employeeManager(e_id int) -- TELLS SQL TO CREATE OR REPLACE A NEW FUNCTION BASED ON SELECTED VALUE
returns text as $$  --RETURNS SELECTED VARCHAR AS A NUMERICAL VALUE
BEGIN -- SAME AS LINE 137
RETURN (SELECT lastname FROM employee WHERE employeeid = ( --RETURNS THE SELECTED VALUES BASED UPON THE SELECTED CODE UPON EXECUTING THE CODE
        SELECT reportsto FROM employee WHERE employeeid = e_id --SELECTS A CERTAIN VALUE BASED ON SPECIFIED VALUE
);
END; --STOPPING POINT FOR THE CURRENT PROCESS


SELECT employeeManager(7); --SELECTS SPECIFIED VALUE FORM TABLE


CREATE OR REPLACE FUNCTION customerSearch(c_id int)-- SAME AS LINE 146
returns TABLE (customer_fname varchar, customer_lname varchar, customer_company varchar) as $$ -- RETURNS VALUE TYPE IWITHIN TABLE AS A NUMERICAL TYPE
BEGIN -- SAME AS LINE 148
	RETURN QUERY (select firstname, lastname, company from customer where customerid = c_id);-- RETURNS SELECTED VALUES FROM QUERY
END; -- ENDS CURRENT PROCESS


SELECT * FROM customerSearch(10); -- SELECTS ALL VALUES FROM THE SPECIFIED VALUE


CREATE OR REPLACE FUNCTION deleteInvoice(invoice_id_input int)-- CREATES A NEW FUNCTION OR REPLACES THE CURRENT ONE
returns VALUE AS $$  -- RETURNS THE SELECTED VALUES AS NUMERICAL TYPE
BEGIN --BEGINS PROCESS
	DELETE FROM invoice WHERE invoiceid = invoice_id_input; -- DELETES SPECIFIC VALUE BASED ON WHICH VALUE THAT HAS BEEN CHOSEN
END; --ENDS THE CURRENT PROCESS


ALTER TABLE invoiceline--ALLOWS ALTERATION OF THE SELECTED TABLE
DROP CONSTRAINT fk_invoicelineinvoiceid; -- DROPS CONSTRAINTS WITHIN THE SPECIFIED FKEY

ALTER TABLE invoiceline --SAME AS LINE 175
ADD CONSTRAINT fk_invoicelineinvoiceid --ADDS NEW FKEY TO SELECTED TABLE
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE on UPDATE CASCADE;-- FKEY IS USED TO REFER TO THE SELECTED VALUE WITH CASCADE BEING USED TO
                                                                                            -- TO SYNCHRONIZE THE REFERENCE VALUES
SELECT deleteInvoice(407); --SELECTS A SPECIFIC VALUE FROM ASSOCIATED TABLE


CREATE OR REPLACE FUNCTION insertCustomer(customeridinput int, firstnameinput varchar, lastnameinput varchar, companyinput varchar, addressinput varchar, cityinput varchar, stateinput varchar, countryinput varchar, postalcodeinput varchar, phoneinput varchar, faxinput varchar, emailinput varchar, supportrepidinput int)
returns VALUE AS $$ --CREATES OR REPLACES FUNCTION AND CONVERTS VALUE INTO A NUMERICAL TYPE
BEGIN--BEGINS THE FOLLOWING PROCESS
    INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) --INSERTS NEW VALUES INTO THE SPECIFIED TABLE
        VALUES (customeridinput, firstnameinput, lastnameinput, companyinput, addressinput, cityinput, stateinput, countryinput, postalcodeinput, phoneinput, faxinput, emailinput, supportrepidinput); 
END;--ENDS THE CURRENT PROCESS


SELECT insertCustomer(63, 'Yost'::varchar, 'Steph'::varchar, 'Nappins'::varchar, '384 5th Ave'::varchar, 'Tampa'::varchar, 'FL'::varchar, 'USA'::varchar, '61234'::varchar, '+1 382-29238'::varchar, '+1 382-9182'::varchar, 'steph@gmail.com'::varchar, 3);--SELECETS SPECIFICS FORM A SELECTED TABLE


CREATE TRIGGER employee_insert --CREATES A NEW TRIGGER
    AFTER INSERT ON employee 
    FOR EACH ROW
    EXECUTE PROCEDURE example_function();--EXECUTES A SPECIFIC FUNCTION FOR ALL ROWS INDIVIDUALLY AFTER EVENT


CREATE TRIGGER customer_update
    AFTER UPDATE ON customer
    FOR EACH ROW
    EXECUTE PROCEDURE example_function(); --EXECUTES A SPECIFIC FUNCTION FOR ALL ROWS INDIVIDUALLY AFTER EVENT


CREATE TRIGGER customer_delete
    AFTER DELETE ON customer
    FOR EACH ROW
    EXECUTE PROCEDURE example_function(); --EXECUTES A SPECIFIC FUNCTION FOR ALL ROWS INDIVIDUALLY AFTER EVENT


SELECT firstname, lastname, invoiceid FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid; --


SELECT customer.customerid, firstname, lastname, invoiceid, total FROM customer FULL OUTER JOIN invoice on customer.customerid = invoice.customerid;
--SELECTS VALUES FROM A TABLE AND RETURNS MACTING VALUES VIA FULL JOIN



SELECT NAME, title FROM album RIGHT JOIN artist ON album.artistid = artist.artistid;
-- SELECTS A SET OF VALUES FROM THE SECOND RIGHTMOST TABLE AND JOINS IT WITH THE RIGHT LEFTMOST TABLE


SELECT NAME AS artist, title AS album FROM artist -- SELECTS SPECIFIC VALUES FORM A TABLE
CROSS JOIN album WHERE artist.artistid = album.artistid --MULTIPLIES THE NUMBER OF FIRST ROWS BY THE NUMBER OF SECOND ROWS HOWEVER USING THE WHERE CLAUSE MAKES IT SIMILAR TO A INNER JOIN
ORDER BY artist.NAME ASC; --ORDERS THE VALUE BY SPECIFIED INFO


SELECT A.firstname AS firstname, A.lastname AS lastname, A.title, B.lastname AS reportsto from employee A, employee B where A.reportsto = B.employeeid; 
--SELECTS VALUES AND USES AS TO JOIN ANOTHER SELECTION OF VALUES WITH ITSELF