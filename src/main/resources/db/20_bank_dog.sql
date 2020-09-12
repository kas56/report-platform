create table h2020.bank_dog
(
  id_bank_dog       bigserial primary key,
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(256),
  s_num_dog         varchar(256),
  id_type_dog       bigint references h2020.type_dog (id_type_dog),
  d_sign_dog        date,
  d_start_dog       date,
  d_end_dog         date,
  d_term_dog        date
);

-- add comments to the table
comment on table h2020.bank_dog
  is 'типы банковского договора';
-- add comments to the columns
comment on column h2020.bank_dog.id_bank_dog
  is 'id'; --автоинкрементное поле
comment on column h2020.bank_dog.dt_update
  is 'дата последней модификации записи';
comment on column h2020.bank_dog.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.bank_dog.id_type_dog
  is 'ссылка на тип договора';
comment on column h2020.bank_dog.s_num_dog
  is 'номер договора';
comment on column h2020.bank_dog.d_sign_dog
  is 'дата заключения';
comment on column h2020.bank_dog.d_start_dog
  is 'дата начала';
comment on column h2020.bank_dog.d_end_dog
  is 'дата окончания';
comment on column h2020.bank_dog.d_term_dog
  is 'дата расторжения';