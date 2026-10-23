use ecole4;

SELECT * FROM RESULTATS WHERE num_eleve;

DELETE FROM RESULTATS WHERE num_cours = 3;

SELECT * FROM RESULTATS WHERE NUM_ELEVE=2 AND NUM_COURS=3;

DROP TRIGGER IF EXISTS points_check_insert;
DROP TRIGGER IF EXISTS points_check_update;

DELIMITER //
CREATE TRIGGER points_check_insert
BEFORE INSERT ON RESULTATS
FOR EACH ROW
BEGIN 
    IF NEW.points < 0 OR NEW.points > 20 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur, la note doit être comprise entre [0-20]';
    END IF;
END //

DELIMITER //
CREATE trigger points_check_upd
BEFORE UPDATE ON RESULTATS
FOR EACH ROW
BEGIN 
	IF NEW.points < 0 OR NEW.points > 20 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Erreur, la note doit être comprise entre [0-20]';
    END IF;
    
END //
DELIMITER ;