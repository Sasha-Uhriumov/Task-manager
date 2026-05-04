
CREATE SEQUENCE task_sequence START 1 INCREMENT 1;
CREATE SEQUENCE status_sequence START 1 INCREMENT 1;

CREATE TABLE status (
    id BIGINT PRIMARY KEY DEFAULT nextval('status_sequence'),
    status_name VARCHAR(20) NOT NULL
);

CREATE TABLE Tasks (
    id BIGINT PRIMARY KEY DEFAULT nextval('task_sequence'),
    title VARCHAR(200) NOT NULL,
    status_id BIGINT NOT NULL,

    CONSTRAINT task_status
                   FOREIGN KEY (status_id)
                   REFERENCES status(id)
                   ON DELETE RESTRICT
);