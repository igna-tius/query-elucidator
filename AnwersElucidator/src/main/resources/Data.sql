/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sameer
 * Created: 15 Mar, 2020
 */

insert into Users(uname,fname,lname,email,password) values('Sameer1','Sameer','Gangrade',
'sam1@gmail.com.com','1234');
insert into Users(uname,fname,lname,email,password) values('Shubham1','Shubham','Dalal',
'shubh1@gmail.com','1234');
insert into Users(uname,fname,lname,email,password) values('Shruti1','Shruti','Shrivastav',
'shruti@gmail.com','1234');

--insert into Query(fk_uname,category,title,description) values('Sameer1','Java1','Q1','Desc1');
--insert into Query(fk_uname,category,title,description) values('Sameer1','Python','Q25','Desc55');
--insert into Query(fk_uname,category,title,description) values('Shubham1','Java2','Q2','Desc2');
--insert into Query(fk_uname,category,title,description) values('Shruti1','Java3','Q3','Desc3');

insert into Query(fk_uname,title,description) values('Sameer1','Q1','Desc1');
insert into Query(fk_uname,title,description) values('Sameer1','Q25','Desc55');
insert into Query(fk_uname,title,description) values('Shubham1','Q2','Desc2');
insert into Query(fk_uname,title,description) values('Shruti1','Q3','Desc3');

insert into Category(fk_qid,category) values(1,'java');
insert into Category(fk_qid,category) values(1,'SQL');
insert into Category(fk_qid,category) values(2,'Oracle');
insert into Category(fk_qid,category) values(3,'MySQL');
insert into Category(fk_qid,category) values(4,'Java');

insert into Solutions(fk_uname,fk_qid,title,description) values('Sameer1',1,'S1','Desc 1 for Q1');
insert into Solutions(fk_uname,fk_qid,title,description) values('Sameer1',1,'S2','Desc 2 for Q1');
insert into Solutions(fk_uname,fk_qid,title,description) values('Shruti1',4,'S1','Desc 1 for Q4');

--insert into test(nam) values('Sameer1');
--insert into test(nam) values('Sameer2');
--insert into test(nam) values('Sameer3');
-- insert into Users(uname,fname,lname,email,password) values('Sameer1','Sameer','Gangrade','sam1@sam.com','1234');
-- insert into Users(uname,uid,email,upvote) values('Sameer1',102,'sam2@sam.com',1);
-- insert into Users(uname,uid,email,upvote) values('Sameer3',103,'sam3@sam.com',1);
-- insert into Users(uname,uid,email,upvote) values('Sameer4',104,'sam4@sam.com',1);
-- insert into Users(uname,uid,email,upvote) values('Sameer5',105,'sam5@sam.com',1);

