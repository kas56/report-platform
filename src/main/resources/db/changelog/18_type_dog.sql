--liquibase formatted sql

--changeset User1:18

create table h2020.type_dog
(
  id_type_dog       bigserial primary key,
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(256),
  s_code_type       varchar(256),
  s_name_type       varchar(256)
);

-- add comments to the table
comment on table h2020.type_dog
  is 'типы банковского договора';
-- add comments to the columns
comment on column h2020.type_dog.id_type_dog
  is 'id'; --автоинкрементное поле
comment on column h2020.type_dog.dt_update
  is 'дата последней модификации записи';
comment on column h2020.type_dog.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.type_dog.s_code_type
  is 'код типа';
comment on column h2020.type_dog.s_code_type
  is 'наименование типа';