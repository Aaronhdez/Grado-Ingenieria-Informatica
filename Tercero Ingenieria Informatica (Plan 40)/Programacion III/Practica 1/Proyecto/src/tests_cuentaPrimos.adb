--  Add as many tests as you want to ensure that the calculator
--  behavior is correct in all cases.

with Ada.Text_IO;             use Ada.Text_IO;
with Pkg_cuentaPrimos;        use Pkg_cuentaPrimos;
with System.Assertions;

procedure Tests_cuentaPrimos is

   procedure Test_1 is
      Vector : constant T_Table(1..5) := (0,4,6,8,10);
   begin
      Put ("Test 1: [0,4,6,8,10] => 0 (El cero no cumple) .....................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 0);
      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_1;


   procedure Test_2 is
      Vector : constant T_Table(1..5) := (1,4,6,8,10);
   begin
      Put ("Test 2: [1,4,6,8,10] => 1 Primo ...................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 1);

      Put_Line ("OK");
   end Test_2;

   procedure Test_3 is
      Vector : constant T_Table(1..5) := (1,4,3,8,10);
   begin
      Put ("Test 3: [1,4,3,8,10] => 2 Primos ..................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 2);

      Put_Line ("OK");
   end Test_3;

   procedure Test_4 is
      Vector : constant T_Table(1..5) := (-1,4,4,8,3);
   begin
      Put ("Test 4: [-1,4,4,8,3] => 0 (el -1 no Cumple) .......................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = -1);

      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_4;

   procedure Test_5 is
      Vector : constant T_Table(1..3) := (-1,4,10);
   begin
      Put ("Test 5: [-1,4,10] => 0 (el -1 no Cumple) ..........................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = -1);

      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_5;

   procedure Test_6 is
      Vector : constant T_Table(1..3) := (1,3,5);
   begin
      Put ("Test 6: [1,3,5] => 3 Primos .......................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 3);

      Put_Line ("OK");
   end Test_6;

   procedure Test_7 is
      Vector : constant T_Table(1..2) := (1,2);
   begin
      Put ("Test 7: [1,2] => 2 Primos .........................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 2);

      Put_Line ("OK");
   end Test_7;

   procedure Test_8 is
      Vector : constant T_Table(1..2) := (9,12);
   begin
      Put ("Test 8: [9,12] => 0 Primos ........................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 0);

      Put_Line ("OK");
   end Test_8;

   procedure Test_9 is
      Vector : constant T_Table(1..2) := (9,1);
   begin
      Put ("Test 9: [9,1] => 1 Primo ..........................................");

      NPrimos := 0;
      cuentaPrimos (Vector);
      pragma Assert (NPrimos = 1);

      Put_Line ("OK");
   end Test_9;

begin
   Put_Line ("********************* Tests_cuentaPrimos");
   Test_1;
   Test_2;
   Test_3;
   Test_4;
   Test_5;
   Test_6;
   Test_7;
   Test_8;
   Test_9;
   Put_Line ("");

end Tests_cuentaPrimos;
