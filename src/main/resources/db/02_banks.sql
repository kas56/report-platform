create table h2020.banks
(
  id_bank            bigserial primary key,
  dt_update          timestamp(6) default now(),
  s_user_modify      varchar(100),
  s_bik              varchar(9),
  s_swift            varchar(11),
  s_ksnp             varchar(32),
  s_namep            varchar(256),
  s_bank_full_name   varchar(4000),
  s_bank_short_name  varchar(4000),
  s_bank_jur_name    varchar(4000),
  i_uer              smallint,
  s_zip_code         varchar(10),
  i_tnp              integer,
  s_nnp              varchar(128),
  s_real             varchar(16),
  d_date_ch          date,
  s_regn             varchar(20),
  i_status           numeric(1),
  s_bank_inn         varchar(10),
  s_bank_kpp         varchar(9),
  s_bank_address     varchar(4000),
  s_bank_jur_address varchar(4000),
  s_bank_name_eng    varchar(4000),
  s_bank_ben_name    varchar(4000),
  s_bank_ben_addr    varchar(4000),
  is_branch          boolean default false,
  is_not_rus         boolean default false,
  s_contact_pers     varchar(1000),
  s_tel_contact_pers varchar(20)

);

-- add comments to the table
comment on table h2020.banks
  is 'справочник банков';
-- add comments to the columns
comment on column h2020.banks.id_bank
  is 'id банка'; --автоинкрементное поле
comment on column h2020.banks.s_bik
  is 'банковский идентификационный код (БИК)';
comment on column h2020.banks.s_swift
  is 'код SWIFT';
comment on column h2020.banks.s_ksnp
  is 'номер счета (корреспондирующий счет)';
comment on column h2020.banks.s_namep
  is 'наименование участника расчетов';
comment on column h2020.banks.s_bank_full_name
  is 'полное наименование банка';
comment on column h2020.banks.s_bank_short_name
  is 'краткое наименование банка';
comment on column h2020.banks.s_bank_jur_name
  is 'юридическое наименование банка';
comment on column h2020.banks.i_uer
  is 'код типа участника (пользователя) системы электронных расчетов';
comment on column h2020.banks.s_zip_code
  is 'индекс';
comment on column h2020.banks.i_tnp
  is 'код типа населенного пункта';
comment on column h2020.banks.s_nnp
  is 'населенный пункт';
comment on column h2020.banks.s_real
  is 'код контроля допустимости проведения расчетных операций';
comment on column h2020.banks.d_date_ch
  is 'дата контроля';
comment on column h2020.banks.s_regn
  is 'код территории российской федерации';
comment on column h2020.banks.i_status
  is 'cтатус банка (0 - актуальные  записи, 1 – не актуальная запись, но имеет соответствующую актуальную с обновленными данными, 2 – запись неактуальна)';
comment on column h2020.banks.dt_update
  is 'дата последней модификации записи';
comment on column h2020.banks.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.banks.s_bank_inn
  is 'ИНН банка (ИНН юр.лица не более 10 цифр)';
comment on column h2020.banks.s_bank_kpp
  is 'КПП банка';
comment on column h2020.banks.s_bank_address
  is 'адрес банка';
comment on column h2020.banks.s_bank_jur_address
  is 'юридический адрес банка';
comment on column h2020.banks.s_bank_name_eng
  is 'наименование банка (на английском)';
comment on column h2020.banks.s_bank_ben_name
  is 'наименование банка бенефициара (для иностранных банков)';
comment on column h2020.banks.s_bank_ben_addr
  is 'адрес банка бенефециара (для иностранных банков)';
comment on column h2020.banks.is_branch
  is 'признак отделения';
comment on column h2020.banks.is_not_rus
  is 'признак банка иностранного государства';
comment on column h2020.banks.s_contact_pers
  is 'контактное лицо в банке';
comment on column h2020.banks.s_tel_contact_pers
  is 'телефон контактного лица в банке';
