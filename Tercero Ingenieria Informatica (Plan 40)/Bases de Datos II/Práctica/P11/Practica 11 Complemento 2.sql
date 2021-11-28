/*
Inserte comentarios para explicar detalladamente el comportamiento
de las situaciones mostradas en este complemento al objeto de entender
por qué se distribuyen de tal manera las filas en los bloques.
*/

truncate table a;

call inserta_en_a (1,2000);
select * from resumen;

truncate table a;

call inserta_en_a (1,587);
select * from resumen;

call borra_en_a (101,200);
select * from resumen;

insert into a values (588);
select * from resumen;

truncate table a;

call inserta_en_a (1,587);
select * from resumen;

insert into a values (588);
select * from resumen;

call borra_en_a (101,200);
select * from resumen;

insert into a values (589);
select * from resumen;

call borra_en_a (201,325);
select * from resumen;

insert into a values (590);
select * from resumen;

delete from a where a=326;
select * from resumen;

insert into a values (591);
select * from resumen;

call inserta_en_a (592,733);
select * from resumen;

insert into a values (734);
select * from resumen;

call borra_en_a (327,468);
select * from resumen;

insert into a values (735);
select * from resumen;

delete from a where a=469;
select * from resumen;

insert into a values (736);
select * from resumen;

select * from contenido;

commit;

select * from contenido;
