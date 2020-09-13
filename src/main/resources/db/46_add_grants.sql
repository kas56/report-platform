DO $$
declare
t_cur cursor is
    select u.*
      from h2020.users u;
    o_cur cursor is
    select o.*
      from h2020.organizations o;
    l_cnt integer = 0;
    l_cnt_org integer;
begin
    --Посчитаем организации
    select count(1)
      into l_cnt_org
      from h2020.organizations;
    for cur in t_cur loop
        l_cnt = 0;
        for cur1 in o_cur loop
            --Вставим права пользователя на свою организацию
            if l_cnt = 0 then
            insert into h2020.grant_org_user (id_user, id_org)
                       values (cur.id_users, cur.id_org);
            end if;
            l_cnt = l_cnt + 1;
            if cur1.id_org != cur.id_org then
                insert into h2020.grant_org_user (id_user, id_org)
                       values (cur.id_users, cur1.id_org);
                if (l_cnt_org - 1) <= l_cnt then
                    exit;
                end if;
            end if;
         end loop;
    end loop ;
--Блок обработки ошибок опускаем, так как данный скрипт тестовый
end;
$$ LANGUAGE plpgsql;