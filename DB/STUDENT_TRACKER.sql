show databases;

create database if not exists STUDENT_TRACKER;


create table `instructor_detail` (
	`id` int(11) NOT NULL auto_increment,
    `rating` int(2),
    `field` varchar(10),
    primary key(id)
);

create table `instructor` (
	`id` int not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    `instructor_detail_id` int(11) default null,
    primary key(`id`),
    constraint `FK_instructor_detail` foreign key(instructor_detail_id) references instructor_detail(id)
);



use student_tracker;
show tables;
select * from instructor;
select * from instructor_detail;