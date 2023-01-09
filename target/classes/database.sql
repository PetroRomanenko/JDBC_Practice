--Create Table
create table label(
id serial primary key,
n_ame varchar(255)
);

insert into label (n_ame)
values ('Book');

insert into label (n_ame)
values ('Hello');

select *  from label;

select * from label WHERE id=2;

