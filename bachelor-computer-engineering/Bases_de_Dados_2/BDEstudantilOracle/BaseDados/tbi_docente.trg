--************************************************************************
--* Trigger que permite introduzir o número de docente na tabela Docente *
--************************************************************************
create or replace trigger tbi_docente
  before insert on tbl_docente  
  for each row

begin
     :new.num_docente := pkg_sequences.proximo_num_docente;  
end tbi_docente;
/
