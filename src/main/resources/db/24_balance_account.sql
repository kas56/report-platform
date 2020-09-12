create table h2020.balance_account
(
  id_balance_account bigserial primary key,
  dt_update          timestamp(6) default now(),
  s_user_modify      varchar(256),
  id_account         bigint references h2020.accounts (id_accounts),
  d_date_balance     date,
  f_balance_summ     numeric default 0

);

-- add comments to the table
comment on table h2020.balance_account
  is 'остаток по счёту на дату';
-- add comments to the columns
comment on column h2020.balance_account.id_balance_account
  is 'id'; --автоинкрементное поле
comment on column h2020.balance_account.dt_update
  is 'дата последней модификации записи';
comment on column h2020.balance_account.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.balance_account.id_account
  is 'ссылка на счёт';
comment on column h2020.balance_account.d_date_balance
  is 'дата баланса (дата предоставления информации)';
comment on column h2020.balance_account.f_balance_summ
  is 'баланс счёта';