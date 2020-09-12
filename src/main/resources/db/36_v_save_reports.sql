--Создадим представление сохранённых отчётов
create view h2020.v_save_reports as
    select r.id_report,
           r.dt_date_report,
           r.id_user,
           '' as s_comment,
           rd.i_npp,
           rd.external_id,
           rd.s_org_inn,
           rd.s_org_kpp,
           rd.s_org_name,
           rd.s_main,
           rd.s_bank_bik,
           rd.s_bank_name,
           rd.s_val_code,
           rd.f_balance_summ,
           rd.s_type_dog,
           rd.d_sign_dog,
           rd.d_start_dog,
           rd.d_end_dog,
           rd.f_percent,
           rd.s_val_code_dog,
           rd.f_oper_sum
      from h2020.reports r
      join h2020.report_details rd
        on rd.id_report = r.id_report;
--Комментируем созданное
comment on view h2020.v_save_reports
  is 'Сохранённые отчёты';
comment on column h2020.v_save_reports.id_report
  is 'id отчёта';
comment on column h2020.v_save_reports.s_org_inn
  is 'ИНН организации';
comment on column h2020.v_save_reports.i_npp
  is 'номер строки по порядку';
comment on column h2020.v_save_reports.external_id
  is 'внешний ID';
comment on column h2020.v_save_reports.s_org_kpp
  is 'КПП организации';
comment on column h2020.v_save_reports.s_org_name
  is 'наименование организации';
comment on column h2020.v_save_reports.s_main
  is 'признак головной организации ГО/ФЛ';
comment on column h2020.v_save_reports.s_bank_bik
  is 'БИК банка';
comment on column h2020.v_save_reports.s_bank_name
  is 'наименование банка';
comment on column h2020.v_save_reports.s_val_code
  is 'валюта счетов в банке';
comment on column h2020.v_save_reports.f_balance_summ
  is 'баланс счетов';
comment on column h2020.v_save_reports.s_type_dog
  is 'тип договора';
comment on column h2020.v_save_reports.d_sign_dog
  is 'дата подписания договора';
comment on column h2020.v_save_reports.d_start_dog
  is 'дата начала действия договора';
comment on column h2020.v_save_reports.d_end_dog
  is 'дата окончания действия договора';
comment on column h2020.v_save_reports.f_percent
  is 'процентнаЯ ставка по договору';
comment on column h2020.v_save_reports.f_oper_sum
  is 'сумма фин.операции';