CREATE DATABASE gabebank;

CREATE TABLE useraccounts
(
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE employees
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  employeeid INT NOT NULL,
  isadmin BOOLEAN NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (employeeid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE applications
(
  applicationid INT NOT NULL,
  PRIMARY KEY (applicationid)
);

CREATE TABLE applicants
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE bankaccounts
(
  bankaccountid INT NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  PRIMARY KEY (bankaccountid)
);

CREATE TABLE accountdetails
(
  currency CHAR NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE customers
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  customerid INT NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (customerid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE bankaccountsofcustomers
(
  bankaccountid INT NOT NULL,
  customerid INT NOT NULL,
  FOREIGN KEY (bankaccountid) REFERENCES bankaccounts(bankaccountid),
  FOREIGN KEY (customerid) REFERENCES customers(customerid)
);
CREATE TABLE useraccounts
(
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE employees
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  employeeid INT NOT NULL,
  isadmin BOOLEAN NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (employeeid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE applications
(
  applicationid INT NOT NULL,
  PRIMARY KEY (applicationid)
);

CREATE TABLE applicants
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE bankaccounts
(
  bankaccountid INT NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  PRIMARY KEY (bankaccountid)
);

CREATE TABLE accountdetails
(
  currency CHAR NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE customers
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  customerid INT NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (customerid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE bankaccountsofcustomers
(
  bankaccountid INT NOT NULL,
  customerid INT NOT NULL,
  FOREIGN KEY (bankaccountid) REFERENCES bankaccounts(bankaccountid),
  FOREIGN KEY (customerid) REFERENCES customers(customerid)
);
CREATE TABLE useraccounts
(
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE employees
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  employeeid INT NOT NULL,
  isadmin BOOLEAN NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (employeeid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE applications
(
  applicationid INT NOT NULL,
  PRIMARY KEY (applicationid)
);

CREATE TABLE applicants
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE bankaccounts
(
  bankaccountid INT NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  PRIMARY KEY (bankaccountid)
);

CREATE TABLE accountdetails
(
  currency CHAR NOT NULL,
  sharingtype VARCHAR NOT NULL,
  amount NUMERIC NOT NULL,
  applicationid INT NOT NULL,
  FOREIGN KEY (applicationid) REFERENCES applications(applicationid)
);

CREATE TABLE customers
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  customerid INT NOT NULL,
  username VARCHAR NOT NULL,
  PRIMARY KEY (customerid),
  FOREIGN KEY (username) REFERENCES useraccounts(username)
);

CREATE TABLE bankaccountsofcustomers
(
  bankaccountid INT NOT NULL,
  customerid INT NOT NULL,
  FOREIGN KEY (bankaccountid) REFERENCES bankaccounts(bankaccountid),
  FOREIGN KEY (customerid) REFERENCES customers(customerid)
);

INSERT INTO 