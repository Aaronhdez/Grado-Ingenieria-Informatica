select *
from table (dbms_space.object_dependent_segments ('SYSTEM','A',null,1))
