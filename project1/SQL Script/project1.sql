create table if not exists ers_users(
	user_id SERIAL primary key,
	user_username VARCHAR(100) not null,
	user_password VARCHAR(100) not null,
	user_firstname VARCHAR(100) not null,
	user_lastname VARCHAR(100) not null,
	user_email VARCHAR(150) not null,
	user_role VARCHAR(50) not null

);

drop table ers_users

create table if not exists reimbursement(
	reimb_id SERIAL primary key,
	reimb_amount numeric(8,2) not null, 
	reimb_submitted timestamp not null,
	reimb_resolved timestamp, 
	reimb_description varchar(250),
	reimb_receipt varchar(100),
	reimb_author varchar(100),
	reimb_authorId numeric(8,2),
	reimb_resolver varchar(100),
	reimb_status varchar(100),
	reimb_type varchar(100)	
);


insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (6045, 93.72, '2/16/2021', '7/23/2020', 'Polecat, african', null, 'Francklin', 23,'fiddles', 'submitted', 'OTHER');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (358, 91.3, '3/29/2021', '11/28/2020', 'Butterfly, canadian tiger swallowtail', null, 'Mathian',24, 'good sense migraine formula', 'submitted', 'OTHER');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (5421, 68.07, '3/17/2021', '12/29/2020', 'Woodrat (unidentified)', null, 'Fidole',25, 'Fentanyl Citrate', 'approved', 'TRAVEL');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (84, 55.46, '12/7/2020', '9/5/2020', 'Armadillo, giant', null, 'Raff',13, 'Quetiapine fumarate', 'approved', 'FOOD');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (6627, 93.95, '12/1/2020', '11/1/2020', 'Pied butcher bird', null, 'Bud',14, 'Promethazine Hydrochloride', 'submitted', 'FOOD');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (1296, 25.59, '6/10/2020', '8/3/2020', 'Greater adjutant stork', null, 'Standford',15, 'Diphenhydramine HCl and Zinc Acetate', 'approved', 'LODGING');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (1496, 78.46, '7/23/2020', '2/1/2021', 'Alligator, mississippi', null, 'Ernest',16, 'Isoflurane', 'rejected', 'LODGING');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (5505, 20.93, '2/6/2021', '6/4/2020', 'Giant girdled lizard', null, 'Colver',17, 'glycopyrrolate', 'rejected','OTHER');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (5957, 96.28, '6/26/2020', '7/22/2020', 'Shrike, crimson-breasted', null, 'Silvester',18, 'Treatment Set TS347249', 'approved', 'FOOD');
insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (752, 79, '12/21/2020', '9/27/2020', 'Azara''s zorro', null, 'Basilio', 19, 'Acetylcysteine', 'approved', 'LODGING');


insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (1, 'username', 'pass', 'Martelle', 'Styan', 'mstyan0@yelp.com', 'employee');
insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (2, 'ashovelbottom1', '1ShIFP', 'Alexa', 'Shovelbottom', 'ashovelbottom1@t.co', 'manager');
insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (3, 'abelone2', 'NiU9HVTtFGkE', 'Abagael', 'Belone', 'abelone2@surveymonkey.com', 'manager');
insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (4, 'ldadd3', 'NrSLHxr0VDQ', 'Lammond', 'Dadd', 'ldadd3@alibaba.com', 'manager');
insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (5, 'kdionsetto4', 'yIxXT2VbopM', 'Karee', 'Dionsetto', 'kdionsetto4@google.de', 'manager');
insert into ers_users (user_id, user_username, user_password, user_firstname, user_lastname, user_email, user_role) values (6, 'u', 'p', 'felix', 'ngu', 'nguyenfelix79@yahoo.com', 'employee');

delete from reimbursement where reimb_id > 0 and reimb_id <10;

delete from reimbursement where reimb_id > 0;

delete from users where user_id > 0;

drop table ers_users;
drop table reimbursement;

insert into ers_users (user_id, user_firstname, user_lastname, user_email, user_role) values (1, 'first', 'last', 'nguyenfelix@gmail.com', 'emp');