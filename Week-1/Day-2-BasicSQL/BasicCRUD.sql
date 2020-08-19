
create table users (
	user_id int

);

--CRUD create read update and delete 
select * from users;
insert into users values(1);
insert into users values(2);

update users set user_id = 3 where user_id =2;

delete from users where user_id = 1;


