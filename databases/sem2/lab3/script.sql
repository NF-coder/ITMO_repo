-- lab 1

BEGIN;

DROP TABLE IF EXISTS Event ;
DROP TABLE IF EXISTS Object ;
DROP TABLE IF EXISTS AvilableAction ;

-- Создание таблиц
CREATE TABLE Object
(
    ObjectName TEXT PRIMARY KEY,
    IsGroup BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE AvilableAction
(
	ActionName TEXT PRIMARY KEY
);

CREATE TABLE Event
(
	EventId SERIAL PRIMARY KEY,
	Action TEXT NOT NULL REFERENCES AvilableAction(ActionName),
	PreviousEvent INTEGER REFERENCES Event(EventId),

	Target TEXT REFERENCES Object(ObjectName),
    Initiator TEXT REFERENCES Object(ObjectName),

	CONSTRAINT EeitherTargetOrInitiator CHECK (Target IS NOT NULL OR Initiator IS NOT NULL)
);

-- Вставка объектов
INSERT INTO Object(ObjectName, IsGroup) 
VALUES 
	('Глупые питекантропы', TRUE),
	('Способные питекантропы', TRUE),
	('Мысли', FALSE),
	('Смотрящий на Луну', FALSE),
	('Кристалл', FALSE),
	('Видения', FALSE),
	('Щупальца', FALSE);

-- Вставка действий
INSERT INTO AvilableAction(ActionName)
VALUES 
 	('Оставить в покое'),
	('Сосредоточить внимание'),
	('Почувствовать'),
	('Шариться в закаулках мозга'),
	('Начаться');

-- Вставка событий
INSERT INTO Event(Action, Target, Initiator, PreviousEvent)
VALUES 
	('Оставить в покое', 'Глупые питекантропы', 'Кристалл', NULL),
	('Сосредоточить внимание', 'Способные питекантропы', 'Кристалл', 1),
	('Почувствовать', 'Смотрящий на Луну', NULL, NULL),
	('Шариться в закаулках мозга', 'Смотрящий на Луну', 'Щупальца', 3),
	('Начаться', 'Смотрящий на Луну', NULL, 4);

END;

-- lab 3

BEGIN;

ALTER TABLE Event ADD PreviousAction TEXT REFERENCES AvilableAction(ActionName);

/*
CREATE OR REPLACE FUNCTION set_previous_action()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.PreviousEvent IS NOT NULL THEN
        SELECT Action INTO NEW.PreviousAction
        FROM Event
        WHERE EventId = NEW.PreviousEvent;
    ELSE
        NEW.PreviousAction := NULL;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_set_previous_action
	BEFORE INSERT OR UPDATE OF PreviousEvent
		ON Event
	FOR EACH ROW
		EXECUTE FUNCTION set_previous_action();
*/

CREATE OR REPLACE FUNCTION cascade_action_name_update()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE Event
    	SET PreviousAction = NEW.Action
    WHERE PreviousEvent = NEW.EventId;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_cascade_action_name_update
	AFTER UPDATE OF Action
		ON Event
	FOR EACH ROW
		EXECUTE FUNCTION cascade_action_name_update();

END;

-- tests
BEGIN;

INSERT INTO AvilableAction(ActionName)
VALUES 
 	('Какое-то действие');

INSERT INTO Event(Action, Target, Initiator, PreviousEvent)
VALUES 
	('Какое-то действие', 'Смотрящий на Луну', NULL, 4);

UPDATE Event 
	SET Action = 'Какое-то действие'
	WHERE Event.EventId = 1;

END;