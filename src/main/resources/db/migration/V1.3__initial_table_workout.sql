CREATE TABLE workout
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    workout_name  VARCHAR(255)          NOT NULL,
    day_of_week   VARCHAR(9)            NOT NULL,
    `description` VARCHAR(255)          NULL,
    created_at    datetime              NOT NULL,
    last_modified datetime              NULL,
    version       BIGINT                NULL,
    CONSTRAINT pk_workout PRIMARY KEY (id),
    CONSTRAINT CHK_workout_date CHECK (
        created_at = date_format(created_at, '%d/%m/%Y %H:%i:%s') AND
        last_modified = date_format(last_modified, '%d/%m/%Y %H:%i:%s')
    )
);