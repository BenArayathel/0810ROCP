drop table rooms;

create table rooms (
	room_id serial primary key,
	room_name varchar(20) not null unique,
	item_id int unique,
	item_name varchar(10) unique,
	player_in_room boolean not null
);

insert into rooms (room_id, room_name, item_id, item_name, player_in_room) values
	(1, 'Living Room', 1, 'iPhone', true),
	(2, 'Kitchen', 2, 'Sandwich', false),
	(3, 'Garage', 3, 'Crowbar', false),
	(4, 'Garden', null, null, false),
	(5, 'Play Room', null, null, false),
	(6, 'Master Bedroom', 4, 'Watch', false),
	(7, 'Office', null, null, false),
	(8, 'Guest Room', null, null, false);
	

select * from rooms;

--/////////////////////////////////////

drop table backpack;

create table backpack (
	items int[] 
);

insert into backpack (items) values ('{}');

select * from backpack;


 
--UPDATE backpack set items = '{}';


--////////////////////////////////


create table txt_items (
	item_id int,
	item_name varchar(20)
);

select * from txt_items;

insert into txt_items (item_id, item_name) values 
	(1,'iPhone'),
	(2, 'Sandwich'),
	(3, 'Crowbar'),
	(4, 'Watch');
	

