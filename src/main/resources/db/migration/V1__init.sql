create table customer_table
(
    id   bigserial not null
        constraint customer_table_pkey
            primary key,
    name varchar(255)
);

alter table customer_table
    owner to postgres;


create table product_table
(
    id    bigserial not null
        constraint product_table_pkey
            primary key,
    title text      not null,
    cost  bigint    not null
);

alter table product_table
    owner to postgres;

create table products_customers
(
    product_id  bigint
        constraint products_customers_product_id_fkey
            references product_table,
    customer_id bigint
        constraint products_customers_customer_id_fkey
            references customer_table
);

alter table products_customers
    owner to postgres;
