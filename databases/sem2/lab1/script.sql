BEGIN;


CREATE TABLE Object
(
    ObjectName TEXT PRIMARY KEY, 
    IsGroup BOOLEAN NOT NULL DEFAULT FALSE,
    RelatedGroup INTEGER REFERENCES Object(ObjectName) DEFAULT NULL,

    CONSTRAINT RelatedGroup CHECK (IsGrpop is FALSE OR IsGroup IS TRUE AND RelatedGroup IS NULL)
);
CREATE TABLE AvilableAction
(
	ActionName TEXT PRIMARY KEY,
);
CREATE TABLE Event
(
	EventId SERIAL PRIMARY KEY,
	Action TEXT NOT NULL REFERENCES AvilableAction(ActionName),
	PreviousEvent INTEGER REFERENCES Action(ActionId) DEFAULT NULL,

	Target INTEGER REFERENCES Object(ObjectName),
    Initiator INTEGER REFERENCES Object(ObjectName),

	CONSTRAINT EeitherTargetOrInitiator CHECK (Target IS NOT NULL OR Initiator IS NOT NULL)
);

INSERT INTO Object(ObjectName, IsGroup, RelatedGroup) 
VALUES 
	('Глупые питекантропы', TRUE),
	('Способные питекантропы', TRUE),
	('Мысли', TRUE),
	('Смотрящий на Луну', FALSE, 2),
	('Кристалл'),
	('Видения', FALSE, 3),
	('Щупальца', FALSE, 3);

INSERT INTO AvilableAction(ActionName)
VALUES 
 	('Оставить в покое'),
	('Сосредоточить внимание'),
	('Почувствовать'),
	('Шариться в закаулках мозга'),
	('Начаться');

INSERT INTO Event(Action, Target, Initiator, PreviousEvent)
VALUES 
	('Оставить в покое', 'Глупые питекантропы', 'Кристалл'), -- Крсталл оставил некоторых питекантропов в покое
	('Сосредоточить внимание', 'Способные питекантропы', 'Кристалл'), -- Кристалл сосредоточил внимание на способных питекантропах
	('Почувствовать', 'Смотрящий на Луну', NULL), -- Смотрящий на Луну почувствовал
	('Шариться в закаулках мозга', 'Щупальца', NULL, 3), -- Щупальца шарятся в закаулках мозга Смотрящего на Луну
	('Начаться', 'Видения', NULL, 4); -- Затем у Смотрящего на Луну начались видения

END;