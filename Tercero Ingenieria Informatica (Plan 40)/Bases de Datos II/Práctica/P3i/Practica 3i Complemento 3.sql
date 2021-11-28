alter session set time_zone='Europe/London';

alter system set undo_retention = 10000 scope=memory;

drop table cambio_eur_a purge;

create table cambio_eur_a (divisa varchar2 (3) constraint pk_cambio_eur_a primary key,
                           cambio number (10,4),
                           numerador number(38), denominador number(38),
                           alta timestamp (3) with local time zone constraint nn_alta not null,
                           constraint cambio_no_redundante check
                             ( not ( (cambio is not null and numerador is not null) or (cambio is not null and denominador is not null) ) ),
                           constraint existe_cambio check
                             ( cambio is not null or (numerador is not null and denominador is not null) )
                          )
                          tablespace is2;

create or replace
procedure inicializa_cambio_eur_a as
begin
   insert into cambio_eur_a values ('USD', 1.3569, null, null, systimestamp);
   insert into cambio_eur_a values ('GBP', 0.8466, null, null, systimestamp);
   insert into cambio_eur_a values ('JPY', 132.0150, null, null, systimestamp);
   insert into cambio_eur_a values ('CHF', 1.2299, null, null, systimestamp);
   insert into cambio_eur_a values ('ARS', 7.8815, null, null, systimestamp);
   insert into cambio_eur_a values ('AUD', 1.4368, null, null, systimestamp);
   insert into cambio_eur_a values ('BRL', 2.9995, null, null, systimestamp);
   insert into cambio_eur_a values ('CAD', 1.3962, null, null, systimestamp);
   insert into cambio_eur_a values ('CNY', 8.2972, null, null, systimestamp);
   insert into cambio_eur_a values ('CZK', 25.5730, null, null, systimestamp);
   insert into cambio_eur_a values ('DKK', 7.4601, null, null, systimestamp);
   insert into cambio_eur_a values ('HKD', 10.5219, null, null, systimestamp);
   insert into cambio_eur_a values ('HUF', 296.9700, null, null, systimestamp);
   insert into cambio_eur_a values ('MXN', 17.7444, null, null, systimestamp);
   insert into cambio_eur_a values ('NOK', 8.0900, null, null, systimestamp);
   insert into cambio_eur_a values ('NZD', 1.6305, null, null, systimestamp);
   insert into cambio_eur_a values ('PLN', 4.1997, null, null, systimestamp);
   insert into cambio_eur_a values ('SEK', 8.7095, null, null, systimestamp);
   insert into cambio_eur_a values ('SGD', 1.6924, null, null, systimestamp);
   insert into cambio_eur_a values ('ZAR', 13.5641, null, null, systimestamp);
   commit;
end;
/

create or replace procedure retardo (intervalo_sg in number) as
   tiempo_inicio timestamp;
begin
  tiempo_inicio := systimestamp;
  loop
     exit when systimestamp > tiempo_inicio + (intervalo_sg / 86400);
  end loop;
end;
/

create or replace procedure actualiza_cambio_eur_a (veces in number, intervalo_sg in number) as
begin  
  dbms_random.seed ('cualquier valor');
  for i in 1..veces loop
     retardo (intervalo_sg);
     update cambio_eur_a
     set cambio = cambio + dbms_random.value (-0.005*cambio, 0.005*cambio),
           alta = systimestamp;
     commit;
  end loop;
end;
/
