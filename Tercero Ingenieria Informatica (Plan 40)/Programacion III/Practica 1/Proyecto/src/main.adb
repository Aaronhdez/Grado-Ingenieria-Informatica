with Tests_Primo;         --*x* -> 0-4
with Tests_Par;           --*x* -> 0-4
with Tests_cuentaPrimos;  --*x* -> 0-4
with Tests_primerPrimo;   --*x* -> 0-4
with tests_arrayIguales;  --*x* -> 0-4
with Tests_HistoParImpar; --*x* -> 0-4
with tests_marcaPares;    --*x* -> 0-4

procedure Main is
begin
   Tests_Par;
   Tests_Primo;
   Tests_cuentaPrimos;
   Tests_primerPrimo;
   Tests_HistoParImpar;
   tests_arrayIguales;
   tests_marcaPares;

end Main;
