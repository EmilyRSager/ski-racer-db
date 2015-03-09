SELECT RacerID, RunID, runTime

FROM (
		(
			SELECT RunID 
			FROM ConsistsOf
			WHERE RaceID = myID)

			INNER JOIN 

			(HasTime)
	) 

