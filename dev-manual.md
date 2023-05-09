# Create a new microservice

## Folder structure

<module>
  - dtos
  - tests
  - interseptors
  - validators
  - util

## Very common lib

npm i --save @nestjs/config
npm i --save @nestjs/axios 
npm i --save @nestjs/typorm pg
npm i --save bcrypt
npm i -D @types/bcrypt


## Identation

4 spaces

### Migrations

`
 npm run typeorm migration:create .\src\migrations\MIGRATION_NAME
`
