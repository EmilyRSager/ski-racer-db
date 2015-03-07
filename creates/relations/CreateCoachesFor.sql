CREATE TABLE CompetesIn (
	racerID integer NOT NULL,
	raceID integer NOT NULL,
	seed integer NOT NULL
	FOREIGN KEY racerID REFERENCES Racer (racerID),
	FOREIGN KEY raceID REFERENCES Race (raceID)
);
