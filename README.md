# petshop


## 1 Object

Create a backend for a petshop whos wants to sell products and adopt pets.
The main go is to practie: nodejs, typescript, aws bucket, RabbitMQ, Elastic Search in microservices architecture.


## 2 Resume

The project will has two main gols:
- Store: sell products
- Adoption: control the flow of adoption a pet


## 3 Store

### 3.1 Main focus

- Products
- Tracking
- Payment
- Users


### 3.2 microservices

- ms-store
- ms-store-cart
- ms-store-product
- ms-store-tracking


## 4 Adoption


### 4.1 Main focus
- Animals
- Adopter
- Veterinary clinit
- Mural


### 4.2 microservices

- ms-adopt
- ms-adopt-clinic
- ms-adopt-animal
- ms-adopt-process


### 4.3 Adoption Process
- Insert an animal
- Veterinary exams the animal
- Expo the animal on the mural
- User apply for some animal
- Interview
- Responsability Contract


### 4.4 User cases


#### 4.4.1 Insert new animal
- POST to mp-adopt
- mp-adopt POST to mp-storage with de animals photos
- mp-adopt POST to mp-adopt-process to start the process
- mp-adopt-process return the process id for that animal 


#### 4.4. Reopen concluded adoption process 
- mp-adopt GET to mp-adopt-animal
- mp-adopt PUT to mp-adopt-process passing the id animal
- mp-adopt-process check if the animal has a previous process
- mp-adopt-process create a history for the old process
- mp-adopt-process reinit the process
- mp-adopt-process return the id process


#### 4.4.3 Insert user adopter
- PUT to mp-adopt
- mp-adopt GET mp-user for the user exists by document number
- mp-adopt PUT mp-user with the new user
- mp-adopt return success


#### 4.4.4 Insert user employee

#### 4.4. Search animal 
- GET to mp-adopt
- mp-adopt GET to mp-adopt-animal
- mp-adopt-animal paginate the results in 50 rows


#### 4.4. Search process by step
- GET to mp-adopt
- mp-adopt GET to mp-adopt-process passing the id process
- mp-adopt-process return the process with the step


#### 4.4. Send animal to the clinic
#### 4.4. Vet analysies ????
#### 4.4. Show animal in the moral
#### 4.4. Adopter apply for animal
#### 4.4. Make interview
#### 4.4. Sign responsability contract


## 5 Shared microservices

- ms-user
- ms-auth
- ms-very-expensive-bank
- ms-storage


### 5.1 User Cases

#### 5.1.1 User login

- Passing id user and pass to ms-auth
- Checking id user in ms-user
- Generate jwt token and refresh token


#### 5.1.2 Create user

- Post to ms-user
- Checking if user login exists


#### 5.1.3 create file aws bucket

- Post to ms-storage
- Save on aws bucket
- Save file key on database
- Return file key


# Nest steps

- Continue business rules
- Make diagrams
