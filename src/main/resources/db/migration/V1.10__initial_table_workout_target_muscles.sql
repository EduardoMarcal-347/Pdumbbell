CREATE TABLE workout_target_muscles
(
    target_muscle_id BIGINT NOT NULL,
    workout_id       BIGINT NOT NULL
);

ALTER TABLE workout_target_muscles
    ADD CONSTRAINT fk_wtm_on_target_muscle FOREIGN KEY (target_muscle_id) REFERENCES target_muscle (id);

ALTER TABLE workout_target_muscles
    ADD CONSTRAINT fk_wtm_on_workout FOREIGN KEY (workout_id) REFERENCES workout (id);
