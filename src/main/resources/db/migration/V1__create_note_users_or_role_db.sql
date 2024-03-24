CREATE TABLE IF NOT EXISTS users (
    id bigint auto_increment primary key,
    login varchar(100) unique not null,
    password varchar(64) not null
);
CREATE TABLE IF NOT EXISTS notes (
    id bigint auto_increment primary key,
    user_id bigint,
    title varchar(100) not null,
    context varchar(100) not null,
    foreign key (user_id) references users(id)
);
CREATE TABLE role (
    id bigint auto_increment primary key,
    name enum ('ROLE_USER', 'ROLE_ADMIN') not null
);
