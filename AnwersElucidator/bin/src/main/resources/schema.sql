/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sameer
 * Created: 15 Mar, 2020
 */
create table Users(fname varchar(30),lname varchar(30),uname varchar(30) not null, 
    email varchar(30),password varchar(30), primary key(uname));

    

create table Query(fk_uname varchar(30), qid integer auto_increment not null, 
    title varchar(200), description varchar(1000) , 
    pdate timestamp default sysdate not null, upvote integer default 0, primary key(qid), 
    foreign key (fk_uname) references Users(uname) ON DELETE CASCADE ON UPDATE CASCADE);    
    
--create table Query(fk_uname varchar(30), qid integer auto_increment not null, category varchar(10), 
--    title varchar(200), description varchar(1000) , 
--    pdate timestamp default sysdate not null, upvote integer default 0, primary key(qid), 
--    foreign key (fk_uname) references Users(uname) ON DELETE CASCADE ON UPDATE CASCADE);

create table Solutions(fk_uname varchar(30), fk_qid integer, sid integer auto_increment NOT NULL, 
    title varchar(200), description varchar(1000), pdate timestamp default sysdate, 
    primary key(sid), 
    foreign key(fk_qid) references Query(qid) ON UPDATE CASCADE ON DELETE CASCADE, 
    foreign key(fk_uname) references Users(uname) ON UPDATE CASCADE ON DELETE CASCADE);

create table Category(cid integer auto_increment NOT NULL, fk_qid integer, category varchar(23), 
	foreign key(fk_qid) references Query(qid), primary key(cid));
--	create table Category(fk_qid integer, category varchar(23), 
--	foreign key(fk_qid) references Query(qid));



--******* Testing Table***********
--create table test(id integer auto_increment, nam varchar(30), dt timestamp default sysdate, 
--    x integer default 1);