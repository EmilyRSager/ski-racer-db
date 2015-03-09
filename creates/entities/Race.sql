CREATE TABLE RACE (
	raceID int NOT NULL, 
	name Varchar(20), 
	type Varchar(20),
	date Date, 
	gender Varchar(20),
	mountainName Varchar(255) NOT NULL,
	Primary Key (raceID),
	Foreign Key (mountainName) REFERENCES Mountain (name)

);
