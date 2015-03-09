CREATE TABLE RACER 
(
	racerID int NOT NULL,
	firstName varchar(30) NOT NULL,
	lastName varchar(30) NOT NULL,
	rank int CHECK (Rank > 0), 
	points decimal(5,2),
	coach integer NOT NULL,
	clubName varchar(30), 
	PRIMARY KEY (racerID),
	FOREIGN KEY (coach) REFERENCES Coach (coachID),
	FOREIGN KEY (clubName) REFERENCES Club (clubName)
); 
