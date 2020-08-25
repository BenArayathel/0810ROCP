
--One to Many relationship (Many to one is the other way around)
drop table if exists planets cascade;

create table planets (
	planet_id serial primary key,
	planet_name varchar(30),
	planet_description varchar(30)
);

drop table if exists moons cascade;
create table moons (
	moon_id serial primary key,
	moon_name varchar(30),
	p_id int references planets(planet_id)
);

insert into planets(planet_name, planet_description) values ('Earth', 'blue and green');

insert into moons(moon_name, p_id) values ('The Moon', (select planet_id from planets where planet_name = 'Earth'));

select*from planets;
select*from moons;


--One to One
--Standard sql does not offer one-to-one relationships easily
--Instead we create a pseudo relationship by having a unique condition on our 'one-to-many' relationship

drop table if exists planets cascade;

create table planets (
	planet_id serial primary key,
	planet_name varchar(30),
	planet_description varchar(30),
	life int references civilizations(civ_id) unique
);

create table civilizations(
	civ_id serial primary key,
	civ_name varchar(30)
	);

--Many to Many
-- A many to many, as the name suggest maps entities to multiple other entities 
-- A normal example might be, a student has many proffessors, professors have many students. 

drop table if exists planets cascade;
drop table if exists features cascade;
drop table if exists planet_features cascade;

create table planets (
	planet_id serial primary key,
	planet_name varchar(30),
	planet_description varchar(30) 
);

create table features (
	feature_id serial primary key,
	feature_name varchar(30),
	feature_description varchar(60)
);

-- This is a junction table 
--At minimum we can have this
create table planet_features (
	p_id int references planets(planet_id),
	f_id int references features(feature_id) ,
);

--Alternatively we can add a lot more constraints to give it more functionality
create table planet_features (
	p_id int references planets(planet_id) on update cascade on delete cascade,
	f_id int references features(feature_id) on update cascade,
	constraint pf_key primary key (p_id, f_id)
);

insert into planets(planet_name) values 
	('Earth'),
	('Mars'),
	('Jupiter');
	
insert into features(feature_name) values
	('Mountains'),
	('Planet scale storms'),
	('Desert');

select * from planets;

select * from features;

select * from planet_features;

insert into planet_features values
((select planet_id from planets where planet_name = 'Earth'),(select feature_id from features where feature_name = 'Desert')), --using sub queries inside of our insert statements is allowed
(1,1); --alternatively we can explicitly put in the appropriate values 

