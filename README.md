# Gemini_System_Spring

## Team Members
- 6388052 Runchana Seesung
- 6388117 Siranut Akarawuthi

## Project Description
Gemini_System_Spring is a Spring Boot application that uses Thymeleaf as its template engine. This project covers four functional requirements:

1. User can login/register to the system.
2. Astronomers can create a SciencePlan.
3. Astronomers can test a SciencePlan.
4. Observers can collect astronomical data.

The user authentication service checks the localStorage UserId variable from the browser storage. This feature may be implemented in future phases.

## Running the Application
To run the application, execute the Java file named "GeminiBackendApplication.java". Make sure that the database file is connected to the project and the OCS JAR file is imported to the project structure.

## API Description
The API of this system contains the following endpoints:

### GET
- Get all StarSystems 
(http://localhost:8080/starsystems?id=)
- Get all TelescopeLocations 
(http://localhost:8080/telescopelocations?id=)
- Get all Users 
(http://localhost:8080/users)
- Get all SciencePlans
(http://localhost:8080/scienceplans?id=)
- Get SciencePlan by ID
(http://localhost:8080/scienceplan?id=&planNo=)
- Get astronomical data
(http://localhost:8080/getastronomicaldata?id=&planNo=)
- Test SciencePlan
(http://localhost:8080/testscienceplan?id=&sciplan=)
- Get user permission
(http://localhost:8080/getperms?id=)
- Get user username
(http://localhost:8080/usersname?id=)
- Update SciencePlan status
(http://localhost:8080/setsciplanstatus?id=&planNo=&status=)

### POST
- Create a new user
(http://localhost:8080/adduser)
- Create a new SciencePlan
(http://localhost:8080/scienceplans?id=)

Make sure to replace the values in the URLs enclosed in angle brackets with the appropriate values.

## Quick Peek of the System

- `/`<br>
<img src="/images/login.png" alt="Homepage">

- `/register`<br>
<img src="/images/register.png" alt="Registration page">

- `/astronomer`<br>
<img src="/images/astronomer.png" alt="Astronomer dashboard">

- `/create_scienceplan`<br>
<img src="/images/create.png" alt="Create SciencePlan page">

- `/test_scienceplan`<br>
<img src="/images/test.png" alt="Test SciencePlan page">

- `/observer`<br>
<img src="/images/observer.png" alt="Observer dashboard">

- `/collect_astronomical_data`<br>
<img src="/images/collect.png" alt="Collect astronomical data page">

- `/admin`<br>
<img src="/images/admin.png" alt="Admin">
