# product-service-servlet

Product Service API (There are JavaDoc in many classes)

## Servlet + JSP + JDBC 

Before using:
1) create database with name <b>product_servlet_jsp</b>
2) create script to create some tables and necessary data for this example
```sql
-- Create table
create table USER_ACCOUNT
(
USER_NAME VARCHAR(30) not null,
GENDER    VARCHAR(1) not null,
PASSWORD  VARCHAR(30) not null,
primary key (USER_NAME)
);
 
-- Create table
create table PRODUCT
(
CODE  VARCHAR(20) not null,
NAME  VARCHAR(128) not null,
PRICE FLOAT not null,
primary key (CODE)
) ;
 
-- Insert data: ---------------------------------------------------------------
 
insert into user_account (USER_NAME, GENDER, PASSWORD)
values ('user1', 'M', 'user001');
 
insert into user_account (USER_NAME, GENDER, PASSWORD)
values ('user2', 'M', 'user002');
 
insert into product (CODE, NAME, PRICE)
values ('P001', 'Java Core', 100);
 
insert into product (CODE, NAME, PRICE)
values ('P002', 'C# Core', 90);
```

### Screenshots
###### Hello page
![alt-текст](https://github.com/MaximBubnov/product-service-servlet/blob/master/product/main.jpg "главная страница")
<hr>

###### Product list page
![alt-текст](https://github.com/MaximBubnov/product-service-servlet/blob/master/product/productlist.jpg "главная страница")
<hr>

###### Login page
![alt-текст](https://github.com/MaximBubnov/product-service-servlet/blob/master/product/login.jpg "главная страница")
<hr>

