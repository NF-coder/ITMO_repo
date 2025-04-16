BEGIN;

CREATE TABLE Object
(
	ObjectId SERIAL PRIMARY KEY,
    ObjectName TEXT NOT NULL
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

	Target INTEGER REFERENCES Object(ObjectId),
    Initiator INTEGER REFERENCES Object(ObjectId),

	CONSTRAINT EeitherTargetOrInitiator CHECK (Target IS NOT NULL OR Initiator IS NOT NULL)
);

INSERT INTO Object(ObjectName) 
VALUES 
	('Глупые питекантропы'),
	('Способные питекантропы'),
	('Мысли'),
	('Смотрящий на Луну'),
	('Кристалл'),
	('Видения'),
	('Щупальца');

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
	('Сосредоточить внимание', 'Способные питекантропы', 'Кристалл', 1), -- Кристалл сосредоточил внимание на способных питекантропах
	('Почувствовать', 'Смотрящий на Луну'), -- Смотрящий на Луну почувствовал
	('Шариться в закаулках мозга', 'Смотрящий на Луну', 'Щупальца', 3), -- Щупальца шарятся в закаулках мозга Смотрящего на Луну
	('Начаться', 'Смотрящий на Луну', NULL, 4); -- Затем у Смотрящего на Луну начались видения

END;