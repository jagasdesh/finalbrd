--------------------------------------------------------
--  File created - Tuesday-November-27-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TEMP_MAKERST
--------------------------------------------------------

  CREATE TABLE "HR"."TEMP_MAKERST" 
   (	"USERNAME" VARCHAR2(30 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"TYPE" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
