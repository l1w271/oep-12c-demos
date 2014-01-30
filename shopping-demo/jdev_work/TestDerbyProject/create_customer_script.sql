CREATE TABLE CUSTOMER ( 
  "CUSTOMER_ID" VARCHAR(40) NOT NULL , 
  "FIRST_NAME" VARCHAR(40) , 
  "LAST_NAME" VARCHAR(40) , 
  "TOTAL_PURCHASES" DECIMAL(10, 2) , 
  "LOYALTY_STATUS" INTEGER NOT NULL DEFAULT 0 
, CONSTRAINT "CUSTOMER_PK" PRIMARY KEY ( "CUSTOMER_ID" ) );
