/*
SQL : Structured Query language 
	Allows us to interact with a database
	
	Query: manipulates data (records or rows) in the database
	Transaction: can be a set of queries that can also manipulate tables.

Database: Structured Collection of data
RDBMS: Establish connectino with other tables and share data (Primary and Foreign keys)
Alternative database systems: Object, network and hierarchal. 

Sublanguages within sql:
	TCL: Transaction Control Language
		COMMIT (saves changes to our database)
		ROLLBACK ( retrieves/returns the database to a version that was saved)
		SAVEPOINT (saves a version of your database)
	DDL: 
		DROP (delete all the table, completly)
		ALTER (Modify the structure of a table)
		TRUNCATE (Deletes all the information of the table)
		CREATE (Creating a table, that doesn't exist)
		
	DML: (CRUD)
		CREATE (insert)
		READ (select)
		UPDATE (update)
		DELETE (delete, specific row)
	DQL:
		(READ) SELECT 
	DCL: Data Control Languages (grants and revokes permissions through roles)
		GRANT
		REVOKE 
		
	
	Constraints: Restrictions that new data must satisfy to enter into the column
		UNIQUE (no 2 values can be the same in the column)
		NOT NULL (not null or not empty)
		PRIMARY KEY (combination of unique and not null, used to search through tables)
		FOREIGN KEY (combination of unique and not null, used to search through tables)
		CHECK (Sets a custom conditional) 
		DEFAULT (sets a default value for a column)
		INDEX (create and retrieve data from the database very quickly) 
	
	DQL Clauses:
		WHERE ( allows us to check whether each entry satisfys a condition)
		HAVING ( similar to where, applies to a group of entries, used after GROUP BY)
		ORDER BY ( ordering our search queries) 
		GROUP BY ( grouping together by multiple rows that meet a condition)
	
	Aggregate function: Allows you to summarize data to return a single value 
		AVG()
		SUM()
		MIN()
		MAX()
	
	Scalar function: acts on a single row, takes in a single value and returns a single value 
		lower()
		upper() 
		
		

	TRANSACTION ACID
	
	Atomic: All the queries execute or none of them. 
	
	Consistent: Everything stays consistent) Does not violate referntial integrity
	
	Isolated: Transaction don't intefere with each other. 
	
	Durable: Data persists (changes to the database should still exists, even if local version of it fails)



