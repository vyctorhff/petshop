# petshop


## 1 Object

Create a backend for a petshop whos wants to sell products and adopt pets.
The main go is to practie: nodejs, typescript, aws bucket, activeMQ(in the future gRPC), Elastic Search in microservices architecture.


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
- mp-adopt POST to mp-adopt-process passing the animal id and the clinic id
- check if is the correct step
- update the step
- update the database if the info


#### 4.4. Veterinary analysies the animal
- POST to mp-adopt
- mp-adopt POST to mp-adopt-process 
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
- POST to mp-adopt
- ms-adopt POST to ms-adopt-process
- passing the user id and the animal id
- check if the animal is on step MORAL
- update step to USER_APPLYING
- PATCH to mp-adopt-animal to unable the animal to show in moral

#### 4.4. Schedule the interview
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
