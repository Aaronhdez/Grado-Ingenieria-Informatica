-- Verificado en niveles 0-4
with Pkg_esPar;        use Pkg_esPar;
package Pkg_marcaPares with SPARK_Mode is
   -- Comprueba los números pares situados en un vector y modifica dicho valor 
   -- par por un 2 en la posición donde se encontró.
   
   type T_Table is array (Natural range <>) of Integer;
   procedure marcaPares
     (Vector : in out T_Table)
     with
     Global  => null,
     Depends => (Vector => Vector),
     Pre  => (Vector'Length > 0 
              and then Vector'Last < Natural'Last
              and then (for all k in Vector'Range =>
                            Vector(k) > Integer'First)),
     Post => (for all k in Vector'Range => 
                (if Vector(k) = 2 then
                     Es_Par(Vector'Old(k))
                   else 
                     Vector(k)=Vector'Old(k)));
end Pkg_marcaPares;
