create table h2020.accounts
(
  id_accounts  bigserial primary key,
  dt_update         timestamp(6) default now() not null,
  s_user_modify     varchar(100) not null,
  s_number          varchar(30) not null constraint account_number check (length(regexp_replace(s_number, '^[[:digit:]]*$', '')) = 0),
  id_okv            bigint references h2020.okv (id_okv) not null,
  id_type_accounts  bigint references h2020.type_accounts (id_type_accounts) not null,
  f_balance_summ    numeric not null default 0,
  id_bank           bigint references h2020.banks (id_bank) not null,
  id_org            bigint references h2020.organizations (id_org) not null,
  s_comment         text
);

-- add comments to the table
comment on table h2020.accounts
  is 'счета';
-- add comments to the columns
comment on column h2020.accounts.id_accounts
  is 'id'; --автоинкрементное поле
comment on column h2020.accounts.dt_update
  is 'дата последней модификации записи';
comment on column h2020.accounts.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.accounts.s_number
  is 'номер счёта';
comment on column h2020.accounts.id_okv
  is 'ссылка на ОКВ';
comment on column h2020.accounts.id_type_accounts
  is 'ссылка на вид счёта';
comment on column h2020.accounts.f_balance_summ
  is 'баланс счёта (пересчитывается при изменении)';
comment on column h2020.accounts.id_bank
  is 'ссылка на банк';
comment on column h2020.accounts.id_org
  is 'ссылка на организацию';
comment on column h2020.accounts.s_comment
  is 'комментарий';