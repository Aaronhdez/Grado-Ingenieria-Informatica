set serveroutput on

declare

   bytes_libres_0_25 number;
   bytes_libres_25_50 number;
   bytes_libres_50_75 number;
   bytes_libres_75_100 number;
   bloques_libres_0_25 number;
   bloques_libres_25_50 number;
   bloques_libres_50_75 number;
   bloques_libres_75_100 number;
   bytes_llenos number;
   bloques_llenos number;
   bytes_sin_formatear number;
   bloques_sin_formatear number;

begin

   dbms_space.space_usage(
                       segment_owner => 'SYSTEM',
                       segment_name => 'A',
                       segment_type => 'TABLE',
                       fs1_bytes => bytes_libres_0_25,
                       fs1_blocks => bloques_libres_0_25,
                       fs2_bytes => bytes_libres_25_50,
                       fs2_blocks => bloques_libres_25_50,
                       fs3_bytes => bytes_libres_50_75,
                       fs3_blocks => bloques_libres_50_75,
                       fs4_bytes => bytes_libres_75_100,
                       fs4_blocks => bloques_libres_75_100,
                       full_bytes => bytes_llenos,
                       full_blocks => bloques_llenos,
                       unformatted_bytes => bytes_sin_formatear,
                       unformatted_blocks => bloques_sin_formatear);
   dbms_output.put_line('Bloques llenos ........................................= '||bloques_llenos||'; Bytes = '||bytes_llenos);
   dbms_output.put_line('Bloques con espacio libre 0%-25% ....= '||bloques_libres_0_25||'; Bytes = '||bytes_libres_0_25);
   dbms_output.put_line('Bloques con espacio libre 25%-50% ..= '||bloques_libres_25_50||'; Bytes = '||bytes_libres_25_50);
   dbms_output.put_line('Bloques con espacio libre 50%-75% ..= '||bloques_libres_50_75||'; Bytes = '||bytes_libres_50_75);
   dbms_output.put_line('Bloques con espacio libre 75%-100% = '||bloques_libres_75_100||'; Bytes = '||bytes_libres_75_100);
   dbms_output.put_line('Bloques sin formatear ...........................= '||bloques_sin_formatear||'; Bytes = '||bytes_sin_formatear);

end;
/
