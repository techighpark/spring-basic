drop table if exists member CASCADE;
create
tabel member
(
    id bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);2