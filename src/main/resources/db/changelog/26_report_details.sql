--liquibase formatted sql

--changeset User1:26

create table h2020.report_details
(
  id_report_details bigserial primary key,
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(256),
  id_report         bigint references h2020.reports (id_report),
  external_id       varchar(256),
  s_org_inn         varchar(256),
  s_org_kpp         varchar(256),
  s_org_name        varchar(4000),
  s_main            varchar(256),
  s_bank_bik        varchar(256),
  s_bank_name       varchar(4000),
  s_comment         text,
  s_val_code        varchar(256),
  f_balance_summ    numeric,
  s_type_dog        varchar(256),
  d_sign_dog        date,
  d_start_dog       date,
  d_end_dog         date,
  f_percent         numeric,
  s_val_code_dog    varchar(256),
  f_oper_sum        numeric
);

-- add comments to the table
comment on table h2020.report_details
  is 'остаток по счёту на дату';
-- add comments to the columns
comment on column h2020.report_details.id_report_details
  is 'id'; --автоинкрементное поле
comment on column h2020.report_details.dt_update
  is 'дата последней модификации записи';
comment on column h2020.report_details.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.report_details.id_report
  is 'ссылка на отчёт';
comment on column h2020.report_details.external_id
  is 'ID из внешней системы (откуда обновляется список организаций)';
comment on column h2020.report_details.s_org_inn
  is 'ИНН оганизации';
comment on column h2020.report_details.s_org_kpp
  is 'КПП организации';
comment on column h2020.report_details.s_org_name
  is 'наименование организации';
comment on column h2020.report_details.s_main
  is 'признак ГО/ФЛ';
comment on column h2020.report_details.s_bank_bik
  is 'БИК банка';
comment on column h2020.report_details.s_bank_name
  is 'наименование банка';
comment on column h2020.report_details.s_comment
  is 'комментарий';
comment on column h2020.report_details.s_val_code
  is 'валюта счетов в банке';
comment on column h2020.report_details.f_balance_summ
  is 'остаток по счетам в банке';
comment on column h2020.report_details.s_type_dog
  is 'вид договора';
comment on column h2020.report_details.d_sign_dog
  is 'дата подписания договора';
comment on column h2020.report_details.d_start_dog
  is 'дата начал действия договора';
comment on column h2020.report_details.d_end_dog
  is 'дата окончания действия договора';
comment on column h2020.report_details.f_percent
  is 'расчётная ставка годовых';
comment on column h2020.report_details.s_val_code_dog
  is 'валюта договора (такая же как валюта счетов в банке)';
comment on column h2020.report_details.f_oper_sum
  is 'сумма по договору';