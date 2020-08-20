select * from employee e ;
select * from employee where last_name = 'King';
select * from employee e where first_name = 'Andrew' and reports_to is null;

select * from album a order by title ;
select * from customer c order by city;

select * from genre g ;
insert into genre ("name" ) values ('Ska'),('Rock Opera');
insert into employee (last_name , first_name , title) values ('Presley','Elvis','King');
insert into customer (first_name ,last_name ,email ) values ('Lady','Gaga','radio@gaga.com');


select * from customer c2 where first_name = 'Aaron' ;
update customer set first_name ='Robert', last_name = 'Walter' where first_name = 'Aaron' ;

select * from artist a where name like 'Cree%';

update artist  set "name" = 'CCR' where name like 'Cree%';

select * from invoice i where billing_address like 'T%';

select * from invoice i where total between 15 and 50;

select * from employee e where hire_date between '2003/06/01' and '2004/03/01';
select * from customer where first_name  = 'Robert';

alter table invoice drop constraint fk_invoice_customer_id;
select from invoice  * where customer_id = '32';
 
delete from customer * where first_name = 'Robert' and last_name like 'Wa%'  ;
