-- Verificado en niveles 0-4
with Pkg_esPar; use Pkg_esPar;
package pkg_HistoParImpar with SPARK_Mode is
   
   -- Calcula los números pares e impares que contiene un vector. 
   -- Modifica para ello dos variables globales que almacenan los números
   -- pares e impares encontrados. 
   Pares: Integer;
   Impares: Integer;
   type T_Table is array (Positive range <>) of Integer;
   
   procedure histoParImpar (Vector : T_Table)
     with  
       Global  => (Output => (Pares,Impares)),
       Depends => (Pares => (Vector),
                   Impares => (Vector)),
       Pre     => (Vector'Length > 0 
                   and then Vector'Last < Positive'Last 
                   and then (for all k in Vector'Range => 
                                   Vector(k) > Integer'First)),
       Post    => (Pares + Impares = Vector'Length 
                   and then 
                     ((Pares > 0 and then
                          (for some j in Vector'Range => Es_Par(Vector(j)))) 
                      or else
                        (Pares = 0 and then
                             (for all j in Vector'Range => 
                                  not Es_Par(Vector(j)))))
                  );

end pkg_HistoParImpar;
