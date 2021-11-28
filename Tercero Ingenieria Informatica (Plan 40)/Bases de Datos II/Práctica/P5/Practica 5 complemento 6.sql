--Ir ejecutando bloque a bloque y observando el resultado

--Ejecutar en SQLPlus conectado como system el siguiente bloque de instrucciones
drop table a purge;
create table a (a integer) tablespace prueba;
alter table a enable row movement;
call inserta_en_a (1,450000);
commit;
set autotrace on statistics
select count (*) from a;
select count (*) from a;

--Ejecutar en SQLPlus conectado como system el siguiente bloque de instrucciones
call borra_en_a (100001,450000);
commit;
set autotrace on statistics
select count (*) from a;
select count (*) from a;

--Ejecutar en SQLPlus conectado como system el siguiente bloque de instrucciones
alter table a shrink space compact;
set autotrace on statistics
select count (*) from a;
select count (*) from a;

--Ejecutar en SQLPlus conectado como system el siguiente bloque de instrucciones
alter table a shrink space;
set autotrace on statistics
select count (*) from a;
select count (*) from a;
set autotrace off
