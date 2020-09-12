--заполнение типов договоров
insert into h2020.type_dog(s_user_modify, s_code_type, s_name_type) values (user, 'DEBT', 'Депозит');
insert into h2020.type_dog(s_user_modify, s_code_type, s_name_type) values (user, 'CRED', 'Кредит');
insert into h2020.type_dog(s_user_modify, s_code_type, s_name_type) values (user, 'RKO', 'Расчётно-кассовое обслуживание');
commit;