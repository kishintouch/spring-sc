MERGE INTO USER_LOGIN
  KEY(ID) 
VALUES
(1, NULL, 1, NULL,NULL,'test','admin@gmail.com');

MERGE INTO USER_DETAILS 
  KEY(ID) 
VALUES
(2,NULL,1,NULL,NULL,45,'test address','test delivery','admin@gmail.com','M','test','1');
