
--  Add as many tests as you want to ensure that the calculator
--  behavior is correct in all cases.

with Ada.Text_IO;  use Ada.Text_IO;
with Pkg_primerPrimo; use Pkg_primerPrimo;
with System.Assertions;

procedure Tests_primerPrimo is

   procedure Test_1 is
      Vector : constant T_Table(1..5) := (4,4,6,8,11);
      Resultado : Natural := 0;

   begin
      Put ("Test 1: [4,4,6,8,11] => ...........................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 11);
      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
      Vector : constant T_Table(1..5) := (11,4,6,8,4);
      Resultado : Natural := 0;

   begin
      Put ("Test 2: [11,4,6,8,4] => ...........................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 11);
      Put_Line ("OK");
   end Test_2;

   procedure Test_3 is
      Vector : constant T_Table(1..5) := (4,4,3,8,1);
      Resultado : Natural := 0;

   begin
      Put ("Test 3: [4,4,3,8,1] => ............................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 3);
      Put_Line ("OK");
   end Test_3;

   procedure Test_4 is
      Vector : constant T_Table(1..4) := (4,4,4,4);
      Resultado : Natural := 0;
   begin
      Put ("Test 4: [4,4,4,4] => ..............................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 0);
      Put_Line ("OK");
   end Test_4;

   procedure Test_5 is
      Vector : constant T_Table(1..4) := (1,3,5,7);
      Resultado : Natural := 0;
   begin
      Put ("Test 5: [1,5,3,7] => ..............................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 1);
      Put_Line ("OK");
   end Test_5;

    procedure Test_6 is
      Vector : constant T_Table(1..4) := (-1,3,5,7);
      Resultado : Natural := 0;
   begin
      Put ("Test 6: [-1,3,5,7] => .............................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 3);
      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_6;

     procedure Test_7 is
      Vector : constant T_Table(1..4) := (-1,-3,-5,-7);
      Resultado : Natural := 0;
   begin
      Put ("Test 7: [-1,-3,-5,-7] => ..........................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 0);
      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_7;

    procedure Test_8 is
      Vector : constant T_Table(1..4) := (4,0,2,4);
      Resultado : Natural := 0;
   begin
      Put ("Test 8: [4 ,0, 2 ,4] => ...........................................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 0);
      Put_Line ("OK");
     exception
        when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_8;

   procedure Test_9 is
      Vector : constant T_Table(1..11) := (4,8,2,4,3,10,12,4,6,8,10);
      Resultado : Natural := 0;
   begin
      Put ("Test 9: [4,8,2,4,3,10,12,4,6,8,10] => .............................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 2);
      Put_Line ("OK");
     exception
        when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_9;

    procedure Test_10 is
      Vector : constant T_Table(1..11) := (4,8,4,4,6,10,12,4,6,8,11);
      Resultado : Natural:= 0;
   begin
      Put ("Test 10: [4,8,4,4,6,10,12,4,6,8,11] => ............................");
      primerPrimo(Vector, Resultado);
      pragma Assert (Resultado = 11);
      Put_Line ("OK");
      exception
        when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_10;

begin
   Put_Line ("********************* Tests_primerPrimo");
   Test_1;
   Test_2;
   Test_3;
   Test_4;
   Test_5;
   Test_6;
   Test_7;
   Test_8;
   Test_9;
   Test_10;
   Put_Line ("");

end Tests_primerPrimo;
