CREATE TABLE exercise_session
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    exercise_id   BIGINT NULL,
    workout_id    BIGINT   NOT NULL,
    created_at    datetime NOT NULL,
    last_modified datetime NULL,
    version       BIGINT NULL,
    CONSTRAINT pk_exercise_session PRIMARY KEY (id),
    CONSTRAINT CHK_exercise_session_date CHECK (
        created_at = date_format(created_at, '%d/%m/%Y %H:%i:%s') AND
        last_modified = date_format(last_modified, '%d/%m/%Y %H:%i:%s')
        )
);

ALTER TABLE exercise_session
    ADD CONSTRAINT FK_EXERCISE_SESSION_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id);

ALTER TABLE exercise_session
    ADD CONSTRAINT FK_EXERCISE_SESSION_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workout (id);