--liquibase formatted sql

--changeset User1:27

alter table h2020.report_details add column id_bank  bigint references h2020.banks (id_bank);
comment on column h2020.report_details.id_bank
  is 'Ссылка на банки';

--changeset User1:45_2

alter table h2020.report_details add column id_org  bigint references h2020.organizations (id_org);
comment on column h2020.report_details.id_org
  is 'Ссылка на организацию';

--changeset User1:45_3
alter table h2020.report_details add column id_type_dog  bigint references h2020.type_dog (id_type_dog);
comment on column h2020.report_details.id_type_dog
  is 'Ссылка на тип договора';
