# Create a new microservice - ATTENTION - UPDATE FOR JAVA!!!

## Folder structure

`
<module>
  - dtos
  - tests
  - interseptors
  - validators
  - util
external-api
  - xxx-external.service.ts
  - yyy-external.service.ts
  - zzz-external.service.ts
`

When a microservice needs to call another microservice, should create a module named
'external-api' and put all de call in a service class.


## Very common lib

npm i --save @nestjs/config
npm i --save @nestjs/axios 
npm i --save @nestjs/typeorm pg
npm i --save bcrypt --save-dev @types/bcrypt


# Identation

4 spaces


# dtos
	*.request.dto
	*.response.dto

# migrations


## Create
`
npx typeorm migration:create .\src\migrations\MIGRATION_NAME
`

## Exection
Execute the application
