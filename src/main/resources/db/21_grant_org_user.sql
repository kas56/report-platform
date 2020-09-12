create table h2020.grant_org_user
(
  id_grant_org_user bigserial primary key,
  dt_update         timestamp(6) default now(),
  s_user_modify     varchar(256),
  id_user           bigint references h2020.users (id_users),
  id_org            bigint references h2020.organizations (id_org)
);

-- add comments to the table
comment on table h2020.grant_org_user
  is 'доступ пользователя к организациям';
-- add comments to the columns
comment on column h2020.grant_org_user.id_grant_org_user
  is 'id'; --автоинкрементное поле
comment on column h2020.grant_org_user.dt_update
  is 'дата последней модификации записи';
comment on column h2020.grant_org_user.s_user_modify
  is 'пользователь, последний изменивший запись';
comment on column h2020.grant_org_user.id_user
  is 'ссылка на пользователя';
comment on column h2020.grant_org_user.id_user
  is 'ссылка на организацию';

create view h2020.v_grant_org_user as
    select u.id_users,
           u.s_firstname,
           u.s_secondname,
           u.s_middlename,
           u.s_position,
           ou.id_org as id_user_org,
           ou.main_id_org as main_id_user_org,
           coalesce(ou.s_short_name, ou.s_full_name) as user_org,
           o.id_org as id_grant_org,
           o.main_id_org as main_id_grant_org,
           coalesce(o.s_short_name, o.s_full_name) as grant_org_name
      from h2020.users u
      join h2020.organizations ou
        on ou.id_org = u.id_org
      join h2020.grant_org_user gou
        on gou.id_user = u.id_users
      join h2020.organizations o
        on o.id_org = gou.id_org;

comment on view h2020.v_grant_org_user
  is 'Список организаций, доступных пользователю';
comment on column h2020.v_grant_org_user.id_users
  is 'id пользователя';
comment on column h2020.v_grant_org_user.s_firstname
  is 'имя пользователя';
comment on column h2020.v_grant_org_user.s_secondname
  is 'фамилия пользователя';
comment on column h2020.v_grant_org_user.s_middlename
  is 'отчество пользователя';
comment on column h2020.v_grant_org_user.s_position
  is 'должность пользователя';
comment on column h2020.v_grant_org_user.id_user_org
  is 'id организации пользователя';
comment on column h2020.v_grant_org_user.main_id_user_org
  is 'id головной организации организации пользователя';
comment on column h2020.v_grant_org_user.user_org
  is 'наименование организации пользователя';
comment on column h2020.v_grant_org_user.id_grant_org
  is 'id доступной организации';
comment on column h2020.v_grant_org_user.main_id_grant_org
  is 'id головной организации доступной организации';
comment on column h2020.v_grant_org_user.grant_org_name
  is 'наименование доступной организации';
--добавляю поле пароля в пользователи
alter table h2020.users add column user_password varchar(256);
comment on column h2020.users.user_password
  is 'пароль пользователя';