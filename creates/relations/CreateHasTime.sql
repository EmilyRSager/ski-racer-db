CREATE TABLE HasTime (
	racerID integer NOT NULL,
	raceID integer NOT NULL,
	runNumber integer NOT NULL,
	time decimal(5,2) NOT NULL,
	PRIMARY KEY (racerID, raceID, runID),
	FOREIGN KEY (racerID) REFERENCES Racer (racerID),
	FOREIGN KEY (raceID) REFERENCES Race (raceID),
	FOREIGN KEY (runNumber) REFERENCES Run (runNumber)
);
