--liquibase formatted sql

--changeset User1:37

--Создадим представления сохранённых отчётов для XML
--Организации
create view h2020.v_save_reports_orgs_xml as
    select distinct
           rd.id_report,
           rd.external_id,
           rd.s_org_inn,
           rd.s_org_kpp,
           rd.s_org_name,
           rd.s_main
      from h2020.report_details rd;
--Комментируем созданное
comment on view h2020.v_save_reports_orgs_xml
  is 'Сохранённые отчёты организации для XML';
--Банки
create view h2020.v_save_reports_banks_xml as
    select distinct
           rd.id_report,
           rd.external_id,
           rd.s_bank_bik,
           rd.s_bank_name
      from h2020.report_details rd;
--Комментируем созданное
comment on view h2020.v_save_reports_banks_xml
  is 'Сохранённые отчёты банки для XML';
--Валюты и суммы
create view h2020.v_save_reports_valbal_xml as
    select distinct
           rd.id_report,
           rd.external_id,
           rd.s_bank_bik,
           rd.s_bank_name,
           rd.s_val_code,
           rd.f_balance_summ
      from h2020.report_details rd;
--Комментируем созданное
comment on view h2020.v_save_reports_valbal_xml
  is 'Сохранённые отчёты валюта и баланс для XML';
--Договоры (фин. операции)
create view h2020.v_save_reports_dogs_xml as
    select distinct
           rd.id_report,
           rd.external_id,
           rd.s_bank_bik,
           rd.s_bank_name,
           rd.s_val_code,
           rd.s_type_dog,
           rd.d_sign_dog,
           rd.d_start_dog,
           rd.d_end_dog,
           rd.f_percent,
           rd.s_val_code_dog,
           rd.f_oper_sum
      from h2020.report_details rd;
--Комментируем созданное
comment on view h2020.v_save_reports_dogs_xml
  is 'Сохранённые отчёты договоры(фин. операции) для XML';