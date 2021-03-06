--liquibase formatted sql

--changeset User1:27

--Добавляю поле номера по порядку для всегда одинакового вывода в архивных отчётах
alter table h2020.report_details add column i_npp integer;
comment on column h2020.report_details.i_npp
  is 'номер строки по порядку (для одинакового показа архивных отчётов требуется сортировка по данному полю)';
--Создаю представление с данными для форммирования ежедневного отчёта
create view h2020.v_data_day_report as
select bacc.d_date_balance,
       row_number() over () as npp,
       org.external_id,
       org.s_org_inn,
       org.s_org_kpp,
       coalesce(org.s_full_name, org.s_short_name) as s_org_name,
       case when org.main_id_org is null then 'ГО' else 'ФЛ' end as s_main,
       b.s_bik as s_bank_bik,
       b.s_namep as s_bank_name,
       '' as s_comment,
       okv.charcode as s_val_code,
       sum(bacc.f_balance_summ) as f_balance_summ,
       tdog.s_name_type as s_type_dog,
       bdog.d_sign_dog,
       bdog.d_start_dog,
       bdog.d_end_dog,
       bdog.f_percent,
       okv.charcode as s_val_code_dog,
       sum(bdog.f_oper_summ) as f_oper_summ
from h2020.organizations org
join h2020.accounts acc
  on acc.id_org = org.id_org
join h2020.banks b
  on b.id_bank = acc.id_bank
--Заведение баланса и финоперации (договора) по счету в день должно быть в паре, потому жёстко связываем
join h2020.balance_account bacc
  on bacc.id_account = acc.id_accounts
join h2020.okv okv
  on okv.id_okv = acc.id_okv
join h2020.bank_dog bdog
  on bdog.id_account = acc.id_accounts
 and bdog.id_okv = acc.id_okv
 and date_trunc('day', bdog.dt_update) = bacc.d_date_balance
join h2020.type_dog tdog
  on tdog.id_type_dog = bdog.id_type_dog
group by bacc.d_date_balance,
         org.external_id,
         org.s_org_inn,
         org.s_org_kpp,
         coalesce(org.s_full_name, org.s_short_name),
         case when org.main_id_org is null then 'ГО' else 'ФЛ' end,
         b.s_bik,
         b.s_namep,
         okv.charcode,
         tdog.s_name_type,
         bdog.d_sign_dog,
         bdog.d_start_dog,
         bdog.d_end_dog,
         bdog.f_percent;

comment on view h2020.v_data_day_report
  is 'данные для ежедневного отчёта';
comment on column h2020.v_data_day_report.d_date_balance
  is 'дата баланса счетов (по ней получаются и операции)';
comment on column h2020.v_data_day_report.npp
  is 'номер строки по порядку';
comment on column h2020.v_data_day_report.external_id
  is 'ID организации из внешней системы';
comment on column h2020.v_data_day_report.s_org_inn
  is 'ИНН организации';
comment on column h2020.v_data_day_report.s_org_kpp
  is 'КПП организации';
comment on column h2020.v_data_day_report.s_org_name
  is 'наименование организации';
comment on column h2020.v_data_day_report.s_main
  is 'признак ГО/ФЛ организации';
comment on column h2020.v_data_day_report.s_bank_bik
  is 'БИК банка';
comment on column h2020.v_data_day_report.s_bank_name
  is 'наименование банка';
comment on column h2020.v_data_day_report.s_comment
  is 'комментарий';
comment on column h2020.v_data_day_report.s_val_code
  is 'валюта счетов в банке';
comment on column h2020.v_data_day_report.f_balance_summ
  is 'баланс счетов в банке';
comment on column h2020.v_data_day_report.s_type_dog
  is 'тип договора';
comment on column h2020.v_data_day_report.d_sign_dog
  is 'дата подписания договора';
comment on column h2020.v_data_day_report.d_start_dog
  is 'дата начала действия договора';
comment on column h2020.v_data_day_report.d_end_dog
  is 'дата окончания действия договора';
comment on column h2020.v_data_day_report.f_percent
  is 'процентная ставка по договору';
comment on column h2020.v_data_day_report.s_val_code_dog
  is 'валюта операции';
comment on column h2020.v_data_day_report.f_oper_summ
  is 'сумма операции';