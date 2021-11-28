package body Pkg_primerPrimo with SPARK_Mode is
   procedure primerPrimo(Vector : T_Table; Resultado :in out Natural) is
   begin
      Resultado := 0;
      for i in Vector'Range loop
         if(Es_Primo(Vector(i))) then
            Resultado := Vector(i);
            exit;
         end if;

         -- LOCAL: Se verifica que R=>S ya que:
         -- La variable resultado, al depender del vector, se mantendrá similar
         -- o mayor que su mayor índice (en su rango)
         pragma Loop_Invariant((for all j in Vector'First .. i =>
                                  (if Es_Primo(Vector(j)) then
                                  Resultado = Vector(j))));
      end loop;
   end primerPrimo;

end Pkg_primerPrimo;
