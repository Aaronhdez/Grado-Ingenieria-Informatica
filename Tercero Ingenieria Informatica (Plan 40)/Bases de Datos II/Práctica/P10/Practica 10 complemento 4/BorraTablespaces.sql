whenever sqlerror exit 1
drop table alumno.b purge;
drop tablespace prueba including contents and datafiles;
drop tablespace prueba_temp including contents and datafiles;
exit
