/*
Este guión reconstruye los tablespaces prueba y prueba_temp en orcl y su contenido.
Debe usarse en caso de que el complemento 4 en el punto 17 se use incorrectamente
y se pierda su información y/o sus archivos de datos.
Debe ser ejecutado por system@orcl.
*/

drop sequence alumno.a_seq;
drop sequence alumno.b_seq;
drop sequence alumno.c_seq;

create tablespace prueba
       datafile 'f:\oracle\product\10.2.0\oradata\orcl\prueba01'
                 size 10M reuse autoextend on next 10M maxsize 1G,
                'c:\oradata\orcl\prueba02'
                 size 10M reuse
       logging extent management local segment space management auto;

create tablespace prueba_temp
       datafile 'f:\oracle\product\10.2.0\oradata\orcl\prueba_temp'
                 size 100M reuse autoextend on next 10M maxsize 1G
       logging extent management local segment space management auto;

begin
   execute immediate
    q'¡create table alumno.b (a int constraint clave_primaria_de_b primary key,
                              b char,
                              c int,
                              fecha date)
          partition by range (fecha)
             (partition restoaños values less than (to_date ('01-01-¡' || to_char (extract (year from sysdate) - 2) || q'¡', 'dd-mm-yyyy')) tablespace prueba_temp,
              partition año¡' || to_char (extract (year from sysdate)-2) || q'¡ values less than (to_date ('01-01-¡' || to_char (extract (year from sysdate) - 1) || q'¡', 'dd-mm-yyyy')),
              partition año¡' || to_char (extract (year from sysdate)-1) || q'¡ values less than (to_date ('01-01-¡' || to_char (extract (year from sysdate)) || q'¡', 'dd-mm-yyyy')),
              partition añoencurso values less than (maxvalue) tablespace prueba_temp)¡';
end;
/

-- Creamos una secuencia para la clave primaria a

create sequence alumno.a_seq;

-- Creamos otra secuencia para la columna b

create sequence alumno.b_seq maxvalue 26 cycle;

-- Creamos otra secuencia para la columna c

create sequence alumno.c_seq maxvalue 1000 cycle;

/* Creamos un procedimiento almacenado que inserta 'numregistros' en B
*/

create or replace
procedure alumno.inserta_en_B (numregistros in integer) as
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

call alumno.inserta_en_b (400000);
select count(*) from alumno.b;
commit;
