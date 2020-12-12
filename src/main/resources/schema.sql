DROP SCHEMA IF EXISTS BCI CASCADE;
CREATE SCHEMA BCI;

DROP TABLE IF EXISTS BCI.USERS;
CREATE TABLE BCI.USERS (
  USER_ID VARCHAR(250) NOT NULL,
  INSERT_DATE TIMESTAMP,
  UPDATE_DATE TIMESTAMP,
  USER_NAME VARCHAR(250),
  USER_EMAIL VARCHAR(250),
  USER_PASSWORD VARCHAR(250),
  TOKEN VARCHAR(250),
  LAST_LOGIN TIMESTAMP,
  IS_ACTIVE BOOLEAN,
  CONSTRAINT "PK_USERS" PRIMARY KEY ("USER_ID")
  );
  
DROP TABLE IF EXISTS BCI.PHONES;
CREATE TABLE BCI.PHONES (
  PHONE_ID INT auto_increment NOT NULL,
  INSERT_DATE TIMESTAMP, 
  PHONE_NUMBER INT,
  CITY_CODE INT,
  COUNTRY_CODE INT,
  USER_ID INT,
  CONSTRAINT "PK_PHONES" PRIMARY KEY ("PHONE_ID"),
  CONSTRAINT "FK_USER_PHONE" FOREIGN KEY ("USER_ID") REFERENCES BCI."USERS" ("USER_ID")
  );
  