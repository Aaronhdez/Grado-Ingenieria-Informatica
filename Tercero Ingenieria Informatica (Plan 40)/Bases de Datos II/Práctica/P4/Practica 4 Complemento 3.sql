truncate table a;
call inserta_en_a (1,450000);
call borra_en_a (1,300000);
commit;
select count (*) from a;

variable inicio varchar2 (30)
begin
   :inicio := to_char (systimestamp, 'dd-mm-yyyy hh24:mi:ss.ff3');
end;
/
alter table a shrink space compact;
select systimestamp - to_timestamp (:inicio, 'dd-mm-yyyy hh24:mi:ss.ff3') Tiempo1 from dual;

truncate table a;
call inserta_en_a (1,450000);
call borra_en_a (150001,450000);
commit;
select count (*) from a;

variable inicio varchar2 (30)
begin
   :inicio := to_char (systimestamp, 'dd-mm-yyyy hh24:mi:ss.ff3');
end;
/
alter table a shrink space compact;
select systimestamp - to_timestamp (:inicio, 'dd-mm-yyyy hh24:mi:ss.ff3') Tiempo2 from dual;
