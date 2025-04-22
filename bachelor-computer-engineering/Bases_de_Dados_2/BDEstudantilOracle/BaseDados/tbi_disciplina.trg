--*********************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Disciplina *
--*********************************************************************************
create or replace trigger tbi_disciplina
  before insert on tbl_disciplina  
  for each row

begin
     :new.cod_disciplina := pkg_sequences.proximo_cod_disciplina;  
end tbi_disciplina;
/
