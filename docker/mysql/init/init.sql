CREATE DATABASE IF NOT EXISTS bootcamp;

-- create user with password
CREATE USER IF NOT EXISTS 'bootcamp'@'%' IDENTIFIED BY 'bootcamp@db';

-- grant access to user on database
GRANT TRIGGER ON bootcamp.* TO 'bootcamp'@'%';
GRANT ALTER ON bootcamp.* TO 'bootcamp'@'%';
GRANT ALTER ROUTINE ON bootcamp.* TO 'bootcamp'@'%';
GRANT CREATE ROUTINE ON bootcamp.* TO 'bootcamp'@'%';
GRANT DELETE ON bootcamp.* TO 'bootcamp'@'%';
GRANT SELECT ON bootcamp.* TO 'bootcamp'@'%';
GRANT CREATE ON bootcamp.* TO 'bootcamp'@'%';
GRANT EVENT ON bootcamp.* TO 'bootcamp'@'%';
GRANT CREATE TEMPORARY TABLES ON bootcamp.* TO 'bootcamp'@'%';
GRANT CREATE VIEW ON bootcamp.* TO 'bootcamp'@'%';
GRANT INDEX ON bootcamp.* TO 'bootcamp'@'%';
GRANT UPDATE ON bootcamp.* TO 'bootcamp'@'%';
GRANT SHOW VIEW ON bootcamp.* TO 'bootcamp'@'%';
GRANT REFERENCES ON bootcamp.* TO 'bootcamp'@'%';
GRANT INSERT ON bootcamp.* TO 'bootcamp'@'%';
GRANT LOCK TABLES ON bootcamp.* TO 'bootcamp'@'%';
GRANT DROP ON bootcamp.* TO 'bootcamp'@'%';