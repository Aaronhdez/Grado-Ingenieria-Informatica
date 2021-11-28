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

select * from cambio_eur_a;

select *
from cambio_eur_a
as of timestamp systimestamp - interval '18' second;
