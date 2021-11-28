package body Pkg_esPrimo with SPARK_Mode is
   function Es_Primo
     (Number : Integer) return Boolean is
      A: Integer;
   begin
      A := Number;
      for i in 2 .. A-1 loop
         if (A mod i = 0) then
            return false;
         end if;

         -- ESTRUCTURAL: Se comprueba que la i nunca pueda superar el valor del número
         pragma Loop_Invariant(i <= A);

         -- LOCAL: Se comprueba que si el número es primo la función devuelve True y en caso
         -- contrario false
         pragma Loop_Invariant ((for all k in 2 .. i =>
                                  (if A mod k/=0 then
                                      True)));
      end loop;

      return true;
   end Es_Primo;

end Pkg_esPrimo;
