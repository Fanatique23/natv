INSERT INTO channels (name, image_url, created_date, end_date) VALUES
    ('MTV', 'mtv.jpeg', '2023-05-01', '2023-05-02'),
    ('TNT', 'tnt.jpg', '2023-05-01', '2023-05-02'),
    ('CTC', 'ctc.jpeg', '2023-05-01', '2023-05-06');

INSERT INTO prices (id_channels, price_per_symbol, start_date, end_date) VALUES
    (1, 32, '2023-05-01', '2023-05-02'),
    (2, 10, '2023-05-01', '2023-05-02'),
    (3, 15, '2023-05-01', '2023-05-02');