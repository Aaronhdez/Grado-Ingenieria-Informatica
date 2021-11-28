create table B (a int constraint clave_primaria_de_B primary key,
                      b char,
                      c int,
                      fecha date);

-- Creamos una secuencia para la clave primaria a

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
