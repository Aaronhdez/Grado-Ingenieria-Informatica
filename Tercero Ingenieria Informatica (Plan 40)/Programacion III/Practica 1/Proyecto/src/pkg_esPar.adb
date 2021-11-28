package body Pkg_esPar with SPARK_Mode is

   function Es_Par
     (Number : Integer) return boolean is
   begin
      if(Number mod 2 = 0) then
         return true;
      else
         return false;
      end if;
   end Es_Par;

end Pkg_esPar;
