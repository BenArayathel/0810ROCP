create table planets(
--int, varchar, nvarchar, decimal, boolean, https://www.postgresql.org/docs/9.5/datatype.html
-- column name, column type, constraints 
	planet_id serial primary key,
	planet_name varchar(30) not null,
	planet_description VARCHAR(60) not null unique,
	has_rings boolean not null,
	number_of_moons smallint check(number_of_moons > -1)
);

insert into planets (planet_name, planet_description, has_rings, number_of_moons) values 
	('Mercury', 'Never too close', true, 0),
	('Venus', 'Getting a tad warm', false, 0),
	('Earth', 'cradle of civilization', false, 1),
	('Mars', 'Earth 2.0', false, 2),
	('Jupiter', 'Big', true, 67),
	('Saturn', 'very ringy', true, 82),
	('Uranus', 'blue', true, 27),
	('Neptune', 'getting nippy', true, 14),
	('Pluto', 'you cannot get rid of me', false, 2);
	
--Select all the planets from the planets table 
select * from planets;
--Select 'Jupiter' by its name 
select * from planets where planet_name = 'Jupiter';
--Select all the planets with rings;
select * from planets where has_rings = true;
--Select all the planets, descending by the number of moons
select * from planets order by number_of_moons desc;
--Select all the planets ascending by their names 
select * from planets order by planet_name asc;
--Insert another planet into the table, without a description. What do you need to ALTER to allow you to do that?
alter table planets alter column planet_description drop not null;
insert into planets (planet_name, planet_description, has_rings, number_of_moons) values ('Arya', null, true, 100);
--Update Mercury, it shouldn't have rings 
update planets set has_rings = false where planet_name = 'Mercury';
--Select all the planets that have the letter 'a' in their name 
select * from planets where planet_name like '%a%';
--Select all the planets that start with the letter 'M'
select * from planets where planet_name like 'M%';
--Select all the planets with their third character being 'r'
select * from planets where planet_name like '__r%';
--Delete Pluto from the planet list 
delete from planets where planet_name = 'Pluto';
--Print out the current date and time. 
select now();




