DROP TABLE IF EXISTS BRANDS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS PRICES;
-- BRANDS
CREATE TABLE IF NOT EXISTS BRANDS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
INSERT INTO BRANDS (name) VALUES ('ZARA'), values('OTHER_BRAND');

-- PRODUCTS
CREATE TABLE IF NOT EXISTS PRODUCTS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    brand_id BIGINT,
    FOREIGN KEY (brand_id) REFERENCES BRANDS(id)
);
INSERT INTO PRODUCTS (name, creation_date, status, brand_id)
values ('Producto 1', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'ZARA')),
 ( 'Producto 2', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'ZARA') ),
 ( 'Producto 3', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'ZARA') ),
 ( 'Producto 4', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'ZARA') ),
 ( 'Producto 5', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'ZARA') ),
 ( 'Producto 6', CURRENT_TIMESTAMP, 'Activo', (SELECT id FROM BRANDS WHERE name = 'OTHER_BRAND'));

-- PRICES
CREATE TABLE IF NOT EXISTS PRICES (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    priority BIGINT NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    curr VARCHAR(3) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
);
INSERT INTO PRICES (product_id, start_date, end_date, priority, price, curr)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.50, 'EUR'),
       (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 25.45, 'EUR'),
       (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 30.50, 'EUR'),
       (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 'EUR'),
       -- Precios para el Producto 2
       (2, '2020-06-14 00:00:00', '2020-06-14 18:00:00', 0, 40.00, 'EUR'),
       (2, '2020-06-14 12:00:00', '2020-12-31 23:59:59', 1, 30.00, 'EUR'),
       -- Precios para el Producto 3
       (3, '2020-06-14 00:00:00', '2020-06-14 16:00:00', 0, 50.00, 'EUR'),
       (3, '2020-06-14 10:00:00', '2020-12-31 23:59:59', 1, 45.00, 'EUR'),
       -- Precios para el Producto 4
       (4, '2020-06-15 00:00:00', '2020-06-15 12:00:00', 0, 55.00, 'EUR'),
       (4, '2020-06-15 08:00:00', '2020-12-31 23:59:59', 1, 50.00, 'EUR'),
       -- Precios para el Producto 5
       (5, '2020-06-16 00:00:00', '2020-06-16 18:00:00', 0, 60.00, 'EUR'),
       (5, '2020-06-16 14:00:00', '2020-12-31 23:59:59', 1, 55.00, 'EUR');
