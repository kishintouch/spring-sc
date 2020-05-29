MERGE INTO USER_LOGIN
  KEY(ID) 
VALUES
(1, NULL, 1, NULL,NULL,'test','admin@gmail.com');

MERGE INTO USER_DETAILS 
  KEY(ID) 
VALUES
(2,NULL,1,NULL,NULL,45,'test address','test delivery','admin@gmail.com','M','test','1');

MERGE INTO PRODUCTS 
  KEY(ID) 
VALUES
(1, NULL, 1, NULL,NULL,'Nokia','Nokia Mobile 5120','N345','Nokia Super',325,null);

MERGE INTO PRODUCTS 
  KEY(ID) 
VALUES
(2, NULL, 1, NULL,NULL,'Sony','Sony Mobile 5120','S345','Sony Ericsson Super',1000,null);


