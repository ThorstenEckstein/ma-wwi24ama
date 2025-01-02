
-- ~~~~~~~~~~~~~~~~~~~~~
-- !!! KOPIERVORLAGE !!!
-- ~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE IF NOT EXISTS USERS
(
    id int NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name  varchar(100) NOT NULL,
    Nickname   varchar(200),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ACCOUNTS
(
    id         int          NOT NULL,
    number     varchar(10)  NOT NULL,
    user_id    int,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES USERS(id)
);

INSERT INTO USERS VALUES (1, 'Max', 'Mutzke', null)
INSERT INTO USERS VALUES (2, 'Mark', 'Forster', null)
INSERT INTO USERS VALUES (3, 'Herbert', 'Grönemeyer', null)

INSERT INTO ACCOUNTS VALUES (1, '1234567890', 3)
INSERT INTO ACCOUNTS VALUES (2, '0987654321', 1)
INSERT INTO ACCOUNTS VALUES (3, '8822773366', 2)

SELECT
   u.ID,
   u.FIRST_NAME || ' ' || u.LAST_NAME as full_name,
   a.NUMBER as account_number
  FROM USERS u
  JOIN ACCOUNTS a
    ON u.id = a.user_id
 ORDER BY u.ID
