-- Verificado en niveles 0-4
package Pkg_esPar with SPARK_Mode is

   -- Retorna verdadero o falso si el módulo de la división por dos es 0 o no
   -- (si es par o impar)
   function Es_Par
     (Number : Integer) return boolean
   with
   --      Global  => ...
     Depends => (Es_Par'Result => Number),
     Pre     => Number > Integer'First,
     Post => ((Es_Par'Result
              and then
                (Number rem 2 = 0))
              or else
                (not Es_Par'Result
                 and then
                   (Number rem 2 /= 0)));

end Pkg_esPar;
