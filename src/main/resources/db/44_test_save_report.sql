DO $$
declare
t_cur cursor is
    select ddr.*
      from h2020.v_data_day_report ddr;
    l_d_sign_dog date = to_date('15.04.2020', 'DD.MM.YYYY');
    l_id_org bigint;
    l_id_user bigint;
    l_id_report bigint;
    l_cnt integer = 0;
begin
    select o.id_org
      into l_id_org
      from h2020.organizations o
      limit 1;
    insert into h2020.users (id_org, s_firstname, s_secondname, s_middlename, s_position, s_user_email, s_user_phone)
           values(l_id_org, 'Иванов', 'Иван', 'Иванович', 'Ответственный сотрудник', 'ivanovii@rosatom.ru', '+7(495)555-55-55')
    returning id_users into l_id_user;
    for cur in t_cur loop
        l_cnt = l_cnt + 1;
        if l_cnt = 1 then
            insert into h2020.reports (dt_date_report, id_user, s_status)
                   values (cur.d_date_balance, l_id_user, 'Черновик')
            returning id_report into l_id_report;
        end if;
        insert into h2020.report_details (id_report, external_id, s_org_inn, s_org_kpp, s_org_name, s_main, s_bank_bik, s_bank_name, s_val_code, f_balance_summ, s_type_dog, d_sign_dog, d_start_dog, d_end_dog, f_percent, s_val_code_dog, f_oper_sum, i_npp)
               values (l_id_report, cur.external_id, cur.s_org_inn, cur.s_org_kpp, cur.s_org_name, cur.s_main, cur.s_bank_bik, cur.s_bank_name, cur.s_val_code, cur.f_balance_summ, cur.s_type_dog, cur.d_sign_dog, cur.d_start_dog, cur.d_end_dog, cur.f_percent, cur.s_val_code_dog, cur.f_oper_summ, cur.npp);
    end loop ;
--Блок обработки ошибок опускаем, так как данный скрипт тестовый
end;
$$ LANGUAGE plpgsql;