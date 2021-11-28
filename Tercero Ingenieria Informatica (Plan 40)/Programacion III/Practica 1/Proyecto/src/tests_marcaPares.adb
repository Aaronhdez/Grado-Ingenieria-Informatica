--  Add as many tests as you want to ensure that the calculator
--  behavior is correct in all cases.

with Ada.Text_IO;             use Ada.Text_IO;
with Pkg_marcaPares;        use Pkg_marcaPares;
with System.Assertions;

procedure tests_marcaPares is

   procedure Test_1 is
      Vector : T_Table(1..5) := (1,4,6,8,10);
   begin
      Put ("Test 1: [1,4,6,8,10] => [1,2,2,2,2] ...............................");

      marcaPares (Vector);
      pragma Assert (Vector = (1,2,2,2,2));
      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
      Vector : T_Table(1..5) := (1,3,5,7,9);
   begin
      Put ("Test 2: [1,4,6,8,10] => [1,3,5,7,9] ...............................");

      marcaPares (Vector);
      pragma Assert (Vector = (1,3,5,7,9));
      Put_Line ("OK");
   end Test_2;

   procedure Test_3 is
      Vector : T_Table(1..5) := (0,0,0,0,0);
   begin
      Put ("Test 3: [0,0,0,0,0] => [2,2,2,2,2] ................................");

      marcaPares (Vector);
      pragma Assert (Vector = (2,2,2,2,2));
      Put_Line ("OK");
   end Test_3;

   procedure Test_4 is
      Vector : T_Table(1..6) := (1,2,3,4,5,6);
   begin
      Put ("Test 4: [1,2,3,4,5,6] => [1,2,3,2,5,2] ............................");

      marcaPares (Vector);
      pragma Assert (Vector = (1,2,3,2,5,2));
      Put_Line ("OK");
   end Test_4;

   procedure Test_5 is
      Vector : T_Table(1..6) := (-1,-2,-3,-4,-5,-6);
   begin
      Put ("Test 5: [-1,-2,-3,-4,-5,-6] => [-1,2,-3,2,-5,2] ...................");

      marcaPares (Vector);
      pragma Assert (Vector = (-1,2,-3,2,-5,2));
      Put_Line ("OK");
   end Test_5;

   procedure Test_6 is
      Vector : T_Table(1..6) := (1,-2,3,-4,5,6);
   begin
      Put ("Test 6: [1,-2,3,-4,5,6] => [1,2,3,2,5,2] ..........................");

      marcaPares (Vector);
      pragma Assert (Vector = (1,2,3,2,5,2));
      Put_Line ("OK");
   end Test_6;

   procedure Test_7 is
      Vector : T_Table(1..6) := (Integer'Last,-2,3,-4,5,6);
   begin
      Put ("Test 7: [Integer'Last,-2,3,-4,5,6] => [Integer'Last,1,2,3,2,5,2] ..");

      marcaPares (Vector);
      pragma Assert (Vector = (Integer'Last,2,3,2,5,2));
      Put_Line ("OK");
   end Test_7;

   procedure Test_8 is
      Vector : T_Table(1..6) := (-Integer'Last,-2,3,-4,5,6);
   begin
      Put ("Test 8: [-Integer'Last,-2,3,-4,5,6] => [-Integer'Last,2,3,2,5,2] ..");

      marcaPares (Vector);
      pragma Assert (Vector = (-Integer'Last,2,3,2,5,2));
      Put_Line ("OK");
   end Test_8;

   procedure Test_9 is
      Vector : T_Table(1..6) := (Integer'First,-2,3,-4,5,6);
   begin
      Put ("Test 9: [Integer'First,-2,3,-4,5,6] => ERROR ......................");

      marcaPares (Vector);
      pragma Assert (Vector = (Integer'First,2,3,2,5,2));
      Put_Line ("FAILED");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_9;

begin
   Put_Line ("********************* tests_marcaPares");
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

end tests_marcaPares;
