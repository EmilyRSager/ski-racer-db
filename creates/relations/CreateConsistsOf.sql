CREATE TABLE ConsistsOf(
	raceID integer NOT NULL,
	runNumber integer NOT NULL,
	FOREIGN KEY (raceID) REFERENCES Race (raceID),
	FOREIGN KEY (runNumber, raceID) REFERENCES Run (runNumber, raceID)
);
