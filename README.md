# Spring boot assignment

This repository contains the source code for User Service application. It provides instructions on how to set up and run the application locally.

## Prerequisites

Before getting started, make sure you have the following prerequisites installed on your machine:

- Java Development Kit (JDK) SE17
- MySQL database
- Maven

## Getting Started

1. Clone the repository to your local machine:

git clone https://github.com/amritharoshini/spring-boot-assignment.git

2. Navigate to the project directory:
   
cd spring-boot-assignment

4. Set up the MySQL database:

- Create a new database 'user_profile' in your MySQL server.
- Configure the database connection settings in the AppConfig configuration class.

4. Build the application:
   
mvn clean package

6. Run the application:

java -jar target/spring-boot-assignment.jar

6. Access the application:

- Open a web browser.
- Go to http://localhost:8080 to access the application.

## API

1. POST http://localhost:8080/api/v1/auth/register
2. POST http://localhost:8080/api/v1/auth/authenticate
3. POST http://localhost:8080/api/v1/users
4. GET http://localhost:8080/api/v1/users/{email}

## Configuration
You can configure the application by modifying the application.properties file located in the src/main/resources directory. Update the database connection details, server port, and other properties as needed.

## Additional Notes
If you want to run the application in a different port, you can modify the server.port property in the application.properties file.
Make sure the MySQL server is up and running before starting the application.
