/*
Find the winner of the second run of a race
*/

SELECT lastName, firstName, time FROM
FROM Racer INNER JOIN HasTime
WHERE time = (
    SELECT MIN(H.time)
    FROM HasTime INNER JOIN H, CompetesIn AS C
    WHERE H.racerID = C.racerID AND H.raceID = C.raceID AND HasTime.runNumber = 2 AND C
);



--get all the racers in a race
Select RacerID  

From CompetesIn

Where RaceID = USSA (ID)   




--get all the runs in a Race joined with all the times of those runs 
Select RacerID, RacerName, SUM runtime 
FROM 
    (
        (
            (
                (Select RunID 
                From ConsistsOF
                Where RaceID = USSA (ID))
                
                    INNER JOIN (HasTime))  
                        
                        Inner JOin (Racer) )
            
            Group by RacerID)
    
            ORder by SUM runtime
