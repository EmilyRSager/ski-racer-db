CREATE TABLE CompetesIn
(
	racerID int NOT NULL REFERENCES Racer (racerID), 
	raceID int REFERENCES Race (raceID),
	seed int,
	Primary Key (racerID)
);