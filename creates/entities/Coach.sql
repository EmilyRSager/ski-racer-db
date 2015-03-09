CREATE TABLE COACH 
(
	coachID int NOT NULL,
	firstName varchar(30) NOT NULL,
	lastName varchar(30) NOT NULL,
	rank int Check (rank > 0), 
	salary int,
	club integer,
	Primary Key (coachID),
	Foreign Key (club) References Club (clubID)
);
