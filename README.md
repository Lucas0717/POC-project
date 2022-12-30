# POC-project
> For this project, we can login by login.html with spring security authentication. We can register user with information id, password, first name, last name, email and so on.

## Main technologies: 
* Spring Web MVC
* Spring Data JPA & Hibernate
* Spring Security
* Spring Boot
* Bootstrap(webjars)
* JUnit
* MySQL

File hierarchy:

* src/main/java
  * User.java: the model that maps to 'User' table in database
  * UserRepository.java: the data access layer which defines methods(findByEmail in my case)
  * AppController.java: handles requests from HTML pages, redirect to signup/login page depends on the request received, Dispatches database operations specified in  *   * UserDAO(Create new user with encrypted password using Spring Security technology, retrieve all users)
  * CustomeUserDetails.java: configuration for authenticated users
  * CustomerUserDetailsService: Operations that can be peformed on the authenticated users
  * WebSecurityConfig.java: config login and logout and encrypt the password.
* src/main/resources
  * index.html homepage for index
  * signup_form.html register page for creating new users
  * register_success.html show the success status after sign-up and with a button to go back to the homepage
  * users.html a view of user list

