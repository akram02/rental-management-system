# rental-management-system

Rental Management System with Spring Boot

![](https://github.com/zaq1tomo/rental-management-system/blob/master/images/image.png)

## Description

This system has three functions, auth, search, and rental.

- `Auth` If you are not a member, you cannot use this system.

- `Search` Member can browse and search costumes.

- `Rental` Members can reserve, rent and return costumes.

## Requirements

This application has been tested for operation in the following environment.

- Java 10
- Gradle 4.9
- MySQL 8.0.11

## Usage

1. You need to setup MySQL

```
mysql> create database rental_management_system;
mysql> create user springuser identified by 'password';
mysql> grant all privileges on rental_management_system.* to springuser;
```

2. Run the Spring Boot Application

```
$ ./gradlew bootRun
```

3. Insert the item data

```
mysql> use rental_management_system;
mysql> source sql/04_insert_item.sql;
```

4. Access to http://localhost:8080

## Licence

[MIT](https://github.com/zaq1tomo/rental-management-system/blob/master/LICENSE)

## Author

[zaq1tomo](https://github.com/zaq1tomo) 
