select bytes from user_segments where segment_name='A';

variable x char
begin
   if (dbms_space.verify_shrink_candidate('SYSTEM','A','TABLE',1100000)) then
      :x := 'V';
   else
      :x := 'F';
   end if;
end;
/

print :x

