CREATE DATABASE route_manager DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO airports(code, name) VALUES
    ('KRK', 'Krakow'),
    ('DUB', 'Dublin'),
    ('WRO', 'Wroclaw'),
    ('BCN', 'Barcelona'),
    ('MAD', 'Madrid');

INSERT INTO routes(departureCode, arrivalCode) VALUES
    ('KRK', 'DUB'),
    ('WRO', 'DUB'),
    ('DUB', 'BCN'),
    ('DUB', 'MAD');
