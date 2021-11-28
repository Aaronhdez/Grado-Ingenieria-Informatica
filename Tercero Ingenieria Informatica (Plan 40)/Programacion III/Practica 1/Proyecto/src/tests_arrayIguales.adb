with Ada.Text_IO;  use Ada.Text_IO;
with Pkg_arrayIguales; use Pkg_arrayIguales;
with System.Assertions;

procedure tests_arrayIguales is
   
   procedure Test_1 is
      Vector1 : constant T_Table(1..5) := (4,4,6,8,11);
      Vector2 : constant T_Table(1..5) := (4,4,6,8,11);
   begin
      Put ("Test 1: [4,4,6,8,11] y [4,4,6,8,11]: True => ......................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (resultado);
      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
      Vector1 : constant T_Table(1..5) := (4,4,6,8,11);
      Vector2 : constant T_Table(1..5) := (4,4,6,8,10);
   begin
      Put ("Test 2: [4,4,6,8,11] y [4,4,6,8,10]: True => ......................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
   end Test_2;
   
   procedure Test_3 is
      Vector1 : constant T_Table(1..4) := (4,4,6,8);
      Vector2 : constant T_Table(1..5) := (4,4,6,8,10);
   begin
      Put ("Test 3: [4,4,6,8] y [4,4,6,8,10]: Impossible => ...................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_3;
   
   procedure Test_4 is
      Vector1 : constant T_Table(1..5) := (1,4,6,8,10);
      Vector2 : constant T_Table(1..5) := (4,4,6,8,10);
   begin
      Put ("Test 4: [1,4,6,8,10] y [4,4,6,8,10]: False => .....................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
   end Test_4;
   
   procedure Test_5 is
      Vector1 : constant T_Table(1..5) := (4,4,6,8,10);
      Vector2 : constant T_Table(1..5) := (4,4,3,8,10);
   begin
      Put ("Test 5: [4,4,6,8,10] y [4,4,3,8,10]: False => .....................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
   end Test_5;
   
   procedure Test_6 is
      Vector1 : constant T_Table(1..2) := (4,4);
      Vector2 : constant T_Table(1..2) := (4,3);
   begin
      Put ("Test 6: [4,4] y [4,3]: False => ...................................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
   end Test_6;
   
   procedure Test_7 is
      Vector1 : constant T_Table(2..6) := (4,4,3,8,10);
      Vector2 : constant T_Table(1..5) := (4,4,6,8,10);
   begin
      Put ("Test 7: (2..6) y (1..5): Impossible => ............................");
      arrayIguales(Vector1,Vector2);
      pragma Assert (not resultado);
      Put_Line ("OK");
      exception
         when System.Assertions.Assert_Failure =>
             Put_Line ("OK"); -- The precondition must fail in this case!
   end Test_7;
   
begin
  Put_Line ("********************* Tests_arraysIguales");
   Test_1;
   Test_2;
   Test_3;
   Test_4;
   Test_5;
   Test_6;
   Test_7;
   Put_Line ("");
   
   
end tests_arrayIguales;
