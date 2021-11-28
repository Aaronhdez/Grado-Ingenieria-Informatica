truncate table a;
call inserta_en_a (1,450000);
call borra_en_a (1,300000);
select count (*) from a;
