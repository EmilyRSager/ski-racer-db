CREATE TABLE OFFICIAL 
(
	officialID int , 
	role Varchar (20), 
	salary int CHECK (Salary > 0),
	personID int REFERENCES Person (personID),
	Primary Key (officialID)
); 

