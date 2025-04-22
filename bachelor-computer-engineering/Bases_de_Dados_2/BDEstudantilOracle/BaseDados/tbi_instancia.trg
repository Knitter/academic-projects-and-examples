--********************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Instancia *
--********************************************************************************
create or replace trigger tbi_instancia
  before insert on tbl_instancia  
  for each row
begin
  :new.cod_instancia := pkg_sequences.proximo_cod_instancia;
end tbi_instancia;
/
