/*R16: No podemos. Particionado independiente del �ndice, no prefijado.*/
drop table b purge;

create table b(
  a int constraint clave_primaria_de_b primary key,
  b char,
  c int,
  fecha date
  ) partition by range(fecha)(
      partition restoa�os values less than (to_date('01/1/2018','mm/dd/yyyy')) tablespace prueba_temp,
      partition a�o2018 values less than (to_date('01/1/2019','mm/dd/yyyy')) tablespace prueba,
      partition a�o2019 values less than (to_date('01/1/2020','mm/dd/yyyy')) tablespace prueba,
      partition a�oencurso values less than (maxvalue) tablespace prueba_temp
  );

call inserta_en_b(400000);
commit;
alter table alumno.b modify constraint clave_primaria_de_b disable;
create index primaria on b(a) global
partition by hash(a)(
  partition p1 tablespace prueba_temp,
  partition p2 tablespace prueba,
  partition p3 tablespace prueba,
  partition p4 tablespace prueba_temp);

alter table alumno.b modify constraint clave_primaria_de_b enable;

