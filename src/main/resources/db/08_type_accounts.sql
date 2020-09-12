create table h2020.type_accounts
(
  id_type_accounts  bigserial primary key,
  s_code            varchar(20),
  s_name            varchar(255)
);

-- add comments to the table
comment on table h2020.type_accounts
  is 'виды счетов';
-- add comments to the columns
comment on column h2020.type_accounts.id_type_accounts
  is 'id'; --автоинкрементное поле
comment on column h2020.type_accounts.s_code
  is 'код вида счёта';
comment on column h2020.type_accounts.s_name
  is 'наименование вида счёта';