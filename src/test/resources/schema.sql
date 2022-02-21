CREATE SEQUENCE IF NOT EXISTS user_accounts_seq;

CREATE TABLE IF NOT EXISTS user_accounts (

user_id BIGINT NOT NULL DEFAULT nextval('user_accounts_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL unique,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
plate_number VARCHAR(100) NOT NULL unique
);