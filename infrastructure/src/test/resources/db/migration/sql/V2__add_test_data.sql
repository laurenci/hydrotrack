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

-- SYSTEM records
INSERT INTO records (user_id, drink_id, area, amount, date)
VALUES (1, 1, 'SYSTEM', 0.5, '2025-05-10 08:15:00'),  -- Coke Classic
       (1, 3, 'SYSTEM', 0.25, '2025-05-10 12:00:00'), -- Natural Spring
       (2, 2, 'SYSTEM', 0.3, '2025-05-09 09:30:00'),  -- Orange Juice
       (3, 5, 'SYSTEM', 0.4, '2025-05-08 10:45:00'),  -- Lipton Green
       (4, 4, 'SYSTEM', 0.5, '2025-05-10 14:20:00'),  -- Red Bull
       (5, 3, 'SYSTEM', 1.0, '2025-05-11 07:00:00');
-- Natural Spring

-- CUSTOM records
INSERT INTO records (user_id, drink_id, area, amount, date)
VALUES (1, 1, 'CUSTOM', 0.2, '2025-05-10 18:10:00'), -- Chamomile Relax
       (2, 2, 'CUSTOM', 0.3, '2025-05-09 15:45:00'), -- Vanilla Cold Brew
       (3, 3, 'CUSTOM', 0.25, '2025-05-08 20:05:00'),-- Homemade Green
       (4, 4, 'CUSTOM', 0.5, '2025-05-10 22:30:00'), -- Ultra Sunrise
       (5, 5, 'CUSTOM', 0.75, '2025-05-11 09:00:00');-- Double Espresso

INSERT INTO reports (user_id, date, expected_daily_amount, actual_daily_amount)
VALUES
    -- John Doe (expected: 12.5)
    (1, '2025-05-10', 12.5, 0.5 + 0.25 + 0.2), -- Coke + Water + Chamomile
    -- Jane Smith (expected: 0)
    (2, '2025-05-09', 0, 0.3 + 0.3),           -- Orange Juice + Cold Brew
    -- Alex Unknown (expected: 8.75)
    (3, '2025-05-08', 8.75, 0.4 + 0.25),       -- Green Tea + Homemade Green
    -- Sam Williams (expected: 15.0)
    (4, '2025-05-10', 15.0, 0.5 + 0.5),        -- Red Bull + Monster
    -- Maria Gonzalez (expected: 20.25)
    (5, '2025-05-11', 20.25, 1.0 + 0.75); -- Water + Espresso
