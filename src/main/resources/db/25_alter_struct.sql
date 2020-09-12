--Добавляю внешний идентификатор в организации
alter table h2020.organizations add column external_id varchar(256);
comment on column h2020.organizations.external_id
  is 'идентификатор из внешней системы';
--Добавляю комментарий к внесению остатка
alter table h2020.balance_account add column s_comment varchar(512);
comment on column h2020.balance_account.s_comment
  is 'комментарий к внесению баланса';