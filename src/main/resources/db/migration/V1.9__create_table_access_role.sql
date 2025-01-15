CREATE TABLE access_role
(
    id            BIGINT NOT NULL,
    role          VARCHAR(20) NOT NULL,
    created_at    datetime NULL,
    last_modified datetime NULL,
    version       BIGINT NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);