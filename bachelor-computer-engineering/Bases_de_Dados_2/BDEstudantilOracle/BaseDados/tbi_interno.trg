--******************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela interno *
--******************************************************************************
create or replace trigger tbi_interno
  before insert on tbl_interno
  for each row

begin
     :new.cod_interno := pkg_sequences.proximo_cod_interno;
end tbi_interno;
/
