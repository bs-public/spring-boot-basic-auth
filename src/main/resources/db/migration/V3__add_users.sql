-- password is 'password' encoded with BCrypt
INSERT INTO user (email, first_name, last_name, password, role_id) VALUES ('test.user1@mail.com', 'Test1', 'User1', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 2);
INSERT INTO user (email, first_name, last_name, password, role_id) VALUES ('test.user2@mail.com', 'Test2', 'User2', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 2);
INSERT INTO user (email, first_name, last_name, password, role_id) VALUES ('admin@mail.com', 'Admin', 'User', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 1);
