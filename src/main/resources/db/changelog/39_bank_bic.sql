--liquibase formatted sql

--changeset User1:39

create table h2020.bank_bic
(
  id_bank_bic       bigserial primary key,
  shortname         varchar(1000),
  bic               varchar(256),
  regnum            varchar(256)
);

-- add comments to the table
comment on table h2020.bank_bic
  is 'остаток по счёту на дату';
-- add comments to the columns
comment on column h2020.bank_bic.id_bank_bic
  is 'id'; --автоинкрементное поле
comment on column h2020.bank_bic.shortname
  is 'краткое наименование банка';
comment on column h2020.bank_bic.bic
  is 'БИК банка';
comment on column h2020.bank_bic.regnum
  is 'регистрационный номер БИК';