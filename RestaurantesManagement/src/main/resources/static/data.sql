-- Inserting customers
INSERT INTO customer (name, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO customer (name, email) VALUES ('Jane Smith', 'jane.smith@example.com');

-- Inserting restaurant tables
INSERT INTO restaurant_table (capacity, is_occupied, location_description) VALUES (4, false, 'Near window');
INSERT INTO restaurant_table (capacity, is_occupied, location_description) VALUES (2, false, 'Patio');

-- Inserting reservations
INSERT INTO reservation (customer_id, table_id, reservation_time, number_of_guests, special_requests)
VALUES (1, 1, '2023-12-01 19:00:00', 2, 'None');
INSERT INTO reservation (customer_id, table_id, reservation_time, number_of_guests, special_requests)
VALUES (2, 2, '2023-12-01 20:00:00', 2, 'Allergic to nuts');

-- Add more data as needed
