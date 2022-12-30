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

## File hierarchy:
* src/main/java/com/demo
  * PocTaskApplication.java
  * config
   * AppConfig.java: define beac class and connect to mysql database
   * WebConfig.java: set some permissions for different pages
  * controller
   * UserController: connect with front end with back end, define RESTful APIs
  * exception
   * UserAlreadyExistEception.java: check user exist or not
   * UserNotExistException.java: check user not exist or not 
  * model
   * User.java: define a table to communicate with mysql and json format
  * repository
   * UserRepository.java: to define a repository with JPA repository in user service
  * service
   * UserService.java: deine a service class to communicate with mysql database and implement the real function we do

* src/main/resources
  * register.jsp: register page for creating new users
  * login.jsp: login page to set permission
  * update.jsp: update some informations on this page

