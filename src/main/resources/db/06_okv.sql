create table h2020.okv
(
  id_okv            bigserial primary key,
  charcode          varchar(3),
  numcode           varchar(3),
  s_name_currency   varchar(255),
  s_name_country    varchar(512),
  constraint okv_codes unique (charcode, numcode)
);

-- add comments to the table
comment on table h2020.okv
  is 'общероссийский классификатор валют';
-- add comments to the columns
comment on column h2020.okv.id_okv
  is 'id'; --автоинкрементное поле
comment on column h2020.okv.charcode
  is 'символьный код валюты';
comment on column h2020.okv.numcode
  is 'цифровой код валюты';
comment on column h2020.okv.s_name_currency
  is 'наименование валюты';
comment on column h2020.okv.s_name_country
  is 'страна валюты';