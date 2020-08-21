--SET OPERATORS
--add records by columns

CREATE TABLE TA(
    nums int,
    chars varchar(10)
    );
CREATE TABLE TB(
    other_nums int,
    other_chars varchar(10)
    );
   
INSERT INTO TA VALUES(1,'a');
INSERT INTO TA VALUES(2,'b');
INSERT INTO TA VALUES(3,'c');
INSERT INTO TA VALUES(4,'d');

INSERT INTO TB VALUES(3, 'C');
INSERT INTO TB VALUES(4, 'D');
INSERT INTO TB VALUES(5, 'E');
INSERT INTO TB VALUES(6, 'F');
INSERT INTO TB VALUES(7, 'G');

SELECT nums, chars FROM TA UNION SELECT other_nums, LOWER(other_chars) FROM TB order by nums; --returns the value (excludes duplicate values)

SELECT nums, chars FROM TA UNION ALL SELECT other_nums, LOWER(other_chars) FROM TB; --returns all the values, including duplicates

SELECT nums, chars FROM TA INTERSECT SELECT other_nums, LOWER(other_chars) FROM TB ORDER BY nums; --returns records in both tables

SELECT nums, chars FROM TA EXCEPT SELECT other_nums, LOWER(other_chars) FROM TB ORDER BY nums; --returns values that exist in table a and not in table b 

(select nums, chars from TA except select other_nums, other_chars from TB) union all (select other_nums, other_chars from TB except select nums, chars from TA); --returns values that only exist in seperate tables


select name, genre_id as id from genre union select name, category_id from category c2 ;


select name from genre g union select name from category c ; --returns me a list of all the music and movie genres