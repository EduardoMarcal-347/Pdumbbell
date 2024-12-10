CREATE TABLE user_info
(
    id                    BINARY(16) PRIMARY KEY,
    username              VARCHAR(255) NOT NULL,
    full_name             VARCHAR(255) NOT NULL,
    email                 VARCHAR(255) NOT NULL,
    phone_number          VARCHAR(255) NOT NULL,
    password_hash         VARCHAR(255) NOT NULL,
    is_email_verified     BIT(1) DEFAULT 0,
    last_login            datetime NULL,
    failed_login_attempts INT DEFAULT 0,
    account_locked        BIT(1) DEFAULT 0,
    preferred_language    VARCHAR(255) NULL,
    is_active             BIT(1) DEFAULT 1,
    deleted_at            datetime NULL,
    profile_picture_id    BIGINT NULL,
    created_at            datetime NULL,
    last_modified         datetime NULL,
    version               BIGINT NOT NULL
);

ALTER TABLE user_info
    ADD CONSTRAINT uc_user_info_email UNIQUE (email);

ALTER TABLE user_info
    ADD CONSTRAINT uc_user_info_phone_number UNIQUE (phone_number);

ALTER TABLE user_info
    ADD CONSTRAINT uc_user_info_profile_picture UNIQUE (profile_picture_id);

ALTER TABLE user_info
    ADD CONSTRAINT FK_USER_INFO_ON_PROFILE_PICTURE FOREIGN KEY (profile_picture_id) REFERENCES file_metadata (id);