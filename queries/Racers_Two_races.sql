--retreives racers who have competed in at least 2 races

SELECT C.racerID, C.raceID
FROM (
	SELECT racerID
	FROM CompetesIn
	--date
	GROUP BY racerID
	HAVING COUNT(*) > 1
) 
AS CurrentRacer 
INNER JOIN CompetesIn C 
ON C.racerID = CurrentRacer.racerID
