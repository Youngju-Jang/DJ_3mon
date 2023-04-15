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

select user_id
from user
where username = "absc";

insert into user (username, password)
values ('abc','abc');

select * from user;
select * from user
where user_id = 1 and password = 'abc';

desc user;
select * from user;
select * from diary;
update user set allowance = allowance+ -1000 where user_id = 1;

select *
from diary
where user_id = 1 and year(date) = 2023 and month(date) = 4
order by date asc;

select * from diary;


