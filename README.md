## Spring API

- Simple Spring boot REST APIs.
- This application uses in memory h2 database.
- URL to h2 database - http://localhost:8080/h2-console
- Refer the below image for the db connection

![](https://gitlab.com/hegdevenky/static-files/-/raw/master/test-apps/h2-console.png)

- Execute below commands to test and run the application
```shell script
mvn test
mvn clean install
mvn spring-boot:run
```

- [Endpoints](https://gitlab.com/test-applications1/spring-api/-/blob/master/spring-api.postman_collection.json)