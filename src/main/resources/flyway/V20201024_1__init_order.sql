CREATE TABLE customer_order (
id serial primary key,
total_price bigint,
customer_id bigint,
status varchar(255)
);


create table order_item(
    id serial primary key,
    product_id bigint,
    quantity bigint,
    order_id bigint
);
