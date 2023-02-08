create table  IF NOT EXISTS label_post
(
    post_id  integer not null
        constraint fk_post
            references post
            on delete cascade,
    label_id integer not null
        constraint fk_label
            references label
            on update cascade on delete cascade
);

GO