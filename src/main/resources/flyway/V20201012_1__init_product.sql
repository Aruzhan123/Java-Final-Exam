 create table category (
                         id serial,
                         name varchar(255),
                         description varchar(255)
);

create table product (
                         id serial,
                         name varchar(255),
                         description varchar(255),
                         price float8,
                         category_id bigint
);
