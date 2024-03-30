--liquibase formatted sql

--changeset anikolotov:1
--comment: init db changeset

create table users
(
    id uuid primary key,
    name varchar not null,
    email varchar unique not null
);

create table orders
(
    id uuid primary key,
    name varchar not null,
    description varchar not null,
    status varchar not null,
    user_id uuid references users(id)
);
