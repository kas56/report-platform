--удаление констрейнтов
--banks
alter table h2020.banks drop constraint bank_bik;
alter table h2020.banks drop constraint bank_swift;
alter table h2020.banks drop constraint bank_ksnp;
alter table h2020.banks drop constraint bank_inn;
alter table h2020.banks drop constraint bank_kpp;
alter table h2020.banks alter column s_user_modify drop not null;
alter table h2020.banks alter column s_namep drop not null;
--organisations
alter table h2020.organizations drop constraint org_inn;
alter table h2020.organizations drop constraint org_kpp;
alter table h2020.organizations drop constraint org_ogrn;
alter table h2020.organizations drop constraint org_email;
alter table h2020.organizations drop constraint org_okato;
alter table h2020.organizations drop constraint org_oktmo;
alter table h2020.organizations drop constraint org_okpo;
alter table h2020.organizations alter column s_user_modify drop not null;
alter table h2020.organizations alter column s_full_name drop not null;
alter table h2020.organizations alter column s_jur_address drop not null;
alter table h2020.organizations alter column s_org_type drop not null;
alter table h2020.organizations alter column is_inside_org drop not null;
alter table h2020.organizations alter column is_admin_org drop not null;
--accounts
alter table h2020.accounts drop constraint account_number;
alter table h2020.accounts alter column s_user_modify drop not null;
alter table h2020.accounts alter column f_balance_summ drop not null;
alter table h2020.accounts alter column s_number drop not null;
--curs_val_cb
alter table h2020.curs_val_cb alter column s_user_modify drop not null;
alter table h2020.curs_val_cb alter column id_okv drop not null;
alter table h2020.curs_val_cb alter column nominal drop not null;
alter table h2020.curs_val_cb alter column value drop not null;
alter table h2020.curs_val_cb alter column dt_date_curs drop not null;
--users
alter table h2020.users alter column s_user_modify drop not null;
alter table h2020.users alter column id_org drop not null;
alter table h2020.users alter column s_firstname drop not null;
alter table h2020.users alter column s_secondname drop not null;