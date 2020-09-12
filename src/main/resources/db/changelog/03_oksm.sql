--liquibase formatted sql

--changeset User1:3
create table h2020.oksm
(
  id_oksm           bigserial primary key,
  s_code            varchar(3),
  s_short_name      varchar(1000),
  s_full_name       varchar(4000),
  s_alfa2           varchar(2),
  s_alfa3           varchar(3)
);

-- add comments to the table
comment on table h2020.oksm
  is 'общероссийский классификатор стран мира';
-- add comments to the columns
comment on column h2020.oksm.id_oksm
  is 'id'; --автоинкрементное поле
comment on column h2020.oksm.s_code
  is 'Код';
comment on column h2020.oksm.s_short_name
  is 'краткое наименование';
comment on column h2020.oksm.s_full_name
  is 'полное наименование';
comment on column h2020.oksm.s_alfa2
  is 'буквенный код альфа2';
comment on column h2020.oksm.s_alfa3
  is 'буквенный код альфа3';