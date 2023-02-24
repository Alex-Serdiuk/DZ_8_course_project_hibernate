create database db_car_service;
use db_car_service;

CREATE TABLE countries(
                          id int primary key not null auto_increment,
                          name varchar(25)
);

CREATE TABLE brands(
                       id int primary key not null auto_increment,
                       country_id int,
                       name text,
                       foreign key(country_id) references countries(id)
);

CREATE TABLE cars(
                     id int primary key not null auto_increment,
                     brand_id int,
                     model text,
                     vin text,
                     license_number text,
                     foreign key(brand_id) references brands(id)
);

CREATE TABLE services(
                         id int primary key not null auto_increment,
                         service_name text,
                         price int
);

CREATE TABLE clients(
                        id int primary key not null auto_increment,
                        first_name varchar(50),
                        last_name varchar(50),
                        phone varchar(25),
                        is_vip boolean
);

CREATE TABLE managers(
                         id int primary key not null auto_increment,
                         first_name varchar(50),
                         last_name varchar(50),
                         phone varchar(25)
);

CREATE TABLE orders(
                       id int primary key not null auto_increment,
                       car_id int,
                       service_id int,
                       client_id int,
                       manager_id int,
                       date_in datetime,
                       date_out datetime,
                       foreign key(car_id) references cars(id),
                       foreign key(service_id) references services(id),
                       foreign key(client_id) references clients(id),
                       foreign key(manager_id) references managers(id)
);

insert into countries(name) values ('United Kingdom');
insert into countries(name) values ('USA');
insert into countries(name) values ('Germany');

insert into brands(country_id, name) values ('1', 'Rolls-Royce');
insert into brands(country_id, name) values ('1', 'Aston Martin');
insert into brands(country_id, name) values ('1', 'Bentley');
insert into brands(country_id, name) values ('2', 'Tesla');
insert into brands(country_id, name) values ('2', 'Ford');
insert into brands(country_id, name) values ('2', 'Chevrolet');
insert into brands(country_id, name) values ('3', 'BMW');
insert into brands(country_id, name) values ('3', 'Mersedes');
insert into brands(country_id, name) values ('3', 'Maybach');


insert into cars(brand_id, model, vin, license_number) values ('4', 'Model 3', 'XTA210990Y2763344', '1122334455');
insert into cars(brand_id, model, vin, license_number) values ('8', 'SLS', 'SXF210990Y2766389', '5544332211');

select * from countries;
select * from brands;
select * from cars;
select * from services;
select * from clients;
select * from managers;
select * from orders;