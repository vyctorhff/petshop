# Create a new microservice

## Folder structure

`
java
  - application
  - infra
    - config
  - util
  - share
  - expections
  - <uc name>
    - dtos
    - controllers
    - services
    - infra
resourse
  - db
    - migrations
`

## dtos
  ${name}RequestDTO.java
  ${name}ResponseDTO.java

## migrations

Init project to run the migrations

### Folder
/src/main/resources/db/migration


## Exection

Run on console
./mvnw spring-boot:run

