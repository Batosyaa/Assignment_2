-- Create the "rooms" table
CREATE TABLE Rooms_ (
    room_number INT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    is_booked BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE Guest (
    Name VARCHAR(50),
    Number_of_guests INT);

INSERT INTO Guest (Name, Number_of_guests) VALUES
('Batyr', 1),
('Olesya', 2),
('John', 3),
('Dave', 2),
('Bart', 1),
('Allison', 3),
('Jack', 1);

INSERT INTO "Rooms_" (room_number, type, price, is_booked) VALUES
(101, 'Single', 500.65, FALSE),
(102, 'Single', 510.00, FALSE),
(103, 'Single', 520.00, FALSE),
(201, 'Double', 800.00, FALSE),
(202, 'Double', 810.00, FALSE),
(203, 'Double', 820.00, FALSE),
(301, 'King size', 1010.00, FALSE),
(302, 'King size', 1100.00, FALSE),
(303, 'King size', 1500.00, FALSE);


SELECT * from Rooms_;

SELECT * FROM information_schema.tables WHERE table_name = 'rooms_';

SELECT * FROM information_schema.tables WHERE table_name = 'rooms_';

SELECT * FROM rooms_;

CREATE TABLE "Rooms_" (
    room_number INT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    is_booked BOOLEAN NOT NULL DEFAULT FALSE);

SELECT * FROM "Rooms_";




