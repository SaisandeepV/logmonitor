LogMonitor
Overview

LogMonitor is a Spring Boot application designed to capture and manage application logs. It allows you to:

Record logs with levels (INFO, WARN, ERROR)

Generate alerts automatically for ERROR logs

Filter logs by service or level

Retrieve all generated alerts

This project demonstrates RESTful APIs with Spring Boot, Spring Data JPA, and an in-memory H2 database.

Technologies Used

Java 17

Spring Boot 3.5.5

Spring Data JPA

H2 Database (In-memory)

Maven

Postman (for API testing)

Project Structure
src/main/java/com/example/logmonitor/
├── controller/
│   ├── LogController.java
│   └── AlertController.java
├── model/
│   ├── LogEntry.java
│   └── Alert.java
├── repository/
│   ├── LogEntryRepository.java
│   └── AlertRepository.java
├── service/
│   └── LogService.java
└── LogmonitorApplication.java

REST API Endpoints
1. Create Log

URL: POST /api/logs

Request Body:

{
    "timestamp": "2025-09-01T18:00:00",
    "level": "ERROR",
    "message": "Login failed",
    "service": "AuthService"
}


Response: Returns the saved log entry.

2. Get Logs

URL: GET /api/logs

Query Parameters (Optional):

level – filter by log level

service – filter by service name

Response: List of matching log entries.

3. Get Alerts

URL: GET /api/alerts

Response: List of all alerts generated from ERROR logs.

How to Run

Clone the repository:

git clone <your-repo-url>


Navigate to the project directory:

cd logmonitor


Build the project with Maven:

mvn clean install


Run the application:

mvn spring-boot:run


Access APIs using Postman or curl:

Base URL: http://localhost:8080/api

Testing

You can test the application in Postman:

Create log entries via POST /api/logs

Fetch logs via GET /api/logs

Fetch alerts via GET /api/alerts

Notes

The application uses H2 in-memory database, so data is lost when the application stops.

Alerts are automatically created for logs with ERROR level.

Line endings warnings on Windows (LF will be replaced by CRLF) can be ignored.

License

This project is for educational purposes.
