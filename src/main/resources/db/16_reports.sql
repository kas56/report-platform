create table h2020.reports
(
  id_report          bigserial primary key,
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(100),
  dt_date_report    timestamp,
  id_user           bigint references h2020.users (id_users),
  s_comment         varchar(1000)
);

-- add comments to the table
comment on table h2020.reports
  is 'сформированные отчёты (для просмотра ранее сформированных отчётов)';
-- add comments to the columns
comment on column h2020.reports.id_report
  is 'id'; --автоинкрементное поле
comment on column h2020.reports.dt_update
  is 'дата последней модификации записи';
comment on column h2020.reports.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.reports.dt_date_report
  is 'дата, на которую создан отчёт';
comment on column h2020.reports.id_user
  is 'ссылка на пользователя';
comment on column h2020.reports.s_comment
  is 'комментарий';