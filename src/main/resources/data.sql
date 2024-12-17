INSERT  INTO users(id, username, password, algorithm) VALUES ( 1,'chae', '$2b$12$WJcmOvgNQZ6m65E32vAWke8oYIQnpOEjC0bfMC/F5bPX4x2Ex3Mky', 'BCRYPT');
INSERT  INTO authorities(id, name, user_id) VALUES (1, 'READ', 1);
INSERT  INTO authorities(id, name, user_id) VALUES (2, 'WRITE', 1);
INSERT  INTO product(id, name, price, currency) VALUES (1, 'Chocolate', '10','USD');