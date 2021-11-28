-- Verificado en niveles 0-4
package Pkg_esPrimo with SPARK_Mode is

   -- Retorna verdadero o falso si alguno de los números que hay entre 2 y A-1
   -- divide a A. Si A es divisible por algún n entre 2 y A-1, no es primo

   function Es_Primo
     (Number : Integer) return Boolean
   with
   --   Global  => null,
     Depends => (Es_Primo'Result=> Number),
     Pre     => Number > 0,
   -- Si es primo entonces para todo k entre 2..N-1 el resto es /= 0
   -- Si no es primo, es que existe al menos un N en 2..N-1 que lo divide
     Post => ((if Es_Primo'Result then
                  (for all k in 2 .. Number-1 => Number rem k /= 0)
                or else
                  (for some k in 2 .. Number-1 => Number rem k = 0))
             );

end Pkg_esPrimo;
