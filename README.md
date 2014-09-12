# Micro service POC with spring-boot
Micro service POC with spring-boot. Using Swagger for API documentation. Tomcat embedded. 

## Prerequisites
* Install Maven (brew install maven)
* MySQL

## Database configuration
The following DB configuration is used in the project ```demo/src/main/resources/application.properties```<br>
 spring.datasource.url=jdbc:mysql://localhost:3306/phone_book <br>
 spring.datasource.username=root <br>
 spring.datasource.password=root <br>
 
 
* Make sure mysql is running on port 3306(default). 
* Create "phone_book" schema and user "root" as access to it.

## Running Service
* cd demo
* mvn spring-boot:run

## Service Verification
[http://localhost:8080/docs/index.html](http://localhost:8080/docs/index.html)
