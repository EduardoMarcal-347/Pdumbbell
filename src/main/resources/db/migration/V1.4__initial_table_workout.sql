CREATE TABLE workout
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    workout_name  VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NULL,
    day_of_week   VARCHAR(9)            NOT NULL,
    user_id       BINARY(16)            NOT NULL,
    created_at    datetime              NOT NULL,
    last_modified datetime              NULL,
    version       BIGINT                NULL,
    CONSTRAINT pk_workout PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user_info (id)
);

