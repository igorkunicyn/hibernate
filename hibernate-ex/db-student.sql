drop database if exists student

create database student;

create table students(
id int(11) not null auto_increment primary key,
firstName varchar(55) not null,
mark varchar(55)
) engine= InnoDB charset = utf8;