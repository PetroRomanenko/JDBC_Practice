create  table  IF NOT EXISTS label
(
    id_label    serial
        primary key,
    label varchar(255) not null
);
GO