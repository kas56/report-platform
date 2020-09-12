

alter table h2020.users
    add column salt varchar(255) not null;

INSERT INTO h2020.users (id_users, dt_update, s_user_modify, id_org, s_firstname, s_secondname, s_middlename, s_position, s_email, salt, s_password, s_roles)
    VALUES (1, '2020-09-12 13:01:35.457974', null, null, 'admin', 'admin', 'admin', null, 'admin@mail.ru','$2a$10$cbYn4a3aJfp40edsh86/hO', '$2a$10$cbYn4a3aJfp40edsh86/hO5QQls0KT5gZdf0oT/oC.iXL9uNm6pfq', 'ADMIN');

INSERT INTO h2020.users (id_users, dt_update, s_user_modify, id_org, s_firstname, s_secondname, s_middlename, s_position, s_email, salt, s_password, s_roles)
VALUES (2, '2020-09-12 13:01:35.457974', null, null, 'user', 'user', 'user', null, 'user@mail.ru','$2a$10$cbYn4a3aJfp40edsh86/hO', '$2a$10$cbYn4a3aJfp40edsh86/hO5QQls0KT5gZdf0oT/oC.iXL9uNm6pfq', 'USER');

commit;

