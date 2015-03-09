CREATE TABLE OFFICIAL 
(
	officialID int NOT NULL, 
	firstName varchar(30) NOT NULL,
	lastName varchar(30) NOT NULL,
	role Varchar (20), 
	salary int CHECK (Salary > 0),
	Primary Key (officialID)
); 

