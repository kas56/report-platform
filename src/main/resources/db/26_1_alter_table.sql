alter table h2020.bank_dog add column id_okv bigint references h2020.okv (id_okv);
alter table h2020.bank_dog add column f_percent numeric;
comment on column h2020.bank_dog.f_percent
  is 'процентная ставка (+ для депозита, - для кредита)';
comment on column h2020.bank_dog.id_okv
  is 'ссылка на валюту договора (по идее должна совпадать с валютой счёта, но при необходимости можно и разные указать)';
--Добавляю ссылку на договор в счета
alter table h2020.accounts add column id_bank_dog bigint references h2020.bank_dog (id_bank_dog);