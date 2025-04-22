--***********************************************************************************************
--* Trigger que permite actualizar o campo calculado número de alunos inscritos da tabela curso *
--***********************************************************************************************
create or replace trigger taid_frequentar
  after insert or update or delete on tbl_frequentar
  for each row

begin
      if inserting then
        update tbl_curso
        set num_alunos_inscritos = num_alunos_inscritos+1
        where cod_curso = :new.cod_curso;
     elsif deleting then
       update tbl_curso
       set num_alunos_inscritos = num_alunos_inscritos-1
       where cod_curso = :old.cod_curso;
     else
       update tbl_curso
       set num_alunos_inscritos = num_alunos_inscritos-1
       where cod_curso = :old.cod_curso;
       
       update tbl_curso
       set num_alunos_inscritos = num_alunos_inscritos+1
       where cod_curso = :new.cod_curso;
     end if;
end taid_frequentar;
/
