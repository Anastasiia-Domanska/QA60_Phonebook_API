# QA60 PhoneBook API Testing Project
Project for automating testing of the phone book API.
As part of the project, tests were written to verify the operation of the API and database.

# Technologies used
- **Java 17**
- **Gradle** for dependency management
- **TestNG** (abstractions `@Before`, `@After`, `@Test`)
- **REST Assured** for API tests
- **OkHttp** for HTTP requests
- **MySQL** (checking data in the database)
- **Lombok** (`@Builder`, `@Getter`, `@Setter`, `@ToString`)
- **JSON** for working with queries/responses

# What has been implemented
-**DTO** classes for serialization/deserialization JSON  
- Authorization via API  
- CRUD tests (Create, Read, Update, Delete) for working with contacts  
- Checking data in MySQL via a connector  
- Requests via **OkHttp** and **RestAssured**  
- Configuring tests using TestNG (`@BeforeSuite`, `@AfterSuite`)

# Project structure
QA60_PhoneBook_API
│── build.gradle
│── src
│ ├── main
│ │ ├── dto
│ │ │ ├── AllContactsDTO.java
│ │ │ ├── AllRequestDTO.java
│ │ │ ├── AllResponseDTO.java
│ │ │ ├── ContactDTO.java
│ │ │ ├── ErrorDTO.java
│ │ │ └── PutContactsDTO.java
│ └── test
│ ├── mysqlConnector
│ │ ├── DBData.java
│ │ └── SQLConnectorTests.java
│ ├── okhttp
│ │ ├── OKHttpLogin.java
│ │ └── OKHttpTests.java
│ └── restAssured
│ ├── DeleteContactArrayTests.java
│ ├── GetAllContactsArrayTests.java
│ ├── PutContactsTests.java
│ └── TestBase.java

# The automated tests cover:
user authorization,
retrieving a list of all contacts,
adding, updating, and deleting contacts,
error validation (ErrorDTO).
Data consistency checks are implemented via the MySQL database.
