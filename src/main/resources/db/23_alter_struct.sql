--Добавляю ссылку на счёт из банковского договора (он же фин. сделка)
alter table h2020.bank_dog add column id_account bigint references h2020.accounts (id_accounts);
comment on column h2020.bank_dog.id_account
  is 'ссылка на счёт';
comment on table h2020.bank_dog
  is 'банковский договор (фин. сделка)';
--Удаляю ссылку на договор из счетов
alter table h2020.accounts drop column id_bank_dog;
--удаляю баланс из счёта
alter table h2020.accounts drop column f_balance_summ;