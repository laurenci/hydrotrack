INSERT INTO users (id, username, daily_amount)
VALUES (1, 'john_doe', 12.5),
       (2, 'jane_smith', 0),
       (3, 'alex_unknown', 8.75),
       (4, 'sam_williams', 15.0),
       (5, 'maria_gonzalez', 20.25);

INSERT INTO profile (user_id, first_name, last_name, sex, birthday_date)
VALUES (1, 'John', 'Doe', 'MALE', '1990-05-15'),
       (2, 'Jane', 'Smith', 'FEMALE', '1985-09-23'),
       (3, 'Alex', 'Unknown', 'UNCERTAIN', NULL),
       (4, 'Sam', 'Williams', 'OTHER', '2000-01-01'),
       (5, 'Maria', 'Gonzalez', 'FEMALE', '1995-12-12');

INSERT INTO drink_types (type, `group`)
VALUES ('Water', 'BASIC'),
       ('Soda', 'BASIC'),
       ('Orange Juice', 'BASIC'),
       ('Green Tea', 'TEA'),
       ('Chamomile', 'TEA'),
       ('Espresso', 'COFFEE'),
       ('Cold Brew', 'COFFEE'),
       ('Red Bull', 'ENERGY_DRINK'),
       ('Monster', 'ENERGY_DRINK'),
       ('Energy drink', 'ENERGY_DRINK');

INSERT INTO drinks (type, brand, name)
VALUES ('Soda', 'Coca-Cola', 'Coke Classic'),
       ('Orange Juice', 'Tropicana', 'Orange Juice'),
       ('Water', 'Evian', 'Natural Spring'),
       ('Red Bull', 'Red Bull GmbH', 'Red Bull Original'),
       ('Green Tea', 'Lipton', 'Lipton Green');

INSERT INTO custom_drinks (user_id, type, brand, name)
VALUES (1, 'Chamomile', NULL, 'Chamomile Relax'),
       (2, 'Cold Brew', 'Starbucks', 'Vanilla Cold Brew'),
       (3, 'Green Tea', NULL, 'Homemade Green'),
       (4, 'Monster', 'Monster Energy', 'Ultra Sunrise'),
       (5, 'Espresso', 'Lavazza', 'Double Espresso');
