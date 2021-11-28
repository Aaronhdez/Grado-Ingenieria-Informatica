drop tablespace is2 including contents and datafiles;

create tablespace is2 datafile 'F:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\is2' size 100M reuse logging extent management local segment space management auto;
