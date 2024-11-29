CREATE TABLE training_set
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    weight              INT NOT NULL,
    metric              VARCHAR(2) DEFAULT "kg",
    reps_qty            INT NULL,
    exercise_session_id BIGINT NOT NULL,
    CONSTRAINT pk_training_set PRIMARY KEY (id)
);

ALTER TABLE training_set
    ADD CONSTRAINT FK_TRAINING_SET_ON_EXERCISE_SESSION FOREIGN KEY (exercise_session_id) REFERENCES exercise_session (id);