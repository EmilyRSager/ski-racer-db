CREATE TABLE Trail(
	name varchar(255) NOT NULL PRIMARY KEY,
	mountainName varchar(255),
	FOREIGN KEY (mountainName) REFERENCES Mountain (Name)
);
