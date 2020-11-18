create table customer (
    id serial,
    name varchar(255),
    description varchar(255),
    phone varchar(255),
    email varchar(255)
);

create table auth (
     id serial,
     customer_id bigint,
     login varchar(255),
     password varchar(255)
);
