/*
For each the Race, get all the racers in that race
for each racer find all their runs in that race
find the times for each of those runs, add them 
the winner is the lowest added run time (order by runtime) 
*/





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
