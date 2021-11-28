VARIABLE total_blocks NUMBER
VARIABLE total_bytes NUMBER
VARIABLE unused_blocks NUMBER
VARIABLE unused_bytes NUMBER
VARIABLE lastextf NUMBER
VARIABLE last_extb NUMBER
VARIABLE lastusedblock NUMBER
exec DBMS_SPACE.UNUSED_SPACE('SYSTEM','A','TABLE', :total_blocks,:total_bytes,:unused_blocks,:unused_bytes, :lastextf,  :last_extb, :lastusedblock);


