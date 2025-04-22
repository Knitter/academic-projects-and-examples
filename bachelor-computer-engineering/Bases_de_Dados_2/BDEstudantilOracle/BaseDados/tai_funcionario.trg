--**************************************************************************************************************
--* Trigger que permite garantir a participação obrigatória de um funcionário na tabela Docente ou Nao_Docente *
--**************************************************************************************************************
create or replace trigger tai_funcionario
  after insert on tbl_funcionario
  for each row
  
begin
    if :new.tipo = 'D' then
        insert into tbl_docente values(:new.cod_funcionario, 0, 1, 1, 1, 1000);
     else
        insert into tbl_nao_docente values(:new.cod_funcionario, 1, 'N');
     end if;
end tai_funcionario;
/
