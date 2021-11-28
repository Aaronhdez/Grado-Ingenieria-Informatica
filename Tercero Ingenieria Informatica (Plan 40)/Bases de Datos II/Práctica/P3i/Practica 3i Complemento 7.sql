variable inicio varchar2 (30)

delete from cambio_eur_a;
commit;

begin
   retardo (10);
   :inicio := to_char (systimestamp, 'dd-mm-yyyy hh24:mi:ss.ff3');
   retardo (10);
   inicializa_cambio_eur_a ();
   actualiza_cambio_eur_a (5,5);
   retardo (10);
end;
/

truncate table historico_cambio_eur_a;

drop table historico_cambio_eur_a purge;

create global temporary table historico_cambio_eur_a (scn_inicio number,
                                                                               divisa varchar2 (3),
                                                                               cambio number (8,4),
                                                                               numerador number(38), denominador number(38),
                                                                               alta timestamp (3) with local time zone)
                                                                          on commit preserve rows;

insert into historico_cambio_eur_a
(select versions_startscn, divisa, cambio, numerador, denominador, alta
 from cambio_eur_a
 versions between timestamp to_timestamp (:inicio, 'dd-mm-yyyy hh24:mi:ss.ff3') and systimestamp);

commit;

select * from historico_cambio_eur_a order by to_char (alta, 'yyyymmddhh24miss'), divisa;

truncate table historico_cambios;

drop table historico_cambios purge;

create table historico_cambios (divisa_desde varchar2 (3),
                                              divisa_a varchar2 (3),
                                              cambio number (8,4),
                                              numerador number(38), denominador number(38),
                                              alta timestamp (3) with local time zone)
                                          tablespace is2;


insert into historico_cambios
(select x.divisa, y.divisa, y.cambio/x.cambio, y.numerador*x.denominador, x.numerador*y.denominador, x.alta
 from historico_cambio_eur_a x, historico_cambio_eur_a y
 where x.scn_inicio = y.scn_inicio
 and x.divisa <> y.divisa);

insert into historico_cambios
(select 'EUR', divisa, cambio, numerador, denominador, alta
 from historico_cambio_eur_a);

insert into historico_cambios
(select divisa, 'EUR', 1/cambio, denominador, numerador, alta
 from historico_cambio_eur_a);

commit;

select * from historico_cambios order by to_char (alta, 'yyyymmddhh24miss'), divisa_desde, divisa_a;
