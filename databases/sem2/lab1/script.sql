BEGIN;

CREATE TABLE IF NOT EXISTS ObjectType
(
    TypeName TEXT PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS Object
(
	ObjectId SERIAL PRIMARY KEY,
    ObjectName TEXT NOT NULL, 
    ObjectType TEXT NOT NULL REFERENCES ObjectType(TypeName)
);
CREATE TABLE IF NOT EXISTS AvilableAction
(
	ActionName TEXT PRIMARY KEY,
	ActionTargetObject INTEGER REFERENCES Object(ObjectId),
    ActionTargetType TEXT REFERENCES ObjectType(TypeName),
    ActionInitiator INTEGER REFERENCES Object(ObjectId),
    CONSTRAINT EeitherTargetOrInitiator CHECK (ActionTargetObject IS NOT NULL OR ActionTargetType IS NOT NULL OR ActionInitiator IS NOT NULL)
);
CREATE TABLE IF NOT EXISTS Action
(
	ActionId SERIAL PRIMARY KEY,
    Action TEXT NOT NULL REFERENCES AvilableAction(ActionName),
    PreviousAction INTEGER REFERENCES Action(ActionId)
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

INSERT INTO AvilableAction(ActionName, ActionTargetObject, ActionTargetGroup, ActionInitiator)
VALUES 
 	('Оставить в покое', NULL, 'Глупые питекантропы', 2),
	('Сосредоточить внимание', NULL, 'Способные питекантропы', 2),
	('Почувствовать', 1, NULL, NULL),
	('Шариться в закаулках мозга', 1, NULL, 4),
	('Начаться', 1, NULL, 3);

INSERT INTO Action(Action, PreviousAction)
VALUES 
	(1, NULL), -- Крсталл оставил некоторых питекантропов в покое
	(2, NULL), -- Кристалл сосредоточил внимание на способных питекантропах
	(3, NULL), -- Смотрящий на Луну почувствовал
	(4, NULL), -- Щупальца шарятся в закаулках мозга Смотрящего на Луну
	(5, 4); -- Затем у Смотрящего на Луну начались видения

-- END;