CREATE TABLE COACH 
(
	coachID int NOT NULL, 
	rank int Check (rank > 0), 
	salary int,
	Primary Key (coachID)
);