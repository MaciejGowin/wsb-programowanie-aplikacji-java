DROP DATABASE IF EXISTS `booking_system`;
CREATE DATABASE `booking_system` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE booking_system;

CREATE TABLE customers
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth DATE
);

CREATE TABLE flights
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    departure_airport_code VARCHAR(3) NOT NULL,
    arrival_airport_code VARCHAR(3) NOT NULL,
    departure_date_time DATETIME NOT NULL,
    arrival_date_time DATETIME NOT NULL
);

CREATE TABLE bookings
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id INT UNSIGNED NOT NULL,
    flight_id INT UNSIGNED NOT NULL,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.0
);

CREATE TABLE airports
(
    code VARCHAR(3) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

INSERT INTO `customers` VALUES
    (1, 'Andrzej', 'Kowalski', '1987-11-14'),
    (2, 'Jan', 'Nowak', '1952-01-12'),
    (3, 'Karolina', 'Mróz', '1989-03-01'),
    (4, 'Maciej', 'Krab', '1976-07-08'),
    (5, 'Anna', 'Rembiszewska', '1991-12-01'),
    (6, 'Grażyna', 'Łokietek', '1966-05-09');

INSERT INTO `airports` VALUES
    ('DUB', 'Dublin', 2.2, 22.22),
    ('WRO', 'Wroclaw', 1.1, 11.11);

INSERT INTO `flights` VALUES
    (1, 'WRO', 'DUB', '2021-01-01 15:00:00', '2021-01-01 18:00:00'),
    (2, 'WRO', 'GDN', '2021-01-01 10:00:00', '2021-01-01 11:30:00'),
    (3, 'GDN', 'WRO', '2021-01-02 21:00:00', '2021-01-02 23:30:00');

INSERT INTO `bookings` VALUES
        (1, 1, 1, 6.60),
        (2, 1, 2, 17.00),
        (3, 2, 1, 18.90),
        (4, 3, 1, 24.70),
        (5, 3, 2, 30.20),
        (6, 1, 1, 12.30);
