--  Add as many tests as you want to ensure that the calculator
--  behavior is correct in all cases.

with Ada.Text_IO; use Ada.Text_IO;
with Pkg_esPrimo;     use Pkg_esPrimo;
with System.Assertions;

procedure Tests_Primo is

   procedure Test_1 is
   begin
      Put ("Test 1: 1 (SI) ....................................................");

      pragma Assert (Es_Primo(1));

      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
   begin
      Put ("Test 2: 2 (SI) ....................................................");

      pragma Assert (Es_Primo(2));

      Put_Line ("OK");
   end Test_2;

   procedure Test_3 is
   begin
      Put ("Test 3: 3 (SI) ....................................................");

      pragma Assert (Es_Primo(3));

      Put_Line ("OK");
   end Test_3;

   procedure Test_4 is
   begin
      Put ("Test 4: 5 (SI) ....................................................");

      pragma Assert (Es_Primo(5));

      Put_Line ("OK");
   end Test_4;

   procedure Test_5 is
   begin
      Put ("Test 5: 0 (NO) ....................................................");

      pragma Assert (not Es_Primo(0));

      Put_Line ("FAILED");
      exception
      when System.Assertions.Assert_Failure =>
        Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_5;

   procedure Test_6 is
   begin
      Put ("Test 6: -13 (NO) ..................................................");

      pragma Assert (not Es_Primo(-13));

      Put_Line ("FAILED");
      exception
        when System.Assertions.Assert_Failure =>
        Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_6;

   procedure Test_7 is
   begin
      Put ("Test 7: -5 (NO) ...................................................");

      pragma Assert (not Es_Primo(-5));

      Put_Line ("FAILED");
      exception
        when System.Assertions.Assert_Failure =>
        Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_7;

   procedure Test_8 is
   begin
      Put ("Test 8: 4 (NO) ....................................................");

      pragma Assert (not Es_Primo(4));

      Put_Line ("OK");
   end Test_8;

   procedure Test_9 is
   begin
      Put ("Test 9: 14 (NO) ...................................................");

      pragma Assert (not Es_Primo(14));

      Put_Line ("OK");
   end Test_9;

   procedure Test_10 is
   begin
      Put ("Test 10: -5 (NO) ..................................................");

      pragma Assert (not Es_Primo(Integer'First));
      exception
        when System.Assertions.Assert_Failure =>
        Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_10;
begin
   Put_Line ("********************* Tests_Primo");
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
end Tests_Primo;
