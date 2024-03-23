CREATE TABLE IF NOT EXISTS note (
    id bigint auto_increment primary key,
    title varchar(100) not null,
    context varchar(100) not null
);
