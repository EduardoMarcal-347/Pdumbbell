CREATE TABLE exercise_session_template
(
    id            BIGINT NOT NULL,
    identifier    VARCHAR(255) NULL,
    qty_sets      INT    NOT NULL,
    exercise_id   BIGINT NULL,
    created_at    datetime NULL,
    last_modified datetime NULL,
    version       BIGINT NOT NULL,
    CONSTRAINT pk_exercise_session_template PRIMARY KEY (id)
);

ALTER TABLE exercise_session_template
    ADD CONSTRAINT FK_EXERCISE_SESSION_TEMPLATE_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id);