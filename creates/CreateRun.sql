CREATE TABLE Run(
	raceID integer NOT NULL,
	runNumber integer NOT NULL PRIMARY KEY,
	trailName varchar(255),
	FOREIGN KEY (raceID) REFERENCES Race (raceID),
	FOREIGN KEY (trailName) references Trail (name)
);
