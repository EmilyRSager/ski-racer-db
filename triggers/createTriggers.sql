CREATE FUNCTION isUnder25() RETURNS trigger AS $isUnder25$
	BEGIN 
		IF NEW.dob < '1989-01-01' THEN 
			RAISE EXCEPTION 'Racer must be under 25';
		END IF;
	RETURN NEW;
	END;
$isUnder25$ LANGUAGE plpgsql;

CREATE TRIGGER isUnder25
	BEFORE INSERT OR UPDATE ON PERSON
	FOR EACH ROW EXECUTE PROCEDURE isUnder25();

