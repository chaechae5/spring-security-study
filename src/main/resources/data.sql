INSERT  INTO users(id, username, password, algorithm) VALUES ( 1,'chae', '$2a$10$dkPw6nCLHoNHd.xCE5PvsOQ8vm6H.EMvwDrjf7/ULQHXWgez9TL3C', 'BCRYPT');
INSERT  INTO authorities(id, name, user_id) VALUES (1, 'READ', 1);
INSERT  INTO authorities(id, name, user_id) VALUES (2, 'WRITE', 1);
INSERT  INTO product(id, name, price, currency) VALUES (1, 'Chocolate', '10','USD');