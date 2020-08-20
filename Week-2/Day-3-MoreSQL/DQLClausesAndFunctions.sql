/**

**/

select * from planets;

drop table planets cascade;

create table if not exists planets(
		-- column name, column type, constraints
		planet_id serial primary key,
		planet_name varchar(30) not null,
		planet_description varchar(60) not null unique,
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
	

------------------------------------------------------------------------------------------------------------------------------------------------
--WILDCARDS

-- '%; 0 or more characters 
select * from planets where planet_description like '%u%e%';
select * from planets where planet_description like '%%%%%%%%%%%%%%%%%B%%%%%%%%%%%%%%';

--'_' is a wildcard that is a stand-in for exactly 1 character
select planet_name from planets where planet_description like 'B__';
select planet_name from planets where planet_description like '%Apples';
select planet_name from planets where planet_description like '%_%';

------------------------------------------------------------------------------------------------------------------------------------------------
--IN KEYWORD
--This is the tedious way of writing that
select planet_name from planets where planet_name = 'Jupiter' or planet_name = 'Mars' or number_of_moons = 0;

--super cool, fast method
select planet_name from planets where planet_name in('Jupiter', 'Mars', 'Kiwi');

------------------------------------------------------------------------------------------------------------------------------------------------

--BETWEEN keyword
select * from planets where number_of_moons > 0 and has_rings = false;
select * from planets where number_of_moons between 10 and 81; --inclusive 

------------------------------------------------------------------------------------------------------------------------------------------------

select * from planets order by planet_name desc;
select * from planets order by number_of_moons asc;

select * from planets order by 3; --Don't want to specify the column name, you can use the column number
select * from planets order by 2, 3; --You can order by multiple columns

select * from planets where number_of_moons is null;
------------------------------------------------------------------------------------------------------------------------------------------------

update planets set planet_description ='very big' where planet_id = 
	(select planet_id from planets where planet_name = 'Jupiter') ;
update planets set number_of_moons = null where planet_name = 'Mercury';

------------------------------------------------------------------------------------------------------------------------------------------------

--SCALAR Functions
--Acts on a single value
--Act on individual rows

select UPPER(planet_name) from planets where planet_name = 'Jupiter';
select LOWER(planet_name) from planets;

------------------------------------------------------------------------------------------------------------------------------------------------

--AGGREGATE FUNCTIONS
--Acts on multiple rows

select SUM(number_of_moons) from planets where number_of_moons between 0 and 5;
select AVG(number_of_moons) from planets;
select MAX(number_of_moons) from planets;
select MIN(number_of_moons) from planets;

select number_of_moons from planets where number_of_moons is null;
select COUNT(*) from planets where number_of_moons is null;
select COUNT(number_of_moons) from planets where number_of_moons is null;

------------------------------------------------------------------------------------------------------------------------------------------------
--SQL functions 

select NOW();

------------------------------------------------------------------------------------------------------------------------------------------------
--GROUP BY 

select SUM(number_of_moons), has_rings from planets group by has_rings; 
select AVG(number_of_moons) from planets group by has_rings ;

------------------------------------------------------------------------------------------------------------------------------------------------
--HAVING 
-- Counting the planets (that have a name) and their rings from those planets with less than 4 moons grouping by their ring status. 

select COUNT(*), has_rings from planets where planet_description like '%b%' group by has_rings having sum(number_of_moons) < 100;

select * from planets where number_of_moons  > 0;


--EXTRA, don't need to learn
--Returns the original column with null values, and an alternative column with 0. 
select number_of_moons as moons, (case when number_of_moons is null then 0 else number_of_moons end) as other from planets;




