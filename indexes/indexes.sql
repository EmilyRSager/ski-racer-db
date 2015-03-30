--allows for fast searching of racers by name
CREATE INDEX RacerNameIndex ON Racer(firstName, lastName);

--allows for fast searching for races on a given mountain
CREATE INDEX MountainIndex ON Race(mountainName);