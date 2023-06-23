# Online Food Ordering System

## Prerequisites

Before running the application, ensure that the following software is installed on your system:

- Java Development Kit (JDK) 11 or later
- Apache Maven
- PostgreSQL

## Getting Started

To set up and run the application, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your/repository.git

2. Configure the database connection:

   Open the `application.yml` file located in the src/main/resources directory. Update the following properties with your PostgreSQL database information:
   ```bash
   spring:
    ...
    ...
    datasource:
    username: your_username
    password: your_password
    url: jdbc:postgresql://localhost:5432/your_database_name

3. Build the application
   ```bash
   mvn clean install

4. Run the application
   ```bash
   mvn spring-boot:run

The application will start running on `http://localhost:8080`.

## API Documentation

To refer to the API Documentation (Created with Swagger), use this endpoint:

`http://localhost:8080/swagger-ui/index.html`


## Stack and Tools

- SpringBoot (Java)
- PostreSQl
- Spring Data JPA
- MapStruct
- Swagger (For Documentation)