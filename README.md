This CRUD APP IS CREATED BY JAVA Spring Framework using
Client Manager Application

Overview

The Client Manager Application is a web-based system designed to manage client information efficiently. It provides a user-friendly interface for creating, updating, viewing, and deleting client records. Built using Spring Boot and Thymeleaf, the application leverages modern web technologies to deliver responsive and interactive functionality.

Features

Client Management: Create, read, update, and delete client records.

Dynamic Forms: A form for managing client details using Thymeleaf.

Validation: Built-in validation for client fields such as email, phone, and required fields.

Status Management: Track client statuses (e.g., New, Permanent, Lead, Occasional, Inactive).

Responsive Design: Bootstrap-powered UI for better usability on all devices.

Technologies Used

Backend: Spring Boot (Java)

Frontend: Thymeleaf, HTML5, CSS3, Bootstrap 5

Database: H2 (or your preferred relational database)

Tools: IntelliJ IDEA, Maven, Git

Installation

Clone the Repository:

git clone <repository-url>
cd <repository-folder>

Build the Project:
Ensure you have Maven installed.

mvn clean install

Run the Application:

mvn spring-boot:run

Access the Application:
Open your browser and navigate to:

http://localhost:8080

Usage

Home Page:

Displays a list of all clients with their details.

Includes "Edit" and "Delete" buttons for each client.

Add a New Client:

Click the "New Client" button to open the client form.

Fill in the required fields and submit the form.

Edit an Existing Client:

Click the "Edit" button next to a client to update their details.

Delete a Client:

Click the "Delete" button to remove a client after confirmation.

Folder Structure

src/main/java: Contains the Java source files (controllers, services, models, etc.).

src/main/resources: Includes Thymeleaf templates, application properties, and static assets.

README.md: Documentation for the project.

Screenshots

Client List

A table displaying client details with Edit and Delete actions.

Client Form

A form for creating or updating client details.

Future Enhancements

Add user authentication and role-based access control.

Enable searching and filtering of client records.

Integrate with an external database like MySQL or PostgreSQL.

Contributing

Contributions are welcome! Please follow these steps:

Fork the repository.

Create a feature branch.

Commit your changes.

Push to your fork.

Open a pull request.

License

This project is open-source and available under the MIT License.



