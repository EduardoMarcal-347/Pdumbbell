CREATE TABLE workout
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    workout_name         VARCHAR(255)          NOT NULL,
    `description`        VARCHAR(255)          NULL,
    workout_performed_at datetime              NULL,
    workout_template_id  BIGINT                NULL,
    user_id              BINARY(16)            NOT NULL,
    created_at           datetime              NOT NULL,
    last_modified        datetime              NULL,
    version              BIGINT                NULL,
    CONSTRAINT pk_workout PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user_info (id),
    CONSTRAINT FK_WORKOUT_ON_WORKOUT_TEMPLATE FOREIGN KEY (workout_template_id) REFERENCES workout_template (id)
);
