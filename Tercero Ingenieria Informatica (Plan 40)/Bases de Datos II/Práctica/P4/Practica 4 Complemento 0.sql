drop table A purge;

create table A (a integer constraint clave_primaria_de_A primary key) tablespace prueba;

-- Creamos un procedimiento almacenado que inserta una secuencia de registros en A
-- que van de 1 en 1 desde 'primero' a 'ultimo'

create or replace
procedure inserta_en_A (primero in A.a%type, ultimo in A.a%type) as
begin
  for i in primero..ultimo loop
     insert into A values (i);
  end loop;
end;
/

-- Creamos un procedimiento almacenado que borra aquellos registros de A
-- con valores entre 'primero' y 'ultimo'

create or replace
procedure borra_en_A (primero in A.a%type, ultimo in A.a%type) as
begin
  delete from A
  where a between primero and ultimo;
end;
/
