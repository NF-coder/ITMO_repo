BEGIN;

CREATE TABLE ObjectType
(
    TypeName TEXT PRIMARY KEY
);
CREATE TABLE Object
(
	ObjectId SERIAL PRIMARY KEY,
    ObjectName TEXT NOT NULL, 
    ObjectType TEXT NOT NULL REFERENCES ObjectType(TypeName)
);
CREATE TABLE AvilableAction
(
	ActionName TEXT PRIMARY KEY,
);
CREATE TABLE Event
(
	EventId SERIAL PRIMARY KEY,
	Action TEXT NOT NULL REFERENCES AvilableAction(ActionName),
	PreviousEvent INTEGER REFERENCES Action(ActionId),

	ActionTargetObject INTEGER REFERENCES Object(ObjectId),
    ActionTargetType TEXT REFERENCES ObjectType(TypeName),
    ActionInitiator INTEGER REFERENCES Object(ObjectId),

	CONSTRAINT EeitherTargetOrInitiator CHECK (ActionTargetObject IS NOT NULL OR ActionTargetType IS NOT NULL OR ActionInitiator IS NOT NULL)
);

INSERT INTO ObjectType(TypeName) 
VALUES 
	('Глупые питекантропы'),
	('Способные питекантропы'),
	('Мысли'),
	('Природные объекты');

INSERT INTO Object(ObjectName, ObjectType) 
VALUES 
	('Смотрящий на Луну', 'Способные питекантропы'),
	('Кристалл', 'Природные объекты'),
	('Видения', 'Мысли'),
	('Щупальца', 'Мысли');

INSERT INTO AvilableAction(ActionName)
VALUES 
 	('Оставить в покое'),
	('Сосредоточить внимание'),
	('Почувствовать'),
	('Шариться в закаулках мозга'),
	('Начаться');

INSERT INTO Event(Action, PreviousEvent, ActionTargetObject, ActionTargetType, ActionInitiator)
VALUES 
	('Оставить в покое', NULL, NULL, 'Глупые питекантропы', 2), -- Крсталл оставил некоторых питекантропов в покое
	('Сосредоточить внимание', NULL, NULL, 'Способные питекантропы', 2), -- Кристалл сосредоточил внимание на способных питекантропах
	('Почувствовать', NULL, 1, NULL, NULL), -- Смотрящий на Луну почувствовал
	('Шариться в закаулках мозга', NULL, 1, NULL, 4), -- Щупальца шарятся в закаулках мозга Смотрящего на Луну
	('Начаться', 4, 1, NULL, 3); -- Затем у Смотрящего на Луну начались видения

END;