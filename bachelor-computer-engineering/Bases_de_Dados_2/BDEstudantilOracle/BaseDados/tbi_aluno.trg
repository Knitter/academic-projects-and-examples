--********************************************************************
--* Trigger que permite introduzir o número de aluno na tabela Aluno *
--********************************************************************
create or replace trigger tbi_aluno
  before insert on tbl_aluno  
  for each row

begin
     :new.num_aluno := pkg_sequences.proximo_num_aluno;  
end tbi_aluno;
/
