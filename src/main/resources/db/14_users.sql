create table h2020.users
(
  id_users          bigserial primary key,
  dt_update         timestamp(6) default now() not null,
  s_user_modify     varchar(100) not null,
  id_org            bigint references h2020.organizations (id_org) not null,
  s_firstname       varchar(255) not null,
  s_secondname      varchar(255) not null,
  s_middlename      varchar(255),
  s_position        varchar(1000)
);

-- add comments to the table
comment on table h2020.users
  is 'курс валют ЦБ';
-- add comments to the columns
comment on column h2020.users.id_users
  is 'id'; --автоинкрементное поле
comment on column h2020.users.dt_update
  is 'дата последней модификации записи';
comment on column h2020.users.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.users.id_org
  is 'ссылка на организацию';
comment on column h2020.users.s_firstname
  is 'имя';
comment on column h2020.users.s_secondname
  is 'фамилия';
comment on column h2020.users.s_middlename
  is 'отчество (при наличии)';
comment on column h2020.users.s_position
  is 'должность';