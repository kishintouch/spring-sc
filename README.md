spring-sc :
This project exposes a set of Rest API's which is required for building Shopping Cart .Rest API end points are secured by JWT tokens .To Run this project checkout from git hub 
and follow below mentioned steps .

1.spring-sc maven pom is configured for building jar hence it can run as stand alone webapplication (spring boot embedded tomcat server).once the project is opened
it can be run as Java application and its End points are available at 'http://localhost:8080'.

2.create login ,create user , add products REST API are not secured in order create necessary base data for project to get up and running.Using Attached PostMan Collections we can 
create user for login and add products .

3.This project uses H2 database and hence create folder at C:\data for default configuration or configure required DB details in application.properties.

4.This project by default is configured to get request only from http://localhost:3000/ , if this needs to changed then configure WebSecurityConfig -> corsConfigurationSource.
To add products via post man we need to configure configuration.setAllowedOrigins(Arrays.asList("*"));


spring-sc/shopping-cart-ui/ :
shopping cart ui is developed in React JS .Navigate to the folder spring-sc\shopping-cart-ui and do npm install to download the necessary node modules.
After downloading necessary modules start the ui with commans npm start .This will start app in http://localhost:3000/ .Base_URL of repository.js is configured 
to default project running from embedded to tomcat server , if the REST_API end points are deployed in stand alone server then url needs to be changed accordingly.



Swagger UI :
Swagger UI is configured at the below mentioned URL .Swagger API configuration is done only for few API(Cart Controller - get cart by User id and for other api default swagger configurations 
is used.Need to enhance swagger documentation for each API.

Swagger API Docs  - http://docs.swagger.io/swagger-core/apidocs/
Swagger UI - http://localhost:8080/swagger-ui.html#/
Swagger api-docs for app - http://localhost:8080/v2/api-docs