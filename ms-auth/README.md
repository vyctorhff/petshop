# petshop - ms-auth

## Objective

## Tecnologies

- Postgresql
- JWT
- Spring Boot
- Spring Data

## Swagger
http://localhost:8085/swagger-ui/index.html

## Features

- It should be able to create an authentication entity
- It should be able to authenticate a user
- It should be able to check user role
- It should be able to get user roles
- It should be able to remove authentication entity
- It should be able to refresh jwt token

# Next Steps

- Test service for delete 
- Fix hikari pool configuration


# Second Thought

- Change stateless user context to statefull
- Create a redis for cache user and minimize database queries
