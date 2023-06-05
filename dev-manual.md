# Create a new microservice

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
npm i --save @nestjs/typorm pg
npm i --save bcrypt --save-dev @types/bcrypt


# Identation

4 spaces


# How to

## Make a get request
``

## Make a post request
``

# migrations

## Create

`
npm run typeorm migration:create .\src\migrations\MIGRATION_NAME
`

## Exection
`
npm run typeorm migration:run -- -d path-to-datasource-config
`