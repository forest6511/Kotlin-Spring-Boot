# Motivation

Study following tech

- Spring boot with Kotlin
- Database
- Unit testing
- Flyway Migration

# Requirement

- Java 1.8
- Gradle 6.5.1
- Docker
- Kotlin 1.3.72

# Getting Started

START DB2 FOR TESTING PURPOSE WITH THE FOLLOWING COMMAND

```
docker-compose up
```

CONFIRM 
```
mydb2  | DB2 Universal Database Version 11.5, 5622-044 (c) Copyright IBM Corp. 2017
mydb2  | Licensed Material - Program Property of IBM
mydb2  | IBM DATABASE 2 Database update to current fix pack tool
mydb2  | 
mydb2  | db2updv115 completed successfully for database 'testdb'. 
```

### Testing and Archive executable jar

```
> ./gradlew clean test build
> cd build
> java -jar demo-0.0.1-SNAPSHOT.jar
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/gradle-plugin/reference/html/)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/5.2.8.RELEASE/spring-framework-reference/languages.html#coroutines)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#howto-batch-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)


### Guides
The following guides illustrate how to use some features concretely:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

