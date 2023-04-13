create database pocketMoney;
use pocketMoney;

CREATE TABLE user (
    user_id INT PRIMARY KEY auto_increment,
    username VARCHAR(50),
    password VARCHAR(50)
);
alter table user add column allowance int;
desc user;

CREATE TABLE diary (
    diary_id INT PRIMARY KEY auto_increment not null,
    user_id INT not null ,
    date DATE ,
    expense int,
    category VARCHAR(50),
    note TEXT,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);