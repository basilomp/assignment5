CREATE TABLE customer_table
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO customer_table (name)
VALUES ('Jaymes'),
       ('Auldos');



CREATE TABLE products_customers
(
    product_id  BIGINT,
    customer_id BIGINT,
    FOREIGN KEY (product_id) REFERENCES product_table (id),
    FOREIGN KEY (customer_id) REFERENCES customer_table (id)
);


INSERT INTO products_customers (product_id, customer_id)
VALUES (8, 1),
       (10, 1),
       (12, 1),
       (9, 2),
       (11, 2),
       (11, 2);


-- Test

-- SELECT *
-- FROM products_customers
--          LEFT JOIN customer_table ct on ct.id = products_customers.customer_id
--          LEFT JOIN products_customers pc on ct.id = pc.customer_id;