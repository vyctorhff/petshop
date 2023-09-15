# petshop - ms-auth

## Objective

## Dependencies

- Postgresql
- JWT
- Spring Boot
- Spring Data

## Tech UCs

### Create authentication

Endpoint
`POST - ${host}/auth`

Body
`{enrollment: '', pass: ''}`

Return
`Status http - 201 Created`

### Delete authentication

Endpoint
`DELETE - ${host}/auth`

Body
`{enrollment: ''}`

Return
`Status http - 200 OK`

### Check authentication

Endpoint
`GET - ${host}/auth`

Body
`{enrollment: '', pass: ''}`

Return
`Status http - 202 Accepted`
