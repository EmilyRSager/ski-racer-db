SELECT RacerID, runNum.runNumber, time

FROM (
			(SELECT runNumber
			FROM ConsistsOf
			WHERE RaceID = 34567) AS runNum 

			INNER JOIN 

			(SELECT * FROM HasTime) AS t
			ON runNum.runNumber = t.runNumber
	)
; 
