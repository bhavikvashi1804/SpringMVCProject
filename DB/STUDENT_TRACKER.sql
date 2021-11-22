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


create table course (
    id int(11) not null auto_increment,
    title varchar(128) default null,
    instructor_id int(11) default null,
    primary key(id),
    -- Unique Value for Title
    unique key TITLE_UNIQUE (`title`),
    -- Index
    KEY `KEY_INSTRUCTOR_idx` (`instructor_id`),
    -- Foreign Key Constraint 
    constraint `FK_INSTRUCTOR`
    FOREIGN KEY (instructor_id) references instructor(id)
);



use student_tracker;
show tables;
select * from instructor;
select * from instructor_detail;