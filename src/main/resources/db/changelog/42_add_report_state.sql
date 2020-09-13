--liquibase formatted sql

--changeset User1:41
alter table h2020.reports add column s_status varchar(256);
comment on column h2020.reports.s_status
  is 'состояние отчёта';