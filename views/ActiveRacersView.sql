CREATE VIEW ActiveRacers AS
	SELECT lastName, firstName
	FROM Racer INNER JOIN CompetesIn C
	ON Racer.racerID = C.racerID
	WHERE EXISTS (
		SELECT *
		FROM C INNER JOIN Race
		ON C.raceID = Race.raceID
		WHERE Race.raceDate > '2014-09-01'
		GROUP BY Race.raceDate
		HAVING COUNT(*) > 2
	);
