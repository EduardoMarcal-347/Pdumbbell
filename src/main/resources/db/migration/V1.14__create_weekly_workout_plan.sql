CREATE TABLE weekly_workout_plan
(
    id                BIGINT NOT NULL,
    user_id           BINARY(16) NULL,
    monday_workout    BIGINT NULL,
    tuesday_workout   BIGINT NULL,
    wednesday_workout BIGINT NULL,
    thursday_workout  BIGINT NULL,
    friday_workout    BIGINT NULL,
    saturday_workout  BIGINT NULL,
    sunday_workout    BIGINT NULL,
    created_at        datetime NULL,
    last_modified     datetime NULL,
    version           BIGINT NOT NULL,
    CONSTRAINT pk_weekly_workout_plan PRIMARY KEY (id),
    CONSTRAINT uc_weekly_workout_plan_user UNIQUE (user_id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_MONDAY_WORKOUT FOREIGN KEY (monday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_TUESDAY_WORKOUT FOREIGN KEY (tuesday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_WEDNESDAY_WORKOUT FOREIGN KEY (wednesday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_THURSDAY_WORKOUT FOREIGN KEY (thursday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_FRIDAY_WORKOUT FOREIGN KEY (friday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_SATURDAY_WORKOUT FOREIGN KEY (saturday_workout) REFERENCES workout_template (id),
    CONSTRAINT FK_WEEKLY_WORKOUT_PLAN_ON_SUNDAY_WORKOUT FOREIGN KEY (sunday_workout) REFERENCES workout_template (id)
);