/*
Inserte comentarios para explicar detalladamente el comportamiento
de las situaciones mostradas en este complemento al objeto de entender
por qué se muestran de tal manera las filas en un select sin order by.
*/

drop table a purge;

create table A (a integer constraint clave_primaria_de_A primary key) pctfree 20 tablespace prueba;

call inserta_en_a (1,2000);
select * from resumen;
select a from a;


drop table a purge;

create table A (a integer constraint clave_primaria_de_A primary key) pctfree 20 pctused 30 tablespace prueba_man;

call inserta_en_a (1,2000);
select * from resumen;
select a from a;
