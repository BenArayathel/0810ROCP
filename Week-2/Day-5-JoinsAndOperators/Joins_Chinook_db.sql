
--Joinsexaple.sql

select * from album;
select * from artist;


-----------INNER JOIN (only values that match will be shown)

select * from artist, album where artist.artist_id = album.artist_id; --using full table name

select * from artist a, album b where a.artist_id = b.artist_id ; --using an alias

select * from album a inner join artist b on a.artist_id = b.artist_id ; --using an alias and the "on" keyword

select count(*) from album a inner join artist b on a.artist_id = b.artist_id ;

-----------LEFT OUTER JOIN (all the values from the left table will be shown)

select * from artist a left outer join album  b on a.artist_id = b.artist_id; --doing a left join

select * from artist a left join album  b on a.artist_id = b.artist_id; --also does it, don't need 'outer'

select count(*) from artist a left outer join album  b on a.artist_id = b.artist_id;

-----------RIGHT OUTER JOIN (all the values from the right table will be shown)

select * from artist a right outer join album  b on a.artist_id = b.artist_id; --doing a right join

select * from artist a right join album  b on a.artist_id = b.artist_id; --also does it, don't need 'outer', same as the inner, why? Because you can't have an album without an artist. You can have artists without albums though. 

select count(*) from artist a right outer join album  b on a.artist_id = b.artist_id;

-----------FULL OUTER JOIN (All the values will be shown)
select * from artist a full outer join album b on a.artist_id = b.artist_id;
select count(*) from artist a full outer join album b on a.artist_id = b.artist_id;

-----------SELF JOIN 
--SELECT * FROM table1 t1 inner join table2 t2 on t1.primary_key = t2.foreign key
select * from employee e inner join employee e2 on e.employee_id = e2.reports_to ; --returns a list of people that are reported to.

select e.employee_id, e.first_name, e2.first_name from employee e inner join employee e2 on e.employee_id = e2.reports_to ; --returns a list of people that are reported to.

-----------CROSS JOIN
select * from album a cross join artist a2 ;


