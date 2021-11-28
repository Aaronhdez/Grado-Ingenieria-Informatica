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

select versions_startscn, versions_starttime, 
          versions_endscn, versions_endtime,
          versions_operation,
          divisa, cambio, numerador, denominador, alta  
from cambio_eur_a 
versions between timestamp to_timestamp (:inicio, 'dd-mm-yyyy hh24:mi:ss.ff3') and systimestamp
where divisa='USD';

select versions_startscn, versions_starttime, 
          versions_endscn, versions_endtime,
          versions_operation,
          divisa, cambio, numerador, denominador, alta  
from cambio_eur_a 
versions between timestamp to_timestamp (:inicio, 'dd-mm-yyyy hh24:mi:ss.ff3') and systimestamp;

