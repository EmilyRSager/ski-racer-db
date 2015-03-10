/**
Selects all racers that have raced at any race Burke Mountain

**/

SELECT DISTINCT lastName, firstName
FROM Racer, CompetesIn
WHERE CompetesIn.raceID = ANY (
	SELECT Race.raceID
	FROM Race 
	WHERE Race.mountainName = 'Burke'
)