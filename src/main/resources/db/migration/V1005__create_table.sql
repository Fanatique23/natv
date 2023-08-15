CREATE TABLE channels (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    created_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE prices (
    id SERIAL PRIMARY KEY,
    id_channels BIGINT REFERENCES channels(id),
    price_per_symbol DOUBLE PRECISION,
    start_date DATE,
    end_date DATE
);

CREATE TABLE discounts (
    id SERIAL PRIMARY KEY,
    id_channel BIGINT NOT NULL,
    discount DOUBLE PRECISION NOT NULL,
    count_days INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);
