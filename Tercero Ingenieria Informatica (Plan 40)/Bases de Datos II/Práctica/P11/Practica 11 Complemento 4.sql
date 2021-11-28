/*
Inserte comentarios para explicar detalladamente el comportamiento
de las situaciones mostradas en este complemento al objeto de entender
por qué se distribuyen de tal manera las filas en los bloques.
*/

drop table a purge;

create table A (a integer constraint clave_primaria_de_A primary key) pctfree 20 pctused 40 tablespace prueba_man;

truncate table a;

call inserta_en_a (1,587);
select * from resumen;

call borra_en_a (101,200);
select * from resumen;

insert into a values (588);
select * from resumen;
select * from contenido;
commit;
select * from contenido;

truncate table a;

call inserta_en_a (1,587);
select * from resumen;

call borra_en_a (101,200);
commit;
select * from resumen;

insert into a values (588);
select * from resumen;
select * from contenido;
commit;
select * from contenido;