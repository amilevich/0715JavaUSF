--this is a sql developer comment
/*
THIS IS A MULTI LINE COMMENT
*/

CREATE TABLE animals(
    animal_id NUMBER(6)PRIMARY KEY,  --999999
    animal_name VARCHAR2(100),
    animal_leg_count NUMBER(3) --999
);

SELECT * FROM animals;

INSERT INTO animals (animal_id, animal_name, animal_leg_count)
VALUES (1, 'Tiger', 4);
--if you omit column names, it will implicitly assume you are providing data
--for each column in the order that they appear in the table
INSERT INTO animals VALUES(2, 'Penguin', 2);

CREATE TABLE dinosaurs (
    dino_id NUMBER(6) PRIMARY KEY,
    dino_diet VARCHAR2(30) NOT NULL,
    dino_weight NUMBER(9),
    dino_species VARCHAR2(50) UNIQUE,
    CONSTRAINT dino_weight_check CHECK (dino_weight BETWEEN 1000 AND 999999) 
);

SELECT * FROM dinosaurs;

INSERT INTO dinosaurs VALUES(1, 'Herbivore', 30000, 'Phalaphosaraus');
INSERT INTO dinosaurs VALUES(2, 'Carnivore', 1000, 'Pterodactyl');
INSERT INTO dinosaurs VALUES(3, 'Omnivore', 50000, 'Orathureactyal');
INSERT INTO dinosaurs VALUES(4, 'Omnomnomnivore', 100, 'Hooman');

CREATE TABLE flinstones(
    f_id NUMBER(6) PRIMARY KEY,
    f_name VARCHAR2(35) NOT NULL,
    f_steps_per_minute NUMBER(6),
    fk_dino_id NUMBER(6),
    CONSTRAINT owner_id_fk FOREIGN KEY (fk_dino_id) REFERENCES dinosaurs (dino_id) ON DELETE CASCADE
);
INSERT INTO flinstones VALUES(1, 'Fred', 100, 3);
INSERT INTO flinstones VALUES(2, 'Bam Bam', 30, 1);

DROP TABLE flinstones;
SELECT * FROM flinstones;

/*
WHAT ARE CONSTRAINTS?
DEFINE RULES REGARDING THE VALUES ALLOWED IN COLUMNS 
- NOT NULL -> ensures the cell is not empty, must place a value
- UNIQUE -> ensures all values inside this column are distinct (no duplicates)
- PRIMARY KEY -> UNIQUE + NOT NULL
- FOREIGN KEY -> UNIQUE + NOT NULL
- CHECK -> defines a condition to which all values inside of the column must
conform to
*/

SELECT * FROM dinosaurs WHERE dino_id=3;
--WHERE CLAUSE
--use a WHERE clause to apply any conditions to a CRUD operation
UPDATE dinosaurs SET dino_species = 'Falafelesoraus' WHERE dino_id = 3;

SELECT * FROM animals;
DELETE FROM animals WHERE animal_id=1;

INSERT INTO animals VALUES(4, 'Aye Aye', 3);
COMMIT;

TRUNCATE TABLE dinosaurs;

/*
REFERENTIAL INTEGRITY 
THE ENFORCEMENT OF FOREIGN KEY RELATIONS. IT PREVENTS A USER FROM 
INSERTING A RECORD INTO A TABLE WITH A FOREIGN KEY THAT POINTS TO A 
NONEXISTENT ELEMENT.
IT ALSO PREVENTS A USER FROM DELETING A RECORD THAT ANOTHER TABLE IS REFERENCING.
THIS IS ALL TO PREVENT ORPHAN RECORDS, IE, A RECORD WITHOUT A PARENT
*/

CREATE TABLE employees(
    e_id NUMBER(6) PRIMARY KEY,
    e_name VARCHAR2(9) NOT NULL,
    e_salary NUMBER(6),
    e_title VARCHAR2(50)
);
DROP TABLE employees;
INSERT INTO employees VALUES(1,'Carl', 90000, 'Developer');
INSERT INTO employees VALUES(2,'Dylan', 0, 'Developer');
INSERT INTO employees VALUES(3,'Goku', 20000, 'Fighter');
INSERT INTO employees VALUES(4,'Bob', 30000, 'Burger Flipper');
INSERT INTO employees VALUES(5,'Archer', 999999, 'Spy');
INSERT INTO employees VALUES(6,'Brick', 5, 'Shotgunner');
INSERT INTO employees VALUES(7,'006', 60000, 'Spy');

SELECT * FROM employees;

/*
AGGREGATE FUNCTIONS
- IS A FUNCTION YOU APPLY TO A COLUMN THAT WILL PROCESS ALL THE DATA AND 
RETURN A SINGLE VALUE BACK
Examples:
SUM()
AVG()
COUNT()
MAX()
MIN()
*/
SELECT COUNT(*) FROM employees;

SELECT SUM(e_salary), e_title FROM employees GROUP BY e_title;
--GROUP BY -> organizes by specified column, no individual records
SELECT SUM(e_salary), e_title FROM employees GROUP BY e_title ORDER BY SUM(e_salary) DESC;
--ORDER BY -> sorts the data in ascending by default

/*
SCALAR FUNCTIONS
-A FUNCTION THAT APPLIES TO EACH CELL OF A COLUMN AND ALTERS THE VALUE WITHIN
EACH CELL
Examples:
LOWER()
UPPER()
ABS()
ROUND()
TRIM()
LENGTH()
CONCAT()
*/

SELECT UPPER(e_name), LOWER(e_title) FROM employees;

/*
HAVING
-IS A CONDITIONAL THAT CAN BE APPLIES TO AGGREGATE DATA
*/

SELECT SUM(e_salary), LOWER(e_title) FROM employees
WHERE e_salary < 200000
GROUP BY e_title
HAVING SUM(e_salary) > 50000
ORDER BY e_title;

/*
LIKE
- WE USE THE LIKE CLAUSE TO SEARCH FOR DATA THAT MATCHES A SORT OF REGULAR
EXPRESSION CRITERIA.
TWO WILDCARDS:
_ -> ONE of any character
% -> zero-to-many of any character
*/

SELECT * FROM employees WHERE LOWER(e_name) LIKE 'g%';
-- all names that start with 'g', not case sensitive
SELECT * FROM employees WHERE LOWER(e_name) LIKE '%a';
SELECT * FROM employees WHERE LOWER(e_name) LIKE '_r_c_';
