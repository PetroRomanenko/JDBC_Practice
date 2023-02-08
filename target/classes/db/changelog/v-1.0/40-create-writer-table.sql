create table  IF NOT EXISTS writer
(
    writer_id serial  not null
        primary key,
    firstname varchar(255)                                       not null,
    lastname  varchar(255)                                       not null
);