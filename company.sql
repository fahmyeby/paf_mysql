-- create company table
create database if not exists company;
use company;

-- create departments table
create table (
    dept_id int primary key auto_increment,
    name varchar(255) not null
);

-- create employees table 
create table employees (
    emp_id int primary key auto_increment,
    name varchar(255) not null,
    salary decimal (10, 2) not null,
    dept_id int,
    date_of_birth date,
    foreign key (dept_id) references departments(dept_id)
);

