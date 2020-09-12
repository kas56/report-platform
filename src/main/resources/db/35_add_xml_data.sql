alter table h2020.reports add column xml_data text;
comment on column h2020.reports.xml_data
  is 'Отправленное xml сообщение';