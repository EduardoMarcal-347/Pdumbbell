CREATE TABLE users_roles
(
    role_id BIGINT NOT NULL,
    user_id BINARY(16) NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES access_role (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user_info (id);
