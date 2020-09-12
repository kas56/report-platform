create view h2020.v_last_days_for_reports as
    select max(bacc.d_date_balance) over (partition by extract('year' from bacc.d_date_balance), extract('month' from bacc.d_date_balance)) as last_day_month,
           max(bacc.d_date_balance) over (partition by extract('year' from bacc.d_date_balance), extract('quarter' from bacc.d_date_balance)) as last_day_quarter,
           max(bacc.d_date_balance) over (partition by extract('year' from bacc.d_date_balance)) as last_day_year,
           extract('year' from bacc.d_date_balance) as year,
           extract('month' from bacc.d_date_balance) as month,
           extract('quarter' from bacc.d_date_balance) as quarter
      from h2020.balance_account bacc;

comment on view h2020.v_last_days_for_reports
  is 'последние дни занесения данных баланса по счетам для построения месячного, квартального и годового отчёта';
comment on column h2020.v_last_days_for_reports.last_day_month
  is 'последний день для месячного отчёта';
comment on column h2020.v_last_days_for_reports.last_day_quarter
  is 'последний день для квартального отчёта';
comment on column h2020.v_last_days_for_reports.last_day_year
  is 'последний день для годового отчёта';
comment on column h2020.v_last_days_for_reports.month
  is 'месяц отчёта';
comment on column h2020.v_last_days_for_reports.quarter
  is 'квартал отчёта';
comment on column h2020.v_last_days_for_reports.year
  is 'год отчёта';
