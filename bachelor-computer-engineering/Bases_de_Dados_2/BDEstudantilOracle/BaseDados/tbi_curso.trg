--**************************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Curso e colocar *
--* os campos calculados, número de alunos inscritos e número de docentes, a zero.     *
--************************************************************************************** 
create or replace trigger tbi_curso
  before insert on tbl_curso  
  for each row

begin
     :new.cod_curso := pkg_sequences.proximo_cod_curso;
     :new.num_alunos_inscritos := 0;
     :new.num_docentes := 0;  
end tbi_curso;
/
