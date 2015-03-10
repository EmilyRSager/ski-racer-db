/* Change Emily's club */
UPDATE Racer
SET clubName = 'CCHS'
WHERE Racer.lastName = 'Sager'
AND Racer.firstName = 'Emily';

/* Update all officials to 'Leader' role where they have assisted in more than 2 races */
UPDATE Official
SET role = 'Leader'
WHERE officialID IN (
	SELECT officialID
	FROM AssistsIn INNER JOIN Race
	ON raceID
	GROUP BY Race.mountainName
	HAVING COUNT(*) > 2
);

/* Raise salary of coaches at a club where every coach has rank above 8 */
UPDATE Coach
SET salary = 150000
WHERE clubName NOT EXISTS (
	SELECT clubName
	FROM Coach
	WHERE rank < 8
);

/*Insert all coaches and racers into Person, give them the same IDs*/
INSERT INTO Person (personID, firstName, lastName)
SELECT racerID, firstName, lastName
FROM Racer
UNION
SELECT coachID, firstName, lastName,
FROM Coach;
