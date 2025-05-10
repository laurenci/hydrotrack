-- Users Table
CREATE TABLE users
(
    id       INT PRIMARY KEY,
    username VARCHAR(32) NOT NULL,
    daily_amount DOUBLE NOT NULL DEFAULT 0
);

-- Profile Table
CREATE TABLE profile
(
    user_id       INT PRIMARY KEY,
    first_name    VARCHAR(32),
    last_name     VARCHAR(32),
    sex           ENUM('MALE', 'FEMALE', 'UNCERTAIN', 'OTHER') NOT NULL DEFAULT 'UNCERTAIN',
    birthday_date DATE,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Drinks Table
CREATE TABLE drinks
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    type  VARCHAR(48) NOT NULL,
    brand VARCHAR(48),
    name  VARCHAR(48) NOT NULL
);

-- Custom Drinks Table
CREATE TABLE custom_drinks
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT         NOT NULL,
    type    VARCHAR(48) NOT NULL,
    brand   VARCHAR(48),
    name    VARCHAR(48) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Drink Types Table
CREATE TABLE drink_types
(
    type    VARCHAR(48) PRIMARY KEY,
    `group` ENUM('BASIC', 'TEA', 'COFFEE', 'ENERGY_DRINK') NOT NULL
);

-- Add foreign keys for drink types
ALTER TABLE drinks
    ADD FOREIGN KEY (type) REFERENCES drink_types (type);

ALTER TABLE custom_drinks
    ADD FOREIGN KEY (type) REFERENCES drink_types (type);

-- Records Table
CREATE TABLE records
(
    user_id  INT       NOT NULL,
    drink_id INT       NOT NULL,
    date     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    area     ENUM('SYSTEM', 'CUSTOM') NOT NULL,
    amount   DOUBLE NOT NULL,
    PRIMARY KEY (user_id, drink_id, date),
    FOREIGN KEY (user_id) REFERENCES users (id)
    -- Conditional FK handled via trigger
);

DELIMITER //

CREATE TRIGGER validate_record_insert
    BEFORE INSERT
    ON records
    FOR EACH ROW
BEGIN
    IF NEW.area = 'SYSTEM' THEN
        IF NOT EXISTS (
            SELECT 1 FROM drinks WHERE id = NEW.drink_id
        ) THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Invalid drink_id for system area';
END IF;
ELSEIF
NEW.area = 'CUSTOM' THEN
        IF NOT EXISTS (
            SELECT 1 FROM custom_drinks WHERE id = NEW.drink_id AND user_id = NEW.user_id
        ) THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Invalid drink_id for custom area or not owned by user';
END IF;
ELSE
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Invalid area value';
END IF;
END
//

DELIMITER ;

-- Reports Table
CREATE TABLE reports
(
    user_id INT  NOT NULL,
    date    DATE NOT NULL DEFAULT CURRENT_DATE,
    expected_daily_amount DOUBLE NOT NULL DEFAULT 0,
    actual_daily_amount   DOUBLE NOT NULL DEFAULT 0,
    PRIMARY KEY (user_id, date),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Achievements Table
CREATE TABLE achievements
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(48)  NOT NULL,
    description VARCHAR(256) NOT NULL,
    className   VARCHAR(64)  NOT NULL,
    status      ENUM('ENABLED', 'DISABLED') NOT NULL
);

-- Users_Achievements Table
CREATE TABLE users_achievements
(
    user_id        INT NOT NULL,
    achievement_id INT NOT NULL,
    progress       JSON,
    date           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status         ENUM('NOT_STARTED', 'IN_PROGRESS', 'OBTAINED') NOT NULL,
    PRIMARY KEY (user_id, achievement_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (achievement_id) REFERENCES achievements (id)
);
