CREATE TYPE gender as ENUM ('MALE', 'FEMALE');

ALTER TABLE student ALTER COLUMN gender TYPE gender
USING (gender::gender)