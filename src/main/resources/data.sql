delete from roles;
delete from tasks;
delete from users;

INSERT INTO users (id, username, password) VALUES (5, 'Nick', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC');
INSERT INTO users (id, username, password) VALUES (6, 'Anna', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy');
INSERT INTO users (id, username, password) VALUES (7, 'Mike', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO');

INSERT INTO tasks (id, user_id, name, description) VALUES (5, 5, 'Task #1', 'Description #1');
INSERT INTO tasks (id, user_id, name, description) VALUES (6, 5, 'Task #2', 'Description #2');

INSERT INTO roles(id, user_id, authority) VALUES (50, 5, 'ADMIN');
INSERT INTO roles(id, user_id, authority) VALUES (51, 6, 'USER');