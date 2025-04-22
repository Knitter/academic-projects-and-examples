--**********************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Ano_Lectivo *
--**********************************************************************************
create or replace trigger tbi_ano_lectivo
  before insert on tbl_ano_lectivo  
  for each row

begin
  :new.codigo := pkg_sequences.proximo_cod_ano_lectivo;
end tbi_ano_lectivo;
/
