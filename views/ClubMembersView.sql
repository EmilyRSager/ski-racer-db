CREATE VIEW ClubMembersView AS
	SELECT * 
	FROM (
		SELECT lastName, firstName, Club.clubName
		FROM Racer, Club
		WHERE Racer.clubName = Club.clubName
		UNION
		SELECT lastName, firstName, Club.clubName
		FROM Coach, Club
		WHERE Coach.clubname = Club.clubName
	) AS T
	ORDER BY T.clubName;
