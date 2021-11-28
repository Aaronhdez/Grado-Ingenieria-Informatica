/*R11: No podemos aplicar debido a la partición de la tabla.*/
drop table b purge;
drop sequence a_seq;
drop sequence b_seq;
drop sequence c_seq;

create table b(
  a int constraint clave_primaria_de_b primary key,
  b char,
  c int,
  fecha date
) partition by range(fecha)(
  partition restoaños values less than (to_date('01/1/2011','mm/dd/yyyy')) tablespace prueba_temp,
  partition año2011 values less than (to_date('01/1/2012','mm/dd/yyyy')) tablespace prueba,
  partition año2012 values less than (to_date('01/1/2013','mm/dd/yyyy')) tablespace prueba,
  partition añoencurso values less than (maxvalue) tablespace prueba_temp
);
	
create sequence a_seq;
-- Creamos otra secuencia para la columna b

create sequence b_seq maxvalue 26 cycle;
-- Creamos otra secuencia para la columna c

create sequence c_seq maxvalue 1000 cycle;
/* Creamos un procedimiento almacenado que inserta 'numregistros' en B
*/

create or replace
procedure inserta_en_B (numregistros in integer) as
  ultimo_año_nuevo date := trunc (sysdate,'year');
  dias_transcurridos number(3) := sysdate - ultimo_año_nuevo;
begin
  dbms_random.seed ('cualquier ristra');
  for i in 1..trunc(numregistros/2) loop
    insert into B values (a_seq.nextval, chr (b_seq.nextval+64), c_seq.nextval, ultimo_año_nuevo+dbms_random.value(0,dias_transcurridos));
  end loop;
  for i in 1..round(numregistros/2) loop
    insert into B values (a_seq.nextval, chr (b_seq.nextval+64), c_seq.nextval, ultimo_año_nuevo-i);
  end loop;
end;
/

call inserta_en_b(400000);
commit;

alter table alumno.b modify constraint clave_primaria_de_b disable;
create index primaria on alumno.B(a) LOCAL;
alter table alumno.b modify constraint clave_primaria_de_b enable;