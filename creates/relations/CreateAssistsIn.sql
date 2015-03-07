CREATE TABLE AssistsIn (
	officialID integer NOT NULL,
	raceID integer NOT NULL,
	FOREIGN KEY officialID REFERENCES Official (officialID),
	FOREIGN KEY raceID REFERENCES Race (raceID)
);
