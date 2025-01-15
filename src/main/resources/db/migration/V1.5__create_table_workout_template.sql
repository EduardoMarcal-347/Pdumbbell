CREATE TABLE workout_template
(
    id            BIGINT NOT NULL,
    template_name VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    creator_id    BINARY(16)   NULL,
    created_at    datetime NULL,
    last_modified datetime NULL,
    version       BIGINT NOT NULL,
    CONSTRAINT pk_workout_template PRIMARY KEY (id),
    CONSTRAINT FK_WORKOUT_TEMPLATE_ON_CREATOR FOREIGN KEY (creator_id) REFERENCES user_info (id)
);