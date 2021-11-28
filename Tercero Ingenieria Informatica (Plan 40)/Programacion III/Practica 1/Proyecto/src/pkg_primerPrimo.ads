-- Verificado en niveles 0-4
with Pkg_esPrimo;  use Pkg_esPrimo;
package Pkg_primerPrimo with SPARK_Mode is

   -- Inserta en la variable resultado, el primer primo existente en el vector.
   type T_Table is array (Natural range <>) of Integer;

   procedure primerPrimo (Vector : T_Table; Resultado :in out Natural)

   with
       Global  => null,
       Depends => (Resultado => (Vector),
                   null => (Resultado)),
       Pre     => ((Resultado = 0)
                   and then
                     (Vector'Length > 0 and Vector'Last < Natural'Last)
                   and then
                     (for all k in Vector'Range => Vector(k) > 0)),
       Post    => ((Resultado > Resultado'Old and then
                     (for some k in Vector'Range => Es_Primo(Vector(k))
                      and then
                        Resultado = Vector(k)))
                 or else
                   (Resultado = 0 and then
                        (for all k in Vector'Range => not Es_Primo(Vector(k)))
                     ));

end Pkg_primerPrimo;

