# Library Management System - Full Stack

**NUST 2nd Semester Software Engineering Project, March 2026**
This is an end-to-end full-stack application to showcase strong Java OOP skills and modern web development.

## Project Preview
[Library UI Main](Screenshots/ui-main.png)
[Library UI Secondary](Screenshots/ui-main2.png)

## Project Structure
- `/backend` → Spring Boot REST API (Java, OOP, and SOLID principles)
- `index.html` → Responsive single-page frontend (Tailwind and Vanilla JS)
- Data flows live through `fetch()` API calls

## Features
- Dashboard with real-time counts (Books, Members, Issued)
- Full CRUD functionality for Books and Members
- Issue and return books with validation
- Searchable tables
- Dark mode toggle
- Professional, mobile-friendly user interface

## Tech Stack
**Backend:** Java, Spring Boot, REST API, In-memory ArrayList (OOP focused)  
**Frontend:** HTML5, Tailwind CSS, Vanilla JavaScript and fetch()  

## Development Process
- Started with a pure Java OOP console version using my own code and strong second-semester knowledge
- Used Cursor AI to speed up Spring Boot setup and frontend creation
- Manually reviewed, refactored, tested, and connected every part  
- Implemented proper exception handling, validation, and clean architecture

## How to Run
1. Ensure **Java 21** is installed.
2. Run `./mvnw spring-boot:run` or launch `LmsApiApplication.java` from IntelliJ.
3. Access the UI at: `http://localhost:8080`.
4. Access the API at: `http://localhost:8080/api/books`.
