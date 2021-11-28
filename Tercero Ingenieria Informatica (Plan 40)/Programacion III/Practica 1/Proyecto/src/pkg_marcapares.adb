package body Pkg_marcaPares with SPARK_Mode is
   
   procedure marcaPares
     (Vector : in out T_Table) is
      i : Natural := Vector'First;
   begin   
      while (i<=Vector'Last) loop
         if Es_Par(Vector(i)) then
            Vector(i) := 2;
         end if;
         
         -- LOCAL: Se comprueba que el valor de vector cambia si hemos pasado 
         -- por él y si es necesario
         pragma Loop_Invariant(for all k in Vector'First .. i => 
                                 (if Es_Par(Vector'Loop_Entry(k)) then 
                                     Vector(k) = 2
                                  else
                                     Vector(k)=Vector'Loop_Entry(k)
                                 ));
         
         -- LOCAL: se comprueba si en el lado restante del vector sigue igual.
         pragma Loop_Invariant(for all k in i+1..Vector'Last => 
                                 Vector(k)=Vector'Loop_Entry(k));
         
         -- ESTRUCTURAL: i se incrementa a cada vuelta
         pragma Loop_Variant(Increases => i);
         
         -- ESTRUCTURAL: Se comprueba que i está en el rango.
         pragma Loop_Invariant(i in Vector'Range);
         i := i+1;
      end loop;
   end marcaPares;
   
end Pkg_marcaPares;
