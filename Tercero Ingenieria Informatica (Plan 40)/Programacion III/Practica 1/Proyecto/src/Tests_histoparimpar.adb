with Ada.Text_IO;  use Ada.Text_IO;
with pkg_HistoParImpar; use pkg_HistoParImpar;

procedure Tests_HistoParImpar is
   
   procedure Test_1 is
      Vector : constant T_Table(1..5) := (4,4,6,8,11);
   begin
      Put ("Test 1: [4,4,6,8,11] => ...........................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 4);
      pragma Assert (Impares = 1);
      Put_Line ("OK");
   end Test_1;

   procedure Test_2 is
      Vector : constant T_Table(1..5) := (4,4,6,8,10);
   begin
      Put ("Test 2: [4,4,6,8,10] => ...........................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 5);
      pragma Assert (Impares = 0);
      Put_Line ("OK");
   end Test_2;
   
   procedure Test_3 is
      Vector : constant T_Table(1..5) := (1,3,5,7,9);
   begin
      Put ("Test 3: [1,3,5,7,9] => ............................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 0);
      pragma Assert (Impares = 5);
      Put_Line ("OK");
   end Test_3;
   
   procedure Test_4 is
      Vector : constant T_Table(1..5) := (1,2,3,4,5);
   begin
      Put ("Test 4: [1,2,3,4,5] => ............................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 2);
      pragma Assert (Impares = 3);
      Put_Line ("OK");
   end Test_4;
   
   procedure Test_5 is
      Vector : constant T_Table(1..5) := (2,3,4,5,6);
   begin
      Put ("Test 5: [2,3,4,5,6] => ............................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 3);
      pragma Assert (Impares = 2);
      Put_Line ("OK");
   end Test_5;
   
   procedure Test_6 is
      Vector : constant T_Table(1..2) := (2,3);
   begin
      Put ("Test 6: [2,3] => ..................................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 1);
      pragma Assert (Impares = 1);
      Put_Line ("OK");
   end Test_6;
   
   procedure Test_7 is
      Vector : constant T_Table(1..2) := (-2,3);
   begin
      Put ("Test 7: [-2,3] => .................................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 1);
      pragma Assert (Impares = 1);
      Put_Line ("OK");
   end Test_7;
   
   procedure Test_8 is
      Vector : constant T_Table(1..5) := (1,-2,0,4,5);
   begin
      Put ("Test 8: [1,-2,0,4,5] => ...........................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 3);
      pragma Assert (Impares = 2);
      Put_Line ("OK");
   end Test_8;

   procedure Test_9 is
      Vector : constant T_Table(1..2) := (-2,0);
   begin
      Put ("Test 9: [-2,0] => .................................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 2);
      pragma Assert (Impares = 0);
      Put_Line ("OK");
   end Test_9;

   procedure Test_10 is
      Vector : constant T_Table(1..2) := (0,-1);
   begin
      Put ("Test 10: [0,-1] => ................................................");
      histoParImpar(Vector);
      pragma Assert (Pares = 1);
      pragma Assert (Impares = 1);
      Put_Line ("OK");
   end Test_10;
   
begin
  Put_Line ("********************* Tests_histParImpar");
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
   
end Tests_HistoParImpar;
