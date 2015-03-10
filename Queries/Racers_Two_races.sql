 SELECT racerID 
 FROM 
 (
	(SELECT  racerID, COUNT(racerID), raceID 
	FROM CompetesIn 
	GROUP BY racerID 
	HAVING COUNT(racerID) >= 2)

	INNER JOIN 

	(SELECT raceID 
	FROM Race 
	WHERE date > '2015-01-01') as y
	ON x.raceID = y.raceID)
);
