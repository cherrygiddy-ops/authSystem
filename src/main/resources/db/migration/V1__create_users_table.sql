CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,
                       email VARCHAR(150) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       verified BOOLEAN NOT NULL DEFAULT TRUE,
                       locked BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       last_login TIMESTAMP,
                       profile_picture_url VARCHAR(255),
                       reset_token VARCHAR(255),
                       reset_token_expiry TIMESTAMP,
                       verification_token VARCHAR(255),
                       verification_token_expiry TIMESTAMP
);
