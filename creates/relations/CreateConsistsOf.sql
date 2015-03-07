CREATE TABLE ConsistsOf(
	raceID integer NOT NULL,
	runID integer NOT NULL,
	FOREIGN KEY (raceID) REFERENCES Race (raceID),
	FOREIGN KEY (runID) REFERNCES Run (runID)
);
