insert into customer(name, description, phone, email)
values ('aru1', 'aaa', '+77074302531', 'aru1.gmail.com'),
       ('aru2', 'qqq', '+77074302532', 'ary2.gmail.com'),
       ('aru3', 'www', '+77074302533', 'ary3.gmail.com'),
       ('aru4', 'bbb', '+77074302534', 'ary4.gmail.com'),
       ('aru5', 'ccc', '+77074302535', 'ars5.gmail.com');






insert into auth(customer_id,login, password)
values (1,'aru1','123'),
       (2,'aru2','123'),
       (3,'aru3','123'),
       (4,'aru4','123'),
       (5,'aru5','123');


insert into category(name,description)
values ('cake', 'Cake is a form of sweet food'),
       ('eclair', 'An éclair is an oblong pastry'),
       ('pancake', 'A pancake is a flat cake'),
       ('waffle', 'A waffle is a dish'),
       ('croissant', 'A croissant is a buttery, flaky, viennoiserie'),
       ('pie', 'A pie is a baked dish'),
       ('doughnut', 'A doughnut or donut is a type of fried dough confection or dessert food.'),
       ('cookie', 'A cookie is a baked or cooked food that is typically small, flat and sweet.'),
       ('biscuits', 'A biscuit is a flour-based baked food product.'),
       ('tart', 'A tart is a baked dish consisting of a filling over a pastry base with an open top not covered with pastry.');

insert into product(name, description, price,	category_id)
values ('milk girl', 'type of cake', 2000,1),
       ('eclair with banana', 'type of eclair', 2342,2),
       ('pancake with apple', 'type of pancake', 848,3),
       ('waffle', 'type of waffle',1000 ,4),
       ('croissant with jam', 'type of croissant',345, 5),
       ('apple pie', 'type of pie', 324,6),
       ('doughnut with jam', 'type of doughnut', 235,7),
       ('chocolate cookies', 'type of cookie', 245,8),
       ('orange biscuits ', 'type of biscuits', 2423,9),
       ('tart with chocolate', 'type of tart', 345,10);