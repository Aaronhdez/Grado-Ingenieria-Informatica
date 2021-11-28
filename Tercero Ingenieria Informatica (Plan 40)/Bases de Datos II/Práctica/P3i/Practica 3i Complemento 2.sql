alter session set time_zone='Europe/London';

select sessiontimezone from dual;

select systimestamp, current_timestamp from dual;

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

insert into cambio_eur_a
values ('USD', null, 5, 71, systimestamp);

select *
from cambio_eur_a;

select divisa, cambio, numerador, denominador, to_char (alta,'dd/mm/yyyy hh24:mi:ss.ff tzr') as alta
from cambio_eur_a;

select *
from cambio_eur_a
where systimestamp - alta < interval '1' hour;

alter session set time_zone='America/New_York';

select sessiontimezone from dual;

select systimestamp, current_timestamp from dual;

select *
from cambio_eur_a;

select divisa, cambio, numerador, denominador, to_char (alta,'dd/mm/yyyy hh24:mi:ss.ff tzr') as alta
from cambio_eur_a;

select *
from cambio_eur_a
where systimestamp - alta < interval '24:30' minute to second;

select *
from cambio_eur_a
where current_timestamp - alta < interval '24:30' minute to second;
