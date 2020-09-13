DO $$
declare
t_cur cursor is
    select *
      from h2020.accounts zcc;
    l_d_sign_dog date = to_date('15.04.2020', 'DD.MM.YYYY');
    l_id_type_dog bigint;
    l_num_dog numeric = 10000;

begin

    select td.id_type_dog
    into l_id_type_dog
    from h2020.type_dog td
    where td.s_code_type = 'DEBT';
    for cur in t_cur loop
      insert into h2020.balance_account (id_account, d_date_balance, f_balance_summ)
             values (cur.id_accounts, current_date, 10000);

      insert into h2020.bank_dog (s_num_dog, id_type_dog, d_sign_dog, d_start_dog, d_end_dog, f_percent, id_okv, f_oper_summ, id_account)
             values (cast(l_num_dog as varchar), l_id_type_dog, l_d_sign_dog, l_d_sign_dog, l_d_sign_dog + interval '8 month', 5.5, cur.id_okv, 5000, cur.id_accounts);
      l_num_dog = l_num_dog + 53;
    end loop ;
--Блок обработки ошибок опускаем, так как данный скрипт тестовый
end;
$$ LANGUAGE plpgsql;