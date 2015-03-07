CREATE TABLE HasTime (
	racerID integer NOT NULL,
	runID integer NOT NULL,
	time decimal(5,2) NOT NULL,
	FOREIGN KEY (racerID) REFERENCES Racer (racerID),
	FOREIGN KEY (runID) REFERENCES Run (runID)
);
