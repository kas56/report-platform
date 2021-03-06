create table h2020.organizations
(
  id_org            bigserial primary key,
  main_id_org       bigint references h2020.organizations(id_org),
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(100),
  s_short_name      varchar(4000),
  s_full_name       varchar(4000),
  s_org_inn         varchar(10),
  s_org_kpp         varchar(9),
  s_org_ogrn        varchar(13),
  s_jur_address     varchar(4000),
  s_post_address    varchar(4000),
  s_contact_fio     varchar(1000),
  s_phone           varchar(20),
  s_fax             varchar(20),
  s_email           varchar(256),
  s_org_type        varchar(1000)
  d_registration    date,
  id_oksm           bigint references h2020.oksm(id_oksm),
  s_okato           varchar(11),
  s_oktmo           varchar(11),
  s_okpo            varchar(10),
  is_inside_org     boolean default true,
  is_admin_org      boolean default false
);



-- add comments to the table
comment on table h2020.organizations
  is 'справочник организаций';
-- add comments to the columns
comment on column h2020.organizations.id_org
  is 'id организации'; --автоинкрементное поле
comment on column h2020.organizations.main_id_org
  is 'ссылка на головную организацию';
comment on column h2020.organizations.dt_update
  is 'дата последней модификации записи';
comment on column h2020.organizations.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.organizations.s_short_name
  is 'краткое наименование организации';
comment on column h2020.organizations.s_full_name
  is 'полное наименование организации';
comment on column h2020.organizations.s_org_inn
  is 'ИНН организации';
comment on column h2020.organizations.s_org_kpp
  is 'КПП организации';
comment on column h2020.organizations.s_org_ogrn
  is 'ОГРН организации';
comment on column h2020.organizations.s_jur_address
  is 'юридический адрес организации';
comment on column h2020.organizations.s_post_address
  is 'почтовый адрес организации';
comment on column h2020.organizations.s_contact_fio
  is 'контактное лицо';
comment on column h2020.organizations.s_phone
  is 'телефон организации';
comment on column h2020.organizations.s_fax
  is 'факс организации';
comment on column h2020.organizations.s_email
  is 'e-mail организации';
comment on column h2020.organizations.s_org_type
  is 'организационно правовая форма организации';
comment on column h2020.organizations.d_registration
  is 'дата рпостановки на учет в налоговом органе';
comment on column h2020.organizations.id_oksm
  is 'ссылка на общероссийский классификатор стран мира';
comment on column h2020.organizations.s_okato
  is 'ОКАТО организации';
comment on column h2020.organizations.s_oktmo
  is 'ОКТМО организации';
comment on column h2020.organizations.s_okpo
  is 'ОКПО организации';
comment on column h2020.organizations.is_inside_org
  is 'признак своей организации';
comment on column h2020.organizations.is_admin_org
  is 'признак управляющей организации (сотрудник этой организации может изменять справочники)';