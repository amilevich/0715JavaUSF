CREATE TABLE TA(
    nums NUMBER(6),
    chars VARCHAR2(10)
);
CREATE TABLE TB(
    other_nums NUMBER(6),
    other_chars VARCHAR2(10)
);

INSERT INTO TA VALUES(1, 'a');
INSERT INTO TA VALUES(2, 'b');
INSERT INTO TA VALUES(3, 'c');
INSERT INTO TA VALUES(4, 'd');

INSERT INTO TB VALUES(3, 'C');
INSERT INTO TB VALUES(4, 'D');
INSERT INTO TB VALUES(5, 'E');
INSERT INTO TB VALUES(6, 'F');
INSERT INTO TB VALUES(7, 'G');

SELECT * FROM TA;
SELECT * FROM TB;

SELECT * FROM TA INNER JOIN TB ON TA.nums = TB.other_nums;

SELECT * FROM TA LEFT JOIN TB ON TA.nums = TB.other_nums ORDER BY TA.nums;
SELECT * FROM TA RIGHT JOIN TB ON TA.nums = TB.other_nums ORDER BY TB.other_nums;

SELECT * FROM TA FULL OUTER JOIN TB ON TA.nums = TB.other_nums ORDER BY TA.nums;

SELECT * FROM TA CROSS JOIN TB ORDER BY TA.nums;

CREATE TABLE emps(
    emp_id NUMBER(6) PRIMARY KEY,
    emp_name VARCHAR2(100),
    super_id NUMBER(6),
    CONSTRAINT some_fk FOREIGN KEY (super_id) REFERENCES emps(emp_id)
);
INSERT INTO emps VALUES(3, 'Jesus', null);
INSERT INTO emps VALUES(1, 'Roger', 3);
INSERT INTO emps VALUES(2, 'Nick', 3);
INSERT INTO emps VALUES(4, 'George', 2);
INSERT INTO emps VALUES(5, 'Giorgio', 4);
--have to order the inserts to not violate the foreign key constraint
SELECT * FROM emps;

SELECT a.emp_name, COUNT(a.emp_id) FROM emps a 
INNER JOIN emps b
ON a.emp_id = b.super_id
GROUP BY a.emp_name;
--two columns, one with employee names and the other with the count of 
--how many emps report to them

SELECT * FROM emps a, emps b WHERE a.super_id = b.emp_id;
--self join

--SET OPERATORS
SELECT nums, chars FROM TA UNION SELECT other_nums, LOWER(other_chars) FROM TB;
SELECT nums, chars FROM TA UNION ALL SELECT other_nums, LOWER(other_chars) FROM TB;

SELECT nums, chars FROM TA INTERSECT SELECT other_nums, LOWER(other_chars) FROM TB
ORDER BY nums;

SELECT nums, chars FROM TA MINUS SELECT other_nums, LOWER(other_chars) FROM TB
ORDER BY nums;

/*
Views - virtual tables that can be created to ease the complexity of queries.
You can query a database and save the query + result s et in a virtual table
that can be referenced later or even used in other queries.
*/
