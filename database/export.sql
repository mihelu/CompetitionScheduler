--------------------------------------------------------
--  File created - czwartek-stycze�-17-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COUNTRIES
--------------------------------------------------------

  CREATE TABLE "COMPETITIONSCHEDULER"."COUNTRIES" 
   (	"ID" NUMBER, 
	"CODE" VARCHAR2(3 BYTE), 
	"NAME" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PLAYERS
--------------------------------------------------------

  CREATE TABLE "COMPETITIONSCHEDULER"."PLAYERS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"SURNAME" VARCHAR2(20 BYTE), 
	"NICK" VARCHAR2(50 BYTE), 
	"BIRTHDATE" DATE, 
	"COUNTRY_ID_FK" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "COMPETITIONSCHEDULER"."USERS" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(40 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING INTO COMPETITIONSCHEDULER.COUNTRIES
SET DEFINE OFF;
INSERT INTO COMPETITIONSCHEDULER.COUNTRIES (ID,CODE,NAME) VALUES ('1','POL','Polska');
REM INSERTING INTO COMPETITIONSCHEDULER.PLAYERS
SET DEFINE OFF;
INSERT INTO COMPETITIONSCHEDULER.PLAYERS (ID,NAME,SURNAME,NICK,BIRTHDATE,COUNTRY_ID_FK) VALUES ('1','Gonzalo','Higuain',NULL,NULL,'1');
REM INSERTING INTO COMPETITIONSCHEDULER.USERS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPETITIONSCHEDULER"."USERS_PK" ON "COMPETITIONSCHEDULER"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index COUNTRIES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPETITIONSCHEDULER"."COUNTRIES_PK" ON "COMPETITIONSCHEDULER"."COUNTRIES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PLAYERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPETITIONSCHEDULER"."PLAYERS_PK" ON "COMPETITIONSCHEDULER"."PLAYERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index COUNTRIES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "COMPETITIONSCHEDULER"."COUNTRIES_UK1" ON "COMPETITIONSCHEDULER"."COUNTRIES" ("CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PLAYERS
--------------------------------------------------------

  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" ADD CONSTRAINT "PLAYERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" MODIFY ("COUNTRY_ID_FK" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" MODIFY ("SURNAME" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COUNTRIES
--------------------------------------------------------

  ALTER TABLE "COMPETITIONSCHEDULER"."COUNTRIES" ADD CONSTRAINT "COUNTRIES_UK1" UNIQUE ("CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "COMPETITIONSCHEDULER"."COUNTRIES" ADD CONSTRAINT "COUNTRIES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "COMPETITIONSCHEDULER"."COUNTRIES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."COUNTRIES" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."COUNTRIES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "COMPETITIONSCHEDULER"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "COMPETITIONSCHEDULER"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "COMPETITIONSCHEDULER"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PLAYERS
--------------------------------------------------------

  ALTER TABLE "COMPETITIONSCHEDULER"."PLAYERS" ADD CONSTRAINT "PLAYERS_COUNTRIES_FK1" FOREIGN KEY ("COUNTRY_ID_FK")
	  REFERENCES "COMPETITIONSCHEDULER"."COUNTRIES" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "COMPETITIONSCHEDULER"."CUSTOM_AUTH" (p_username IN VARCHAR2, p_password IN VARCHAR2)
return BOOLEAN
IS
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on DATE;
  l_count NUMBER;
BEGIN
-- First, check to see if the user is in the user table
SELECT COUNT(*) INTO l_count FROM demo_users WHERE user_name = p_username;
if l_count > 0 THEN
  -- First, we fetch the stored hashed password & expire date
  SELECT password, expires_on INTO l_stored_password, l_expires_on
   FROM demo_users WHERE user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate OR l_expires_on IS NULL THEN

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password THEN
      return TRUE;
    ELSE
      return FALSE;
    END if;
  ELSE
    return FALSE;
  END if;
ELSE
  -- The username provided is not in the DEMO_USERS table
  return FALSE;
END if;
END;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "COMPETITIONSCHEDULER"."CUSTOM_HASH" (p_username IN varchar2, p_password IN varchar2)
return varchar2
IS
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'LJOTGXVK8NDB18IAO39E4DPQBGOBUV';
BEGIN

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
END;

/