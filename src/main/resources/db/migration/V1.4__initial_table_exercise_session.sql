CREATE TABLE exercise_session
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    exercise_id BIGINT NULL,
    workout_id  BIGINT NOT NULL,
    CONSTRAINT pk_exercise_session PRIMARY KEY (id)
);

ALTER TABLE exercise_session
    ADD CONSTRAINT FK_EXERCISE_SESSION_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id);

ALTER TABLE exercise_session
    ADD CONSTRAINT FK_EXERCISE_SESSION_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workout (id);