set serveroutput on

declare
   nombre_segmento user_segments.segment_name%type;
   tipo_segmento user_segments.segment_type%type;
   tam_seg_bytes user_segments.bytes%type;
   candidato varchar2(100);

   /*
   Vamos a comprobar cada segmento del tablespace PRUEBA para verificar si puede reducirse en linea a un tercio de su tamaño.

   Como la sentencia SQL a ejecutar puede devolver multiples registros necesitamos hacer uso de un cursor; es decir, un mecanismo mediante el cual podemos procesar secuencialmente el conjunto de tuplas de la respuesta.

   Empezamos por declarar un cursor llamado 'segmentos' y asociarlo a la sentencia SQL

   OJO!!! estamos aún en el bloque declare.
   */

   cursor segmentos is select segment_name, segment_type, bytes
                       from user_segments
                       where tablespace_name='PRUEBA';

begin

   -- Ejecutamos la sentencia del cursor y obtenemos el conjunto respuesta
   open segmentos;

   loop

      /*
      Asigna en cada iteración los atributos de la cláusula select a las variables de la cláusula 'into' 
      */
      fetch segmentos into nombre_segmento, tipo_segmento, tam_seg_bytes;

      -- Deja de iterar cuando un fetch no encuentra más registros en el conjunto respuesta
      exit when segmentos%notfound;

      -- Muestra el tamaño en bytes del segmento
      dbms_output.put_line('Tamaño actual del segmento ' ||nombre_segmento|| ' en bytes = ' || tam_seg_bytes);

      -- Decide si el segmento puede reducirse a la tercera parte de su tamaño
      if (dbms_space.verify_shrink_candidate('SYSTEM', nombre_segmento, tipo_segmento, tam_seg_bytes/3)) then
         candidato := 'Se puede reducir en línea a un tercio de su tamaño';
      else
         candidato := 'No se puede reducir en línea a un tercio de su tamaño';
      end if;
      dbms_output.put_line (candidato);

   end loop;

   -- Cierra el cursor 'segmentos' y se deshace del conjunto respuesta
   close segmentos;

end;
/
