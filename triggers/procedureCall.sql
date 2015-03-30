CREATE OR REPLACE FUNCTION update_rank()
RETURNS trigger AS $update_rank$
DECLARE 
	p1 racer%ROWTYPE;
	rankCounter INTEGER;
	rowNumber INTEGER;
	loopCounter INTEGER;
BEGIN
	DELETE FROM triggerCheck;
	UPDATE RACER SET points = NEW.points WHERE racerid = NEW.racerid;
	rankCounter = 0;
	loopCounter = 0;
	rowNumber = (SELECT COUNT(*) from RACER);
	FOR p1 IN SELECT * FROM RACER  LOOP
		
		IF p1.points > NEW.points THEN
			UPDATE RACER SET rank = rank+1 WHERE racerid = p1.racerid;
			rankCounter = rankCounter + 1;
		ELSE
		END IF;
		loopCounter = loopCounter +1;
	END LOOP;
	UPDATE RACER SET rank = rank-rankCounter WHERE racerid = NEW.racerid;
	INSERT INTO triggerCheck(checker) VALUES (1);
END
$update_rank$ LANGUAGE plpgsql;

CREATE TABLE triggerCheck(
	checker INTEGER
);
INSERT INTO triggerCheck(checker) values (1);

CREATE TRIGGER update_rank BEFORE UPDATE OF points ON RACER 
	FOR EACH STATEMENT
	WHEN ( (SELECT count(*) FROM triggerCheck) = 1)
	EXECUTE PROCEDURE update_rank();
