SELECT racerID 
FROM 
(
	(SELECT  /*Count (racerID), */ raceID, racerID
	FROM CompetesIn 
	GROUP BY racerID 
	HAVING COUNT(racerID) >= 2)


	INNER JOIN 

	(SELECT raceID 
	FROM Race 
	WHERE date > '2015-01-01') 
);
