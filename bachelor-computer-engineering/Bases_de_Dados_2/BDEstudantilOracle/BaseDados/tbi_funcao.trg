--*****************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Funcao *
--*****************************************************************************
create or replace trigger tbi_funcao
  before insert on tbl_funcao  
  for each row

begin
     :new.cod_funcao := pkg_sequences.proximo_cod_funcao;  
end tbi_funcao;
/
