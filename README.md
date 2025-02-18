# petshop


## 1 Object

Create a backend for a petshop whos wants to sell products and adopt pets.
The main go is to practice: spring, quarkus, java, deno, typescript, aws bucket, clean architecture, gRPC.


## 2 Resume

The project will has two main gols:
- Store: sell products
- Adoption: control the flow of adoption a pet

## 3 Store

### 3.1 Objective

Allow user to buy products for pet online


### 3.2 microservices

- ms-auth
- ms-user
- ms-store
- ms-store-cart
- ms-store-product
- ms-store-tracking

### 3.3 MVP
- Insert pet
- Insert client
- Insert, List services
- Card
- Login

## 4 Adoption


### 4.1 Objective

Allow user to adopt a pet by chosen in a list.
The petshop will evaluate the candidate to check if he/she matchs with the dog's breed


### 4.2 microservices

- ms-adopt
- ms-adopt-clinic
- ms-adopt-animal
- ms-adopt-process

![Adoption Microservices overview](https://github.com/vyctorhff/petshop/docs/diagrams/adoption-ms-overview.png)

### MVP
- Insert pet
- Insert Adoptante
- List pets
- Order Adoption
- Login

### 4.3 Adoption Process
![Adoption Process flow](https://github.com/vyctorhff/petshop/docs/diagrams/adoption-process.png)


### 4.4 User cases


#### 4.4.1 Create new animal
- POST to ms-adopt
- ms-adopt POST to ms-storage with de animals photos
- ms-adopt POST to ms-adopt-process to start the process
- ms-adopt-process return the process id for that animal


#### 4.4. Reopen concluded adoption process
- ms-adopt GET to ms-adopt-animal
- ms-adopt PATCH to ms-adopt-process passing the id animal
- ms-adopt-process check if the animal has a previous process
- ms-adopt-process create a history for the old process
- ms-adopt-process reinit the process
- ms-adopt-process return the id process


#### 4.4.3 Insert user adopter
- PATCH to ms-adopt
- ms-adopt GET ms-user for the user exists by document number
- ms-adopt PATCH ms-user with the new user
- ms-adopt return success


#### 4.4.4 Insert user employee
- POST to ms-user
- valid if the user exists
- return the user id

#### 4.4. Search animal
- GET to ms-adopt
- ms-adopt GET to ms-adopt-animal
- ms-adopt-animal paginate the results in 50 rows


#### 4.4. Search process by step
- GET to ms-adopt
- ms-adopt GET to ms-adopt-process passing the id process
- ms-adopt-process return the process with the step


#### 4.4. Send animal to the clinic
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process passing the animal id and the clinic id
- check if is the correct step
- update the step
- update the database if the info


#### 4.4. Veterinary analysies the animal
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- passing the veterinary text
- check if is the correct step
- update the step
- update the database if the info


#### 4.4. Show animal in the moral
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- passing the animal id
- Only animals with the other steps are ok
- Change step to MORAL
- Enable the animal to appear in the moral


#### 4.4. Adopter apply for animal
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- passing the user id and the animal id
- check if the animal is on step MORAL
- update step to USER_APPLYING
- PATCH to ms-adopt-animal to unable the animal to show in moral


#### 4.4. Schedule the interview
- passing the process id, user adopter id, user employee id and a data
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- check if user adopter has not other process no finished
- check if the animal is on the MORAL step
- update step to INTERVIEW_SCHEDULED
- update user to the process

#### 4.4. Interview Result
- passing the process id, aproved boolean
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- check if step is INTERVIEW_SCHEDULED
- update decision to the process
- if not aproved, finally the process
- if aproved, update step to CONTRACT


#### 4.4. Sign responsability contract
- passing a pdf file and the process id
- POST to ms-adopt
- ms-adopt POST to ms-adopt-process
- save file on aws s3
- update process to FINALLY


## 5 Shared microservices

- ms-user
- ms-auth
- ms-bank
- ms-storage

