
# SpringPortal

This is a Spring Boot application that implements a user login system with custom authentication, redirection, and dynamic data display. The application is built with the Spring Security module for secure authentication, Thymeleaf for rendering views, and Hibernate for persistence.

## Features
- **Login system**: Custom login page with Spring Security integration.
- **User Authentication**: Allows users to authenticate with a simple form login.
- **Redirection**: Redirects the user to the home page (`/home`) after successful login.
- **Dynamic Data**: Displays dynamic data (like the username) on the home page once the user is logged in.
- **Logout functionality**: Secure logout with session invalidation.

## Tech Stack
- **Spring Boot**: Framework for building Java applications.
- **Spring Security**: For authentication and authorization.
- **Thymeleaf**: A templating engine for rendering views.
- **BCryptPasswordEncoder**: For password encryption.
- **Maven**: Dependency management and build tool.

## Prerequisites

To run this project locally, you'll need:

- JDK 17 or above.
- Maven 3.8+ (for building the project).
- An IDE like IntelliJ IDEA or Eclipse (optional but recommended).

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/springportal.git
cd springportal
```

### 2. Install dependencies

Make sure you have Maven installed. Run the following command to download all the dependencies:

```bash
mvn install
```

### 3. Run the application

To start the application, use the command below:

```bash
mvn spring-boot:run
```

The application will be running at `http://localhost:8081/`.

### 4. Access the login page

Once the application is running, navigate to `http://localhost:8081/login` in your browser. Use the login credentials to access the application.

### 5. Access the home page

After a successful login, you will be redirected to the home page where you can see dynamic data such as your username.

## Folder Structure

```
springportal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── springportal/
│   │   │               ├── config/
│   │   │               ├── controllers/
│   │   │               ├── services/
│   │   │               └── SpringPortalApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   │   ├── login.html
│   │   │   │   ├── home.html
│   │   │   │   └── error.html
│   │   │   ├── application.properties
│   │   └── pom.xml
└── README.md
```

## Contributing

1. Fork the repository.
2. Create your branch: `git checkout -b feature/YourFeature`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature/YourFeature`.
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
