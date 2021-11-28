-- Verificado en niveles 0-4
package Pkg_arrayIguales with SPARK_Mode is
   
   -- Comprueba si dos vectores de enteros son iguales o no. 
   -- Deposita el resultado en una variable global.
   type T_Table is array (Natural range <>) of Integer;
   lower : Integer;
     
   procedure arrayIguales (Vector1 : in T_Table; Vector2 : in T_table; resultado : out Boolean)
     with  
     Global => (Input => lower), 
     Depends => (resultado => (Vector1, Vector2)
                ),
     Pre => ((Vector1'Length = Vector2'Length) 
             and then 
               (Vector1'Length > 0) 
             and then 
               (Vector1'First = Vector2'First)
             and then
               (for all k in Vector1'Range =>
                    Vector1(k) > lower)
             and then
               (for all k in Vector1'Range =>
                    Vector2(k) > lower)),
     Post => ((if not resultado then
                  (for some i in Vector1'Range =>
                     Vector1(i) /= Vector2(i))
              or else      
                (for all j in Vector1'Range => 
                   Vector1(j) = Vector2(j))));   
end Pkg_arrayIguales;
