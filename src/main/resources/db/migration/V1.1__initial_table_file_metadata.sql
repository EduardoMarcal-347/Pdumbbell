CREATE TABLE file_metadata
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    file_name     VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NULL,
    mime_type     VARCHAR(75) NOT NULL,
    extension     VARCHAR(6) NOT NULL,
    size          INT NOT NULL,
    location      VARCHAR(255) NOT NULL,
    owner_id      VARCHAR(255) NULL,
    status        VARCHAR(30) DEFAULT "PROCESSING",
    checksum      VARCHAR(255) NOT NULL,
    upload_date   datetime NOT NULL,
    last_modified datetime NULL,
    CONSTRAINT pk_file_metadata PRIMARY KEY (id),
    CONSTRAINT CHK_date CHECK (
        last_modified = date_format(last_modified, '%d/%m/%Y %H:%i:%s') AND
        upload_date = date_format(upload_date, '%d/%m/%Y %H:%i:%s')
    )
);