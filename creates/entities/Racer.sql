CREATE TABLE RACER 
(
	racerID int NOT NULL, 
	rank int CHECK (Rank > 0), 
	points int,
	coach integer NOT NULL,
	club integer NOT NULL, 
	PRIMARY KEY (racerID),
	FOREIGN KEY (coach) REFERENCES Coach (coachID),
	FOREIGN KEY (club) REFERENCES Club (clubID)

); 
