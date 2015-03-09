CREATE TABLE PERSON
(
	personID int NOT NULL, 
	firstName Varchar (20),
	lastName Varchar (20),
	gender Varchar(2), 
	club int,
	DOB Date,
	Primary Key (personID),
	Foreign Key (club) References Club (clubID)
); 
