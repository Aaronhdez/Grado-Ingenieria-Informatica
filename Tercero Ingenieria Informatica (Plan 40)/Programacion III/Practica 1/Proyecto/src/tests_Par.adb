--  Add as many tests as you want to ensure that the calculator
--  behavior is correct in all cases.

with Ada.Text_IO;   use Ada.Text_IO;
with Pkg_esPar;  use Pkg_esPar;
with System.Assertions;

procedure Tests_Par is

   procedure Test_1 is
   begin
      Put ("Test 1: 2 (SI) ....................................................");

      pragma Assert (Es_Par(2));

      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
   begin
      Put ("Test 2: 1 (NO) ....................................................");

      pragma Assert (not Es_Par(1));

      Put_Line ("OK");
   end Test_2;

   procedure Test_3 is
   begin
      Put ("Test 3: 0 (SI) ....................................................");

      pragma Assert (Es_Par(0));

      Put_Line ("OK");
   end Test_3;

   procedure Test_4 is
   begin
      Put ("Test 4: Integer'Last (NO) .........................................");

      pragma Assert (not Es_Par(Integer'Last));

      Put_Line ("OK");
   end Test_4;

   procedure Test_5 is
   begin
      Put ("Test 5: -101 (NO) .................................................");

      pragma Assert (not Es_Par(-101));

      Put_Line ("OK");
   end Test_5;

   procedure Test_6 is
   begin
      Put ("Test 6: -102 (SI) .................................................");

      pragma Assert (Es_Par(-102));

      Put_Line ("OK");
   end Test_6;


   procedure Test_7 is
   begin
      Put ("Test 7: Integer'First (Imposible) .................................");

      pragma Assert (Es_Par(Integer'First));
      exception
        when System.Assertions.Assert_Failure =>
        Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_7;

begin
   Put_Line ("********************* Tests_Par");
   Test_1;
   Test_2;
   Test_3;
   Test_4;
   Test_5;
   Test_6;
   Test_7;
   Put_Line ("");

end Tests_Par;
