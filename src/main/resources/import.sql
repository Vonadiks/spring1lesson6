DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Product_1', 100), ('Product_2', 200), ('Product_3', 300);

DROP TABLE buyers IF EXISTS;
CREATE TABLE IF NOT EXISTS buyers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO buyers (name) VALUES ('Buyer_1'), ('Buyer_2'), ('Buyer_3');

DROP TABLE buyers_products IF EXISTS;
CREATE TABLE IF NOT EXISTS buyers_products (buyer_id bigint, product_id bigint, FOREIGN KEY (buyer_id) REFERENCES buyers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO buyers_products (buyer_id, product_id) VALUES (1, 2), (1, 1), (3, 2), (2, 2);


