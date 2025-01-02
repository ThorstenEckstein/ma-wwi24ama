
-- ~~~~~~~~~~~~~~~~~~~~~
-- !!! KOPIERVORLAGE !!!
-- ~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE IF NOT EXISTS USERS
(
    `id`         int          NOT NULL,
    `first_name` varchar(100) NOT NULL,
    `last_name`  varchar(100) NOT NULL,
    `Nickname`   varchar(200),
    PRIMARY KEY (`id`)
);

INSERT INTO USERS VALUES (1, 'Elvis', 'Presley', null)
INSERT INTO USERS VALUES (2, 'Liam', 'Gallagher', 'William')
INSERT INTO USERS VALUES (3, 'Sylvester', 'Stallone', null)

SELECT * FROM USERS

UPDATE USERS SET Nickname = 'Sly' WHERE ID = 3;

