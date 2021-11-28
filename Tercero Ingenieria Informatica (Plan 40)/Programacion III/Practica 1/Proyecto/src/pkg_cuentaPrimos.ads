-- Verificado en niveles 0-4
with Pkg_esPrimo;        use Pkg_esPrimo;
package Pkg_cuentaPrimos with SPARK_Mode is
   NPrimos : Integer;
   type T_Table is array (Natural range <>) of Integer;

   procedure cuentaPrimos
     (Vector : T_Table)
     with
     Global  => (In_Out => NPrimos),
     Depends => (NPrimos => (Vector),
                 null => (NPrimos)),
     Pre  =>(Vector'Length > 0
             and then Vector'First = 1
             and then Vector'Last < Natural'Last
             and then (for all k in Vector'Range => Vector(k) > 0)
             and then (NPrimos = 0)),
     Post => ((if NPrimos > Nprimos'Old
                  then
                (for some k in Vector'Range => Es_Primo(Vector(k)))
              and then NPrimos <= Vector'Length)
              or else
                (if NPrimos = NPrimos'Old then
                   (for all k in Vector'Range => not Es_Primo(Vector(k))))
             );

end Pkg_cuentaPrimos;
