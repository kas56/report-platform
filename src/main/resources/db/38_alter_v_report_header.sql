--Создаю представление с данными для форммирования ежедневного отчёта
create or replace view h2020.v_report_header as
select r.id_report,
       coalesce(u.s_secondname, '-') || ' ' || coalesce(u.s_firstname, '-') || ' ' ||
       coalesce(u.s_middlename, '') || ', E\n' ||
       coalesce(u.s_user_email, '') || ', ' || coalesce(u.s_user_phone, '') as responsible_pers,
       'Информация о финансовой деятельности организации по состоянию на ' ||
       extract('day' from r.dt_date_report) ||
       case extract('month' from r.dt_date_report)
         when 1 then 'января '
         when 2 then 'февраля '
         when 3 then 'марта '
         when 4 then 'апреля '
         when 5 then 'мая '
         when 6 then 'июня '
         when 7 then 'июля '
         when 8 then 'августа '
         when 9 then 'сентября '
         when 10 then 'октября '
         when 11 then 'ноября '
         when 12 then 'декабря '
       end  || extract('year' from r.dt_date_report) || 'года.' as s_date_report,
       string_agg(rd.s_org_name, '; ') over (partition by rd.id_report order by rd.s_org_name) as list_org,
       string_agg(rd.s_org_inn, '; ') over (partition by rd.id_report order by rd.s_org_name) as list_inn,
       u.s_secondname,
       u.s_firstname,
       u.s_middlename,
       u.s_user_email,
       u.s_user_phone
from h2020.reports r
join h2020.report_details rd
  on rd.id_report = r.id_report
join h2020.users u
  on u.id_users = r.id_user;

comment on view h2020.v_report_header
  is 'данные шапки отчёта';
comment on column h2020.v_report_header.id_report
  is 'id отчёта, для которого формируется шапка)';
comment on column h2020.v_report_header.responsible_pers
  is 'данные ответственного за формирование отчёта';
comment on column h2020.v_report_header.s_date_report
  is 'дата фрмирования отчёта';
comment on column h2020.v_report_header.list_org
  is 'список организаций';
comment on column h2020.v_report_header.list_inn
  is 'список ИНН';
comment on column h2020.v_report_header.s_secondname
  is 'фамилия';
comment on column h2020.v_report_header.s_firstname
  is 'имя';
comment on column h2020.v_report_header.s_middlename
  is 'отчество';
comment on column h2020.v_report_header.s_user_email
  is 'e-mail';
comment on column h2020.v_report_header.s_user_phone
  is 'телефон';
