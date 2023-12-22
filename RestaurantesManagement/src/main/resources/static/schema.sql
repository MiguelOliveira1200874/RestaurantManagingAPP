CREATE TABLE IF NOT EXISTS customer (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255),
    email VARCHAR(255),
    -- Add other fields as required
    );

CREATE TABLE IF NOT EXISTS restaurant_table (
                                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                capacity INT,
                                                is_occupied BOOLEAN,
                                                location_description TEXT
    -- Add other fields as required
);

CREATE TABLE IF NOT EXISTS reservation (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           customer_id BIGINT,
                                           table_id BIGINT,
                                           reservation_time TIMESTAMP,
                                           number_of_guests INT,
                                           special_requests TEXT,
                                           FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (table_id) REFERENCES restaurant_table(id)
    -- Add other fields as required
    );

-- Add more tables as per your entities
