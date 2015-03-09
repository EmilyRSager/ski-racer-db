CREATE TABLE Run(
	raceID integer NOT NULL,
	runNumber integer NOT NULL,
	trailName varchar(255),
	setByCoach integer NOT NULL,
	FOREIGN KEY (raceID) REFERENCES Race (raceID),
	FOREIGN KEY (trailName) references Trail (name),
	FOREIGN KEY (setByCoach) references Coach (coachID),
	PRIMARY KEY (raceID, runNumber)
);
