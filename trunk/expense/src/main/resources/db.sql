﻿
DROP DATABASE IF EXISTS TRACKER;

CREATE DATABASE TRACKER;

USE TRACKER;

DROP TABLE IF EXISTS ENTRIES;

DROP TABLE  IF EXISTS GROUPS;

CREATE TABLE GROUPS(
  GROUP_ID INT,
  GROUP_NAME VARCHAR(100),
  GROUP_VALUE VARCHAR(100),
  PRIMARY KEY (GROUP_ID)
);

INSERT INTO GROUPS(GROUP_ID, GROUP_NAME, GROUP_VALUE) VALUES(1, 'INCOME', 'CASH');
INSERT INTO GROUPS(GROUP_ID, GROUP_NAME, GROUP_VALUE) VALUES(2, 'INCOME', 'SALARY');
INSERT INTO GROUPS(GROUP_ID, GROUP_NAME, GROUP_VALUE) VALUES(3, 'INCOME', 'INTEREST');
INSERT INTO GROUPS(GROUP_ID, GROUP_NAME, GROUP_VALUE) VALUES(4, 'INCOME', 'COMISSION');

INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(10,'EXPENSE','Clothing');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(11,'EXPENSE','Entertainment');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(12,'EXPENSE','Food');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(13,'EXPENSE','Gasoline');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(14,'EXPENSE','Out-of-pocket expenses');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(15,'EXPENSE','Bank charges');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(16,'EXPENSE','Business cards');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(17,'EXPENSE','Car insurance');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(18,'EXPENSE','Club sports');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(19,'EXPENSE','Community');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(20,'EXPENSE','Credit cards');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(21,'EXPENSE','Energy');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(22,'EXPENSE','Health insurance');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(23,'EXPENSE','Parking');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(24,'EXPENSE','Professional college');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(25,'EXPENSE','Rental');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(26,'EXPENSE','Studies');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(27,'EXPENSE','Subscriptions');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(28,'EXPENSE','Taxation');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_VALUE)VALUES(29,'EXPENSE','Telecommunications');


CREATE TABLE ENTRIES(
  ENTRY_ID INT AUTO_INCREMENT,
  ENTRY_DATE DATE,
  ENTRY_DETAIL VARCHAR(255),
  GROUP_ID INT,
  AMOUNT DOUBLE(10,2),
  PRIMARY KEY (ENTRY_ID),
  FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID) ON DELETE CASCADE
);

INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT) VALUES(curdate(),'test entry',10,57.00);

INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT) VALUES(curdate(),'a sample description',13,94.00);

INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT) VALUES( adddate(curdate(), 2) ,'testing',15,91.00);

INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT) VALUES( adddate(curdate(), 2) ,'testing exp',15,100.00);

INSERT INTO ENTRIES(ENTRY_DATE,ENTRY_DETAIL,GROUP_ID,AMOUNT) VALUES( adddate(curdate(), 9) ,'test income',1,10000.00);


-- stats

select sum(e.amount) as total,g.group_value as item from entries e join groups g on e.group_id=g.group_id group by g.group_value ;

select * from entries where extract( month from entry_date) >= extract(MONTH from CURRENT_DATE);