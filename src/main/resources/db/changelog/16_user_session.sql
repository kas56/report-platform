
create table h2020.user_session (
    id bigserial NOT NULL primary key,
    session_key varchar(110) DEFAULT NULL,
    user_id bigint NOT NULL references h2020.users(id_users),
    create_time timestamp NOT NULL
);