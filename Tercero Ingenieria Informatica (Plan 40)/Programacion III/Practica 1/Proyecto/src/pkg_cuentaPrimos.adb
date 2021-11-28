package body Pkg_cuentaPrimos with SPARK_Mode is
   procedure cuentaPrimos
     (Vector : T_Table) is
      i : Natural := Vector'First;
   begin
      NPrimos := 0;
      while (i <= Vector'Last) loop
         if(Es_Primo(Vector(i))) then
            NPrimos := NPrimos+1;
         end if;

         -- ESTRUCTURAL: i se incrementa a cada vuelta
         pragma Loop_Variant(Increases => i);

         -- ESTRUCTURAL / LOCAL: Se comprueba que i está en el rango.
         pragma Loop_Invariant(i in Vector'Range);

         -- LOCAL: Se verifica que si el valor de Nprimos cambia respecto a su
         -- entrada en la iteracion N, es que hay algún número que es primo. Se
         -- justifica además que NPrimos siempre es <= que el recorrido actual
         pragma Loop_Invariant(if NPrimos > NPrimos'Loop_Entry then
                                 (for some k in Vector'First .. i =>
                                    Es_Primo(Vector(k))) and then NPrimos <= i);
         i := i+1;
      end Loop;
   end cuentaPrimos;
end Pkg_cuentaPrimos;
