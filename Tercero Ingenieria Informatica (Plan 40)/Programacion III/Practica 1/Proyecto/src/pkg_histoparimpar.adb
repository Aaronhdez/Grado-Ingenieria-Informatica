package body pkg_HistoParImpar with SPARK_Mode is
   procedure histoParImpar (Vector : T_Table) is
      nPares : Natural := 0;
   begin
      for i in Vector'Range loop
         if(Es_Par(Vector(i))) then
            nPares := nPares+1;
         end if;
         
         -- LOCAL: Si hay Pares registrados, es que al menos uno de los 
         -- anteriores es par y, aún así Npares <= i.
         pragma Loop_Invariant(if nPares > nPares'Loop_Entry then
                                 (for some j in Vector'First .. i => 
                                    Es_Par(Vector(j)))
                               and then nPares <= i);
         
         -- LOCAL: Si no hay Pares registrados es que todos los anteriores son 
         -- impares y por tanto Npares <= i.
         pragma Loop_Invariant(if nPares = nPares'Loop_Entry then
                                 (for all j in Vector'First .. i => 
                                    not Es_Par(Vector(j)))
                               and then nPares <= i);
      end loop;  
      Pares := nPares;
      Impares := Vector'Length - nPares;
   end histoParImpar;   
 end pkg_HistoParImpar;
