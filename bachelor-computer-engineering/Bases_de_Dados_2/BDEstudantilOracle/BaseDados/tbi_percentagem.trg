--*********************************************************************************************
--* Trigger que permite introduzir o valor da chave dado pela sequência na tabela percentagem *
--*********************************************************************************************
create or replace trigger tbi_percentagem
  before insert on tbl_percentagem  
  for each row
begin
     :new.cod_percentagem := pkg_sequences.proximo_cod_percentagem;  
end tbi_percentagem;
/
