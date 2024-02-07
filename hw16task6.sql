create database if not exists test_db;
use test_db;

create table test_table (
	id int auto_increment not null,
    product varchar(30) unique not null,
    country varchar(20) not null,
    destination varchar(20) not null,
    primary key (id)
);