CREATE TABLE IF NOT EXISTS users
(
    id                                  INT8 PRIMARY KEY,
    username                            VARCHAR(255) NOT NULL,
    CONSTRAINT username_unique UNIQUE (username)
    );
