/*S15: El indice no es prefijado porque aunque el indice esta particionado el campo de partici�n del indice no es subconjunto izquierdo del campo de indexaci�n del indice.*/
drop table b purge;
drop sequence a_seq;
drop sequence b_seq;
drop sequence c_seq;

create table b
(
a int constraint clave_primaria_de_b primary key,
b char,
c int,
fecha date
) partition by range(fecha)(
    partition restoa�os values less than (to_date('01/1/2018','mm/dd/yyyy')) tablespace prueba_temp,
    partition a�o2018 values less than (to_date('01/1/2019','mm/dd/yyyy')) tablespace prueba,
    partition a�o2019 values less than (to_date('01/1/2020','mm/dd/yyyy')) tablespace prueba,
    partition a�oencurso values less than (maxvalue) tablespace prueba_temp);

-- Creamos una secuencia para la columna a
create sequence a_seq;

-- Creamos otra secuencia para la columna b
create sequence b_seq maxvalue 26 cycle;

-- Creamos otra secuencia para la columna c
create sequence c_seq maxvalue 1000 cycle;

/* 
Creamos un procedimiento almacenado que inserta 'numregistros' en B
*/
create or replace
procedure inserta_en_B (numregistros in integer) as
  ultimo_a�o_nuevo date := trunc (sysdate,'year');
  dias_transcurridos number(3) := sysdate - ultimo_a�o_nuevo;
begin
  dbms_random.seed ('cualquier ristra');
  for i in 1..trunc(numregistros/2) loop
    insert into B values (a_seq.nextval, chr (b_seq.nextval+64), c_seq.nextval, ultimo_a�o_nuevo+dbms_random.value(0,dias_transcurridos));
  end loop;
  for i in 1..round(numregistros/2) loop
    insert into B values (a_seq.nextval, chr (b_seq.nextval+64), c_seq.nextval, ultimo_a�o_nuevo-i);
  end loop;
end;
/
	
call inserta_en_b(400000);
commit;

create index global_fecha on b(fecha) global
partition by range(c)(
  partition hasta250 values less than 250 tablespace prueba_temp,
  partition hasta500 values less than 500 tablespace prueba,
  partition hasta750 values less than 750 tablespace prueba,
  partition resto values less than (maxvalue) tablespace prueba_temp
);
