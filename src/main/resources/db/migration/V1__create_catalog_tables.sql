CREATE TABLE categories (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255) NULL,
    active      BIT(1)       NOT NULL DEFAULT b'1',
    PRIMARY KEY (id),
    CONSTRAINT uk_categories_name UNIQUE (name)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE service_types (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    name            VARCHAR(100) NOT NULL,
    description     VARCHAR(255) NULL,
    urgent_allowed  BIT(1)       NOT NULL DEFAULT b'0',
    reference_price DOUBLE       NOT NULL,
    active          BIT(1)       NOT NULL DEFAULT b'1',
    category_id     BIGINT       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_service_types_category_name UNIQUE (category_id, name),
    CONSTRAINT fk_service_types_category FOREIGN KEY (category_id)
        REFERENCES categories (id) ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
