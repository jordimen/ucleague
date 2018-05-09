# UEFA Champions League 2018

Application (proof of concept) to manage teams.

![alt text](./screenshots/main.png "Main screen")

![alt text](./screenshots/autocomplete.png "Autcomplete")

![alt text](./screenshots/modal.png "Modal")

## Fronted application

Main features:

* Angular 5 application with Typescript.
* Angular CLI.
* Material design components.
* Server side pagination.
* Custom component for select countries and teams with autocomplete via backend.
* Reactive forms.

### Project structure

![alt text](./screenshots/frontend-folder-structure.png "Frontend folder structure")

### Launch

```
cd ucleague-frontend

# Install dependencies
npm install

# Lauch application
npm start
```

Open this URL in the browser:

http://localhost:4200/


## Backend application

Main features:

* Spring Boot microservice.
* RESTful API.
* Spring Data JPA.
* Embedded H2 database.
* Dozer for bean mapping.

### Project structure

![alt text](./screenshots/backend-folder-structure.png "Backend folder structure")


### Launch

```
cd ucleague-backend

# build
mvn clean install

# Lauch application
cd ucleague-backend-ws
mvn spring-boot:run
```
