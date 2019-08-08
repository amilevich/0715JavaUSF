/*
PL/SQL - Procedural Language/Structured Query Language
It is an extension of Oracle
-- functions, stored procedures, triggers, sequences and cursors
-- exception handling
-- in other words, it provides a means to write actual code in SQL
*/

-- SEQUENCE
-- AN OBJECT THAT WILL MAINTAIN A COUNTER FOR YOU
CREATE SEQUENCE emp_seq2
    START WITH 150
    INCREMENT BY 1;
    --This sequence can be used to handle the id field for employees.
/

SELECT * FROM employees;
DELETE FROM employees WHERE e_id=150;
INSERT INTO employees (e_name, e_salary, e_title) VALUES ('Mario', 100, 'Plumber');

--TRIGGER
--An object that we can create that waits for actions to occur
--based on a specific table the trigger was made for
CREATE TRIGGER emp_seq_trigger2 --naming the trigger
BEFORE INSERT ON employees -- when and what action happens 'AFTER'
FOR EACH ROW
BEGIN --signifies a block for a transaction
    IF :new.e_id IS NULL THEN
    SELECT emp_seq2.nextval INTO :new.e_id FROM dual;
    END IF;
END;
/

INSERT INTO employees VALUES(null, 'Maria', 2, 'Unemployed');
--we can put null because of the specified condition for our trigger
--which will input the next value of the sequence into this id
SELECT * FROM employees;

--STORED PROCEDURES
--A named transacation that can be invoked when called (method in Java).

CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello world, peoples');
END;
/

BEGIN
    hello_world_procedure();
END;
/

EXECUTE hello_world_procedure();

--FUNCTIONS
--method in Java
/*
FUNCTIONS                       STORED PROCEDURES
have a return type              no return type
only IN parameters              IN and OUT parameters
only DQL                        DML and DQL
can not call SP from a function can call a function from a SP
*/

CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
    max_id NUMBER(6); --define parameter
BEGIN
    SELECT MAX(e_id) INTO max_id FROM employees;
    RETURN max_id;
END;
/

DECLARE max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('Largest employee id: ' || max_id);
END;
/

/*
CURSORS
- a cursor is essentially a pointer to a table or a view.
We can use them to iterate through entire queries from the database.

CURSOR and SYS_REFCURSOR
The SYS_REFCURSOR is a stronger cursor that is allowed to be passed outside
of the scope of the procedure it is in.
A normal CURSOR must be created and must die within the scope of the 
procedure where it was created in.
*/
