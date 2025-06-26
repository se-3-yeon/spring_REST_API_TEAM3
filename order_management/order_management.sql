-- db 생성
drop database if exists order_management;
-- create database if not exists order_management;
create database order_management;

-- 사용자 생성
drop user if exists 'three'@'%';
create user 'three'@'%' identified by '0630';
-- 권한 부여
grant all privileges on order_management.* to 'three'@'%';
-- 권한 변경 사항 적용
flush privileges;

-- 권한 확인
show grants for 'three'@'%';


-- -------------------------------
-- menu
use order_management;
show tables;

drop table if exists menu;

create table menu(
                     menu_no int auto_increment not null primary key,
                     menu_name varchar(255) not null,
                     menu_price int not null
);

-- menu_no, menu_name, menu_price
insert into menu values(null, '양념갈비', 15000);
insert into menu values(null, '김치찌개', 7000);
insert into menu values(null, '갈비탕', 12000);
insert into menu values(null, '물냉면', 9000);

select * from menu;

-- -------------------------------
-- orders
use order_management;
show tables;

drop table if exists orders;

create table orders(
                       or_no int auto_increment not null primary key,
                       cus_no int not null,
                       order_time DATETIME not null,
                       FOREIGN KEY (cus_no) REFERENCES customer(cus_no)
);

-- or_no, cus_no, order_time
insert into orders values(null, 11, '2025-06-24 11:20:20');
insert into orders values(null, 11, '2025-06-24 11:30:30');
insert into orders values(null, 13, '2025-06-24 14:00:00');
insert into orders values(null, 14, '2025-06-24 16:23:00');
insert into orders values(null, 11, '2025-06-24 16:40:00');

select * from orders;

-- -------------------------------
-- order_item
use order_management;
show tables;

drop table if exists order_items;

create table order_items (
                             item_id int auto_increment not null primary key,
                             or_no int not null,
                             menu_name varchar(255) not null,
                             quantity int not null,
                             FOREIGN KEY (or_no) REFERENCES orders(or_no)
);

-- item_id, or_no, menu_name, quantity
insert into order_items values(null, 1, '양념갈비', 5);
insert into order_items values(null, 2, '김치찌개', 4);
insert into order_items values(null, 3, '갈비탕', 7);
insert into order_items values(null, 4, '물냉면', 10);
insert into order_items  values(null, 5, '물냉면', 3);

select * from order_items;

-- -------------------------------
-- employee
use order_management;
show tables;

drop table if exists employee;

create table employee(
                         em_no int auto_increment not null primary key,
                         em_name varchar(255) not null,
                         part varchar(255) not null,
                         career varchar(255) not null
);

-- em_no, em_name, part, career
insert into employee values(null, '권종인', '양념갈비', '14년차');
insert into employee values(null, '김경민', '김치찌개', '10년차');
insert into employee values(null, '박세연', '갈비탕', '7년차');
insert into employee values(null, '장수영', '물냉면', '3년차');

select * from employee;

-- -------------------------------
-- customer
use order_management;
show tables;

drop table if exists customer;

create table customer(
                         cus_no int auto_increment not null primary key,
                         cus_name varchar(255) not null,
                         grade varchar(255) not null
) AUTO_INCREMENT = 11;
-- 11번부터 자동 증가하도록 함.

-- cus_no, cus_name, grade
insert into customer values(null, '강경림', '황금돼지');
insert into customer values(null, '남정범', '은돼지');
insert into customer values(null, '배영현', '동돼지');
insert into customer values(null, '전영태', '돼지');

select * from customer;

--






