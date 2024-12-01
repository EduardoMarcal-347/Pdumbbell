CREATE TABLE exercise
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    exercise_name  VARCHAR(255)          NOT NULL,
    `description`  VARCHAR(255)          NOT NULL,
    tutorial_url   VARCHAR(255)          NOT NULL,
    image_id       BIGINT                NOT NULL,
    target_muscles VARCHAR(255)          NOT NULL,
    created_at     datetime              NOT NULL,
    last_modified  datetime              NULL,
    version        BIGINT                NULL,
    CONSTRAINT pk_exercise PRIMARY KEY (id),
    CONSTRAINT CHK_exercise_date CHECK (
        created_at = date_format(created_at, '%d/%m/%Y %H:%i:%s') AND
        last_modified = date_format(last_modified, '%d/%m/%Y %H:%i:%s')
    )
);

ALTER TABLE exercise
    ADD CONSTRAINT FK_EXERCISE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES file_metadata (id);