CREATE TABLE workout_exercise_template
(
    workout_template_id          BIGINT NOT NULL,
    exercise_session_template_id BIGINT NOT NULL,
    CONSTRAINT fk_worktemp_on_exercise_session_template FOREIGN KEY (exercise_session_template_id) REFERENCES exercise_session_template (id),
    CONSTRAINT fk_worktemp_on_workout_template FOREIGN KEY (workout_template_id) REFERENCES workout_template (id)
);
