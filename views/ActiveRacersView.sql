CREATE VIEW ActiveRacers AS
	SELECT lastName, firstName
	FROM Racer INNER JOIN CompetesIn
	ON Racer.racerID = CompetesIn.racerID
	WHERE EXISTS (
		SELECT *
		FROM CompetesIn INNER JOIN Race
		ON CompetesIn.raceID = Race.raceID
		WHERE Race.raceDate > '2014-09-01'
	--	GROUP BY Race.raceDate
	--	HAVING COUNT(*) > 2
	);
