# spring-boot-case-study-1

A simple Spring Boot Application with three endpoints.

1. For adding a new User.
2. For deleting a User with the given User Id.
3. For viewing all Users.

Class User
- id, name, email

-> The user details are stored in JSON format in a file. 
-> If any input fields is empty, it should be considered as an error.
-> If a new user with an existing User Id is entered as input the old one should get over-written.
