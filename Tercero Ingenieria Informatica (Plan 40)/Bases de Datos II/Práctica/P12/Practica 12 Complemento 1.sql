drop table spj purge;
drop table s purge;
drop table p purge;
drop table j purge;

create table s	(sn varchar2(3) constraint s_pk primary key,
		 snombre varchar2(25) constraint s_snombre_nn not null,
		 situacion number(3),
		 ciudad varchar2(25)) tablespace prueba;

create table p (pn varchar2(3) constraint p_pk primary key,
		pnombre varchar2(25) constraint p_pnombre_nn not null,
		peso number(5),
		color varchar2(25),
		ciudad varchar2(25)) tablespace prueba;

create table j	(jn varchar2(3) constraint j_pk primary key,
		 jnombre varchar2(25) constraint j_jnombre_nn not null,
		 ciudad varchar2(25)) tablespace prueba;

create table spj (sn varchar2(3) constraint spj_sn_fk references s,
		  pn varchar2(3) constraint spj_pn_fk references p,
		  jn varchar2(3) constraint spj_jn_fk references j,
		  cantidad number(5) constraint spj_cantidad_nn not null,
		  constraint spj_pk primary key (sn, pn, jn)) tablespace prueba;

insert into s values ('s1','Yeray',100,'Las Palmas');
insert into s values ('s2','Alexis',150,'Las Palmas');
insert into s values ('s3','Dacil',100,'Telde');
insert into s values ('s4','Gines',200,'Arrecife');
insert into s values ('s5','Santiago',150,'Galdar');
insert into s values ('s6','Maciot',null,'Arrecife');

insert into p values ('p1','cuchilla',25,'rojo','Arinaga');
insert into p values ('p2','boliche',100,'azul','Telde');
insert into p values ('p3','cojinete',75,'amarillo','Las Palmas');
insert into p values ('p4','motor',1000,'verde','La Laguna');
insert into p values ('p6','chicharo grande',30,'verde','Arrecife');
insert into p values ('p7','chicharo chico',15,'amarillo','Arrecife');

insert into j values ('j1','Nevera','Vecindario');
insert into j values ('j2','Coche','Telde');
insert into j values ('j3','PC','Aguimes');
insert into j values ('j4','Placas solares','Vecindario');
insert into j values ('j5','Aire acondicionado','Tunte');
insert into j values ('j6','Potaje','Arrecife');

insert into spj values ('s1','p1','j1',100);
insert into spj values ('s1','p1','j4',650);
insert into spj values ('s1','p1','j5',100);
insert into spj values ('s1','p2','j1',300);
insert into spj values ('s1','p2','j4',200);
insert into spj values ('s1','p2','j5',300);
insert into spj values ('s1','p3','j3',100);
insert into spj values ('s1','p4','j1',1);
insert into spj values ('s2','p1','j3',100);
insert into spj values ('s2','p2','j2',200);
insert into spj values ('s2','p3','j1',150);
insert into spj values ('s2','p3','j2',100);
insert into spj values ('s2','p3','j5',250);
insert into spj values ('s4','p6','j6',300);
insert into spj values ('s6','p6','j4',100);
insert into spj values ('s6','p7','j6',100);

commit;
