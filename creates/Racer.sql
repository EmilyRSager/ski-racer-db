CREATE TABLE RACER 
(
	racerID int NOT NULL, 
	rank int CHECK (Rank > 0), 
	points int, 
	PRIMARY KEY (racerID)

); 