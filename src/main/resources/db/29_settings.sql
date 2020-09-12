create table h2020.settings
(
  id_settings       bigserial primary key,
  key               varchar(256),
  value             varchar(4000)
);

-- add comments to the table
comment on table h2020.settings
  is 'остаток по счёту на дату';
-- add comments to the columns
comment on column h2020.settings.id_settings
  is 'id'; --автоинкрементное поле
comment on column h2020.settings.key
  is 'дата последней модификации записи';
comment on column h2020.settings.value
  is 'пользователь, последний изменивший запись';