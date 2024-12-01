CREATE TABLE training_set
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    weight              INT NOT NULL,
    metric              VARCHAR(2) DEFAULT "kg",
    reps_qty            INT NULL,
    exercise_session_id BIGINT NOT NULL,
    created_at          datetime NOT NULL,
    last_modified       datetime NULL,
    version             BIGINT NULL,
    CONSTRAINT pk_training_set PRIMARY KEY (id),
    CONSTRAINT CHK__training_set_date CHECK (
        created_at = date_format(created_at, '%d/%m/%Y %H:%i:%s') AND
        last_modified = date_format(last_modified, '%d/%m/%Y %H:%i:%s')
    )
);

ALTER TABLE training_set
    ADD CONSTRAINT FK_TRAINING_SET_ON_EXERCISE_SESSION FOREIGN KEY (exercise_session_id) REFERENCES exercise_session (id);