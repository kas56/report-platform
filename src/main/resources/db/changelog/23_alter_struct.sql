--liquibase formatted sql

--changeset User1:23

--Добавляю ссылку на счёт из банковского договора (он же фин. сделка)
alter table h2020.bank_dog add column id_account bigint references h2020.accounts (id_accounts);
comment on column h2020.bank_dog.id_account
  is 'ссылка на счёт';
comment on table h2020.bank_dog
  is 'банковский договор (фин. сделка)';