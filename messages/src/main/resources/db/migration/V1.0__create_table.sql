DROP TABLE IF EXISTS message;

CREATE TABLE message (
     id SERIAL NOT NULL PRIMARY KEY,
     username varchar(255) NOT NULL,
     text varchar(255) NOT NULL
);

