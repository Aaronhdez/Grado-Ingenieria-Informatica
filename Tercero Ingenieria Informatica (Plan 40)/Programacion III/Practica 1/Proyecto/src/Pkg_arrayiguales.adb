package body Pkg_arrayIguales with SPARK_Mode is

   procedure arrayIguales(Vector1 : in T_Table; Vector2 : in
                                 T_table;  resultado: out Boolean) is
   begin
      resultado := True;

      for i in Vector1'First .. Vector1'Last loop
         if Vector1(i) /= Vector2(i) then
            resultado := false;
            exit;
         end if;
         
         -- LOCAL: se verifica la postcondición a nivel local
         pragma Loop_Invariant(if resultado /= resultado'Loop_Entry then
                                 (for some k in Vector1'First .. i =>
                                    Vector1(k) /= Vector2(k))
                               else 
                                 (for all k in Vector1'First .. i => 
                                    Vector1(k) = Vector2(k)));
      end loop;

   end arrayIguales;
   
end Pkg_arrayIguales;
