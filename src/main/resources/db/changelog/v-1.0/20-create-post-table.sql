create table  IF NOT EXISTS post
(
    id          serial
        primary key,
    content     varchar(255) not null,
    created     date         not null,
    updated     date,
    post_status varchar(255) not null
);