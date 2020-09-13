DO $$
declare
t_cur cursor is
    select *
      from h2020.organizations org;
    l_id_okv bigint;
    l_id_bank bigint;
    l_id_type_accounts bigint;
    l_acc_num numeric = 20008405674365437893;
begin
    for cur in t_cur loop
      l_acc_num = l_acc_num + 1024;
      --Ищем валюту в справочнике ОКВ
      select o.id_okv
        into l_id_okv -- strict не используем, а потому no_data_found не генерируется
        from h2020.okv o
       where  o.charcode = 'RUB';
      select b.id_bank
        into l_id_bank
        from h2020.banks b
       where b.s_regn = '1000';
      select ta.id_type_accounts
        into l_id_type_accounts
        from h2020.type_accounts ta
       where ta.s_code = 'DEP';

      insert into h2020.accounts (s_number, id_okv, id_type_accounts, id_bank, id_org, s_comment)
             values (cast(l_acc_num as varchar), l_id_okv, l_id_type_accounts, l_id_bank, cur.id_org, 'Тестовый счёт');
    end loop ;
--Блок обработки ошибок опускаем, так как данный скрипт тестовый
end;
$$ LANGUAGE plpgsql;