DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (description, calories, datetime, user_id) VALUES
  ('Салат', 299, CURRENT_TIMESTAMP, 100000),
  ('Каша', 400, CURRENT_TIMESTAMP, 100000),
  ('Шоколад', 300, CURRENT_TIMESTAMP, 100000),
  ('Салат админа', 299, CURRENT_TIMESTAMP, 100001),
  ('Каша админа', 400, CURRENT_TIMESTAMP, 100001),
  ('Шоколад админа', 300, CURRENT_TIMESTAMP, 100001);