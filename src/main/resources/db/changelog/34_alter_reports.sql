--liquibase formatted sql

--changeset User1:34


--Добавляю поля для определения периодичности отчёта
alter table h2020.reports add column type_report char(1) default 'D';
alter table h2020.reports add column year_report integer;
alter table h2020.reports add column quarter_report integer;
alter table h2020.reports add column month_report integer;
--Добавляю комментарии к создаваемым столбцам
comment on column h2020.reports.type_report
  is 'тип отчёта: D-ежедневный, M-ежемесячный, Q-квартальный, Y-годовой';
comment on column h2020.reports.year_report
  is 'год отчёта, заполняется для MQY типов';
comment on column h2020.reports.quarter_report
  is 'квартал отчёта, заполняется для Q типа';
comment on column h2020.reports.month_report
  is 'месяц отчёта, заполняется для M типа';