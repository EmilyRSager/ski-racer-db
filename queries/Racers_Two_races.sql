--retreives racers who have competed in at least 2 races this year

 SELECT racerID
 FROM
 (
	(
		SELECT  racerID, COUNT(racerID), raceID AS X
		FROM CompetesIn 
		GROUP BY racerID
		HAVING COUNT(racerID) >= 2
	)

	INNER JOIN

	(
		SELECT raceID AS Y
		FROM Race 
		WHERE date > '2015-01-01'
	)
	ON X.raceID = Y.raceID
);
