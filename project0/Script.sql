
create table if not exists shop(
	item_id SERIAL primary key,
	item_name VARCHAR(50) not null,
	item_status VARCHAR(50) not null,
	item_owned BOOL,
	item_offer NUMERIC(6,2)
);
select * from shop;

alter table shop add user_ID NUMERIC(6,2);
alter table offers add item_status VARCHAR(50);
alter table offers add time VARCHAR(100);

update offers set item_status = 'rejd' where item_id = 46 and item_name = 'Puku';

delete from shop where item_id > 0;

update shop as s 
set user_id = (select user_id from offers as o where s.user_id  = o.user_id)
from offers
where s.item_id = offers.item_id;
Select user_id from users where user_loginname = 'username' and user_loginpass = 'password';

create table if not exists offers(
	offer_id SERIAL primary key,
	item_id numeric(6,2),
	item_name varchar(50),
	item_offer numeric(6,2),
	user_id	numeric(6,2)
);


select sum(item_offer) from offers where item_status = 'accepted' and offers."time" >='2021/05/04' and offers."time"  <='2021/05/04';
select sum(item_offer) from offers where offers."time" >='2021/05/04' and offers."time"  <='2021/05/04';
delete from shop where item_id > 0;
delete from offers where item_id > 0;
select item_name from shop where item_id = 160;
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (79, 59, 'Dove', 100, 65, 'pending');
select sum(item_offer) from offers where()

insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (77, 35, 'cow milk', 8, 14, 'accepted', '2021/05/12');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (56, 53, 'goat milk', 96, 99,'pending', '2021/06/03');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (55, 53, 'goat milk', 96, 99,'pending', '2021/06/03');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (54, 53, 'goat milk', 96, 99,'pending', '2021/06/03');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (53, 53, 'goat milk', 96, 99,'pending', '2021/06/03');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (52, 53, 'goat milk', 96, 99,'accepted', '2021/06/03');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (87, 26, 'soy milk', 46, 56, 'pending');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (2, 100, '2% milk', 63, 2, 'pending');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (59, 46, 'almond milk', 33, 37, 'pending');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (84, 83, 'chicken milk', 95, 98, 'pending');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status) values (93, 10, '20 year expired milk', 97, 29, 'pending');
insert into offers (offer_id, item_id, item_name, item_offer, user_id, item_status, "time") values (95, 10, '20 year expired milk', 97, 29, 'accepted', '2021/05/05');
insert into shop (item_id, item_name, item_status, item_offer, user_id) values (1, 'cow milk', false, 0, 0);
insert into shop (item_id, item_name, item_status, item_offer, user_id) values (2, 'goat milk', false, 0, 0);
insert into shop (item_id, item_name, item_status, item_offer, user_id) values (3, 'chicken milk', false, 0, 0);


create table if not exists users(
	user_id SERIAL primary key,
	user_type VARCHAR(50) not null,
	user_loginname VARCHAR(50) not null,
	user_loginpass VARCHAR(50) not null
);

insert into users (user_loginname, user_loginpass) values ('nguyenfelix', 'password');
delete from users where user_id = 0;
create table departments(
	dept_id SERIAL primary key,
	dept_name VARCHAR(50) not null,
	monthly_budget NUMERIC(6,2) -- 9999.99
);

select * from users where user_loginname ='asdf' and user_loginpass = 'alright';



