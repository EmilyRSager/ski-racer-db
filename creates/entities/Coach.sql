CREATE TABLE COACH 
(
	coachID int NOT NULL, 
	rank int Check (rank > 0), 
	salary int,
	club integer,
	Primary Key (coachID),
	Foreign Key (club) References Club (clubID)
);
