--liquibase formatted sql

--changeset User1:17

--добавлени столбцов для шапки отчёта
alter table h2020.users add column s_user_email varchar(256);
alter table h2020.users add column s_user_phone varchar(256);
--комментарии к столбцам
comment on column h2020.users.s_user_email
  is 'e-mail';
comment on column h2020.users.s_user_phone
  is 'телефон';