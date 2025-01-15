CREATE TABLE target_muscle
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    muscle        VARCHAR(255) NULL,
    created_at    datetime NULL,
    last_modified datetime NULL,
    version       BIGINT DEFAULT 1,
    CONSTRAINT pk_target_muscle PRIMARY KEY (id)
);