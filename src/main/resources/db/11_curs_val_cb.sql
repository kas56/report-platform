create table h2020.curs_val_cb
(
  id_curs_val_cb    bigserial primary key,
  dt_update         timestamp(6) default now() not null,
  s_user_modify     varchar(100) not null,
  id_okv            bigint references h2020.okv (id_okv) not null,
  nominal           numeric default 1 not null,
  value             numeric default 1 not null,
  dt_date_curs      timestamp default now() not null
);

-- add comments to the table
comment on table h2020.curs_val_cb
  is 'курс валют ЦБ';
-- add comments to the columns
comment on column h2020.curs_val_cb.id_curs_val_cb
  is 'id'; --автоинкрементное поле
comment on column h2020.curs_val_cb.dt_update
  is 'дата последней модификации записи';
comment on column h2020.curs_val_cb.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.curs_val_cb.id_okv
  is 'ссылка на ОКВ';
comment on column h2020.curs_val_cb.nominal
  is 'номинал (единиц валюты)';
comment on column h2020.curs_val_cb.value
  is 'курс';
comment on column h2020.curs_val_cb.dt_date_curs
  is 'дата курса';