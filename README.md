Project Overview
This is a simple task tracker system built with Spring Boot. It provides basic CRUD (Create, Read, Update, Delete) operations for managing tasks, including the ability to search tasks by title and change their status. It uses an in-memory H2 database for storage and exposes a RESTful API for interaction.

Setup Instructions
1. Clone the repository
Start by cloning the repository to your local machine.

git clone https://github.com//SyedSaood/tasktrackersystem.git
cd task-tracker
2. Build the project
The project can be built using Maven or Gradle. To build the project with Maven, run the following command:

mvn clean install
For Gradle, you can use:


gradle build
3. Run the application
Once the build is complete, you can run the Spring Boot application using Maven or Gradle:

With Maven:

mvn spring-boot:run
With Gradle:

gradle bootRun
The application will start running on port 8080 by default.

How to Run
After the application has started, you can interact with the task tracker system using Postman or any other HTTP client.

API Endpoints
Create Task:

POST /tasks

Request Body:json
{
    "title": "Test Task",
    "description": "This is a test task",
    "status": "Not Done"
}
Get All Tasks:

GET /tasks

Response:json

[
    {
        "id": 1,
        "title": "Test Task",
        "description": "This is a test task",
        "status": "Not Done"
    }
]
Update Task:

PUT /tasks/{id}

Request Body:json

{
    "title": "Updated Task",
    "description": "This is an updated task",
    "status": "Done"
}
Delete Task:

DELETE /tasks/{id}

Response: HTTP 204 No Content

Change Status of Task:

PATCH /tasks/{id}/status?status=Done

Response:json

{
    "id": 1,
    "title": "Test Task",
    "description": "This is a test task",
    "status": "Done"
}
Search Tasks by Title:

GET /tasks/search?title={title}

Response:json

[
    {
        "id": 1,
        "title": "Test Task",
        "description": "This is a test task",
        "status": "Done"
    }
]
Project Structure
The project is structured as follows:

src/main/java/com/example/tasktracker
    ├── controller
    │      └── TaskController.java         # REST API controller for handling task-related operations
    ├── service
    │      └── TaskService.java            # Service interface for task-related operations
    │      └── TaskServiceImpl.java        # Service implementation for task-related operations
    ├── repository
    │      └── TaskRepository.java         # JPA repository interface for interacting with the database
    ├── model
    │      └── Task.java                   # Entity class representing a task
    └── TaskTrackerApplication.java        # Main class to run the Spring Boot application
Configuration
application.properties
This configuration file sets up the in-memory H2 database and enables the H2 console for easy access to the database.

properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
Dependencies


The project uses the following key dependencies:
Spring Boot Starter Web: For building the RESTful API.
Spring Data JPA: For interacting with the database using JPA.
H2 Database: For in-memory database support during development.
Spring Boot DevTools: (Optional) For hot-reloading during development.
You can add or remove dependencies in the pom.xml file if necessary.

Testing the API
To test the endpoints, you can use Postman.

Create Task: Send a POST request to /tasks with the task data in the request body.
Get All Tasks: Send a GET request to /tasks to retrieve all tasks.
Update Task: Send a PUT request to /tasks/{id} with updated task data.
Delete Task: Send a DELETE request to /tasks/{id} to delete a task.
Change Status: Send a PATCH request to /tasks/{id}/status?status=Done to change the status of a task.
Search Task by Title: Send a GET request to /tasks/search?title={title} to search tasks by their title.
Documentation
Task Model
java

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    
    // Getters and Setters
}
The Task model represents the task entity with fields for id, title, description, and status.

TaskService Interface
java
public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task changeTaskStatus(Long id, String status);
    List<Task> searchTaskByTitle(String title);
}
The TaskService interface defines the operations for managing tasks, including creating, retrieving, updating, deleting tasks, changing status, and searching tasks by title.

TaskServiceImpl Implementation
java
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    
    // Constructor and methods implementation
}
