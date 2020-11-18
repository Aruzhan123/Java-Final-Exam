create table status (
    id serial,
    status_name varchar (255)
);
insert into status(status_name)
values ('processed'),
       ('order is accepted'),
       ('on my way'),
       ('order delivered');

