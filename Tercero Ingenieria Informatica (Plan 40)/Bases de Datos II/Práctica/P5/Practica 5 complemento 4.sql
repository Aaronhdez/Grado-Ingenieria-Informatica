set serveroutput on

declare
   tam_seg_bytes integer;
   candidato varchar2(100);

begin

   -- obtiene el tamaño en bytes del segmento de la tabla A
   select bytes into tam_seg_bytes
   from user_segments
   where segment_name='A';

   dbms_output.put_line ('Tamaño actual del segmento en bytes= '||tam_seg_bytes);

   -- Decide si el segmento puede reducirse a la tercera parte de su tamaño
   if (dbms_space.verify_shrink_candidate ('SYSTEM','A','TABLE',tam_seg_bytes/3)) then
      candidato := 'Se puede reducir en línea a un tercio de su tamaño';
   else
      candidato := 'No se puede reducir en línea a un tercio de su tamaño';
   end if;

   dbms_output.put_line (candidato);

end;
/
