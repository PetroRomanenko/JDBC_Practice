create table  IF NOT EXISTS post_writer
(
    post_id   integer not null
        constraint fk_post
            references post
            on update cascade on delete cascade,
    writer_id integer not null
        constraint fk_writer
            references writer
            on update cascade on delete cascade
);