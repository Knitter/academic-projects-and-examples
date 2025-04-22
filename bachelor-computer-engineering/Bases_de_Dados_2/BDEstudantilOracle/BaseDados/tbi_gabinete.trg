--*******************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Gabinete *
--*******************************************************************************
create or replace trigger tbi_gabinete
  before insert on tbl_gabinete  
  for each row
begin
     :new.cod_gabinete := pkg_sequences.proximo_cod_gabinete;
end tbi_gabinete;
/
