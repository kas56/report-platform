--=СЦЕПИТЬ("select lpad('";A1;"', 3, '0') as d_code, '";B1;"' as s_code, ";C1;" as nominal, '";D1;"' as name_val, cast(replace('";E1;"', ',', '.') as numeric) as curs union all")
DO $$
declare
t_cur cursor is
    select lpad('36', 3, '0')                           as d_code,
           'AUD'                                        as s_code,
           1                                            as nominal,
           'Австралийский доллар'                       as name_val,
           cast(replace('54,587', ',', '.') as numeric) as curs
    union all
    select lpad('944', 3, '0')                           as d_code,
           'AZN'                                         as s_code,
           1                                             as nominal,
           'Азербайджанский манат'                       as name_val,
           cast(replace('44,0786', ',', '.') as numeric) as curs
    union all
    select lpad('51', 3, '0')                            as d_code,
           'AMD'                                         as s_code,
           100                                           as nominal,
           'Армянских драмов'                            as name_val,
           cast(replace('15,3368', ',', '.') as numeric) as curs
    union all
    select lpad('933', 3, '0')                           as d_code,
           'BYN'                                         as s_code,
           1                                             as nominal,
           'Белорусский рубль'                           as name_val,
           cast(replace('28,8392', ',', '.') as numeric) as curs
    union all
    select lpad('975', 3, '0')                           as d_code,
           'BGN'                                         as s_code,
           1                                             as nominal,
           'Болгарский лев'                              as name_val,
           cast(replace('45,3382', ',', '.') as numeric) as curs
    union all
    select lpad('986', 3, '0')                           as d_code,
           'BRL'                                         as s_code,
           1                                             as nominal,
           'Бразильский реал'                            as name_val,
           cast(replace('14,0722', ',', '.') as numeric) as curs
    union all
    select lpad('348', 3, '0')                           as d_code,
           'HUF'                                         as s_code,
           100                                           as nominal,
           'Венгерских форинтов'                         as name_val,
           cast(replace('24,8188', ',', '.') as numeric) as curs
    union all
    select lpad('410', 3, '0')                           as d_code,
           'KRW'                                         as s_code,
           1000                                          as nominal,
           'Вон Республики Корея'                        as name_val,
           cast(replace('63,1101', ',', '.') as numeric) as curs
    union all
    select lpad('344', 3, '0')                           as d_code,
           'HKD'                                         as s_code,
           10                                            as nominal,
           'Гонконгских долларов'                        as name_val,
           cast(replace('96,6268', ',', '.') as numeric) as curs
    union all
    select lpad('208', 3, '0')                           as d_code,
           'DKK'                                         as s_code,
           1                                             as nominal,
           'Датская крона'                               as name_val,
           cast(replace('11,9185', ',', '.') as numeric) as curs
    union all
    select lpad('840', 3, '0')                           as d_code,
           'USD'                                         as s_code,
           1                                             as nominal,
           'Доллар США'                                  as name_val,
           cast(replace('74,8896', ',', '.') as numeric) as curs
    union all
    select lpad('978', 3, '0')                           as d_code,
           'EUR'                                         as s_code,
           1                                             as nominal,
           'Евро'                                        as name_val,
           cast(replace('88,6768', ',', '.') as numeric) as curs
    union all
    select lpad('356', 3, '0')                           as d_code,
           'INR'                                         as s_code,
           10                                            as nominal,
           'Индийских рупий'                             as name_val,
           cast(replace('10,1841', ',', '.') as numeric) as curs
    union all
    select lpad('398', 3, '0')                           as d_code,
           'KZT'                                         as s_code,
           100                                           as nominal,
           'Казахстанских тенге'                         as name_val,
           cast(replace('17,5287', ',', '.') as numeric) as curs
    union all
    select lpad('124', 3, '0')                           as d_code,
           'CAD'                                         as s_code,
           1                                             as nominal,
           'Канадский доллар'                            as name_val,
           cast(replace('56,8508', ',', '.') as numeric) as curs
    union all
    select lpad('417', 3, '0')                          as d_code,
           'KGS'                                        as s_code,
           100                                          as nominal,
           'Киргизских сомов'                           as name_val,
           cast(replace('94,797', ',', '.') as numeric) as curs
    union all
    select lpad('156', 3, '0')                           as d_code,
           'CNY'                                         as s_code,
           1                                             as nominal,
           'Китайский юань'                              as name_val,
           cast(replace('10,9544', ',', '.') as numeric) as curs
    union all
    select lpad('498', 3, '0')                           as d_code,
           'MDL'                                         as s_code,
           10                                            as nominal,
           'Молдавских леев'                             as name_val,
           cast(replace('44,9787', ',', '.') as numeric) as curs
    union all
    select lpad('934', 3, '0')                           as d_code,
           'TMT'                                         as s_code,
           1                                             as nominal,
           'Новый туркменский манат'                     as name_val,
           cast(replace('21,4276', ',', '.') as numeric) as curs
    union all
    select lpad('578', 3, '0')                           as d_code,
           'NOK'                                         as s_code,
           10                                            as nominal,
           'Норвежских крон'                             as name_val,
           cast(replace('83,0114', ',', '.') as numeric) as curs
    union all
    select lpad('985', 3, '0')                           as d_code,
           'PLN'                                         as s_code,
           1                                             as nominal,
           'Польский злотый'                             as name_val,
           cast(replace('19,9127', ',', '.') as numeric) as curs
    union all
    select lpad('946', 3, '0')                           as d_code,
           'RON'                                         as s_code,
           1                                             as nominal,
           'Румынский лей'                               as name_val,
           cast(replace('18,2591', ',', '.') as numeric) as curs
    union all
    select lpad('960', 3, '0')                            as d_code,
           'XDR'                                          as s_code,
           1                                              as nominal,
           'СДР (специальные права заимствования)'        as name_val,
           cast(replace('105,8355', ',', '.') as numeric) as curs
    union all
    select lpad('702', 3, '0')                           as d_code,
           'SGD'                                         as s_code,
           1                                             as nominal,
           'Сингапурский доллар'                         as name_val,
           cast(replace('54,7959', ',', '.') as numeric) as curs
    union all
    select lpad('972', 3, '0')                           as d_code,
           'TJS'                                         as s_code,
           10                                            as nominal,
           'Таджикских сомони'                           as name_val,
           cast(replace('72,5674', ',', '.') as numeric) as curs
    union all
    select lpad('949', 3, '0')                           as d_code,
           'TRY'                                         as s_code,
           1                                             as nominal,
           'Турецкая лира'                               as name_val,
           cast(replace('10,0275', ',', '.') as numeric) as curs
    union all
    select lpad('860', 3, '0')                           as d_code,
           'UZS'                                         as s_code,
           10000                                         as nominal,
           'Узбекских сумов'                             as name_val,
           cast(replace('72,9349', ',', '.') as numeric) as curs
    union all
    select lpad('980', 3, '0')                           as d_code,
           'UAH'                                         as s_code,
           10                                            as nominal,
           'Украинских гривен'                           as name_val,
           cast(replace('26,8181', ',', '.') as numeric) as curs
    union all
    select lpad('826', 3, '0')                           as d_code,
           'GBP'                                         as s_code,
           1                                             as nominal,
           'Фунт стерлингов Соединенного королевства'    as name_val,
           cast(replace('96,0534', ',', '.') as numeric) as curs
    union all
    select lpad('203', 3, '0')                           as d_code,
           'CZK'                                         as s_code,
           10                                            as nominal,
           'Чешских крон'                                as name_val,
           cast(replace('33,4202', ',', '.') as numeric) as curs
    union all
    select lpad('752', 3, '0')                           as d_code,
           'SEK'                                         as s_code,
           10                                            as nominal,
           'Шведских крон'                               as name_val,
           cast(replace('85,5002', ',', '.') as numeric) as curs
    union all
    select lpad('756', 3, '0')                           as d_code,
           'CHF'                                         as s_code,
           1                                             as nominal,
           'Швейцарский франк'                           as name_val,
           cast(replace('82,3506', ',', '.') as numeric) as curs
    union all
    select lpad('710', 3, '0')                           as d_code,
           'ZAR'                                         as s_code,
           10                                            as nominal,
           'Южноафриканских рэндов'                      as name_val,
           cast(replace('44,6907', ',', '.') as numeric) as curs
    union all
    select lpad('392', 3, '0')                           as d_code,
           'JPY'                                         as s_code,
           100                                           as nominal,
           'Японских иен'                                as name_val,
           cast(replace('70,5175', ',', '.') as numeric) as curs
;
    l_id_okv bigint;
begin
    for cur in t_cur loop
      --Ищем валюту в справочнике ОКВ
      select o.id_okv
        into l_id_okv -- strict не используем, а потому no_data_found не генерируется
        from h2020.okv o
       where o.numcode = cur.d_code
         and o.charcode = cur.s_code;
      if l_id_okv is null then
          --Если не нашли запись по коду, то вставим её, хотя в работе такой вариант недопустим
          insert into h2020.okv (charcode, numcode, s_name_currency)
                 values (cur.s_code, cur.d_code, cur.name_val);
      end if;
      -- dt_date_curs можно заполнить значением to_timestamp('12.09.2020 12:00:00.000000', 'DD.MM.YYYY HH24:MI:SS.US')
      -- это должно быть дата и время на которые запрашивается курс
      -- для теста ограничуть вставкой текущего момента времени localtimestamp
      insert into h2020.curs_val_cb (s_user_modify, id_okv, nominal, value, dt_date_curs)
                 values (user, l_id_okv, cur.nominal, cur.curs, localtimestamp);
    end loop ;
--Блок обработки ошибок опускаем, так как данный скрипт тестовый
end;
$$ LANGUAGE plpgsql;