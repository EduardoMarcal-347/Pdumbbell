CREATE TABLE exercise
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    exercise_name  VARCHAR(255) NOT NULL,
    `description`    VARCHAR(255) NOT NULL,
    tutorial_url   VARCHAR(255) NOT NULL,
    image_id       BIGINT NOT NULL,
    target_muscles VARCHAR(255) NOT NULL,
    CONSTRAINT pk_exercise PRIMARY KEY (id)
);

ALTER TABLE exercise
    ADD CONSTRAINT FK_EXERCISE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES file_metadata(id);